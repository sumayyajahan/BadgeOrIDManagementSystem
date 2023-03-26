package com.miu.bmsapi.service;

import com.miu.bmsapi.contract.BadgeProcessRequest;
import com.miu.bmsapi.contract.BadgeProcessResponse;
import com.miu.bmsapi.domain.*;
import com.miu.bmsapi.enums.*;
import com.miu.bmsapi.enums.Role;
import com.miu.bmsapi.repository.BadgeRepository;
import com.miu.bmsapi.service.BadgeService;
import com.miu.bmsapi.service.MembershipService;
import com.miu.bmsapi.service.TransactionService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

import static com.miu.bmsapi.enums.TransactionType.ALLOWED;
import static com.miu.bmsapi.enums.TransactionType.DECLINED;

@Service
@Transactional
public class BadgeServiceImpl implements BadgeService {
    @Autowired
    private BadgeRepository badgeRepository;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private MembershipService membershipService;

    @Override
    public Badge save(Badge badge) {
        return badgeRepository.save(badge);
    }

    @Override
    public Badge update(int id, Badge badge) {
        return badgeRepository.save(badge);
    }

    @Override
    public Badge getById(int id) {
        return badgeRepository.findById(id).orElse(null);
    }

    @Override
    public OperationResult delete(int id) {
        badgeRepository.delete(getById(id));
        return OperationResult.SUCCEED;
    }

    @Override
    public List<Badge> getAll() {
        return badgeRepository.findAll();
    }

    @Override
    public BadgeProcessResponse checkIn(BadgeProcessRequest badgeProcessRequest) {
        Badge badge = badgeRepository.findById(badgeProcessRequest.getBadgeId()).orElse(null);
        if (badge == null) {
            return new BadgeProcessResponse(null, DECLINED, "No badge found with this id.");
        }

        if (!badge.isActive()) {
            return new BadgeProcessResponse(null, DECLINED, "Badge is inactive.");
        }

        Member member = badge.getMember();

        Membership membership = findMembershipIfExists(member.getMembershipList(), badgeProcessRequest.getPlanId());
        if (membership == null) {
            return new BadgeProcessResponse(member, DECLINED, "Don't have membership for this plan.");
        }

        if (!isCheckingInBetweenStartDateAndEndDateOfMembership(badgeProcessRequest.getCalendar(), membership)) {
            return new BadgeProcessResponse(member, DECLINED, "Either membership has ended or not started yet.");
        }

        Location location = findLocationIfExists(membership.getPlan(), badgeProcessRequest.getLocationId());
        if (location == null) {
            return new BadgeProcessResponse(member, DECLINED, "Don't have access to this location.");
        }

        WeekDay weekDay = getWeekDay(location);
        if (!isThisTimeToCheckIn(weekDay, badgeProcessRequest.getCalendar())) {
            return new BadgeProcessResponse(member, DECLINED, "Check in is not allowed today or this time.");
        }

        if (membership.getMembershipType().equals(MembershipType.LIMITED)) {
            if (membership.isMaximumCheckInReached()) {
                return new BadgeProcessResponse(member, DECLINED, "Maximum check in per week/month reached.");
            }
            if (isStudent(member)) {
                if (isCheckingTwiceBetweenAGivenTimeSlot(member, location)) {
                    return new BadgeProcessResponse(member, DECLINED, "You have already checked in for this time slot.");
                }
            }
        }

        membershipService.incrementCurrentCheckInCountForMemberId(membership.getId());
        registerTransaction(badge, membership, location);
        return new BadgeProcessResponse(member, ALLOWED, "Success.");
    }

    private void registerTransaction(Badge badge, Membership membership, Location location) {
        transactionService.save(TransactionEntity.builder()
                .badge(badge)
                .membership(membership)
                .location(location)
                .transactionType(ALLOWED)
                .dateTime(LocalDateTime.now()).build());
    }

    @Override
    public void inactiveAllBadgesOfThisMember(Integer memberId) {
        badgeRepository.inactiveAllBadgesOfThisMember(memberId);
    }

    private WeekDay getWeekDay(Location location) {
        Schedule schedule = location.getSchedule();
        WeekDays today = getWeekDay(Calendar.getInstance().get(Calendar.DAY_OF_WEEK));
        return schedule.getWeekDayList().stream().filter(it -> it.getName().equals(today)).findFirst().orElse(null);
    }

    private Location findLocationIfExists(PlanEntity plan, int locationId) {
        for (Location location : plan.getLocations()) {
            if (location.getId() == locationId) return location;
        }
        return null;
    }

    private boolean isThisTimeToCheckIn(WeekDay weekDay, Calendar calendar) {
        LocalTime localDate = LocalDateTime.ofInstant(calendar.toInstant(), calendar.getTimeZone().toZoneId()).toLocalTime();
        for (TimeSlot timeSlot : weekDay.getTimeSlotList()) {
            if (timeSlot.isBetweenStartTimeAndEndTime(localDate)) {
                return true;
            }
        }
        return false;
    }

    private WeekDays getWeekDay(int i) {
        return switch (i) {
            case 1 -> WeekDays.SUNDAY;
            case 2 -> WeekDays.MONDAY;
            case 3 -> WeekDays.TUESDAY;
            case 4 -> WeekDays.WEDNESDAY;
            case 5 -> WeekDays.THURSDAY;
            case 6 -> WeekDays.FRIDAY;
            case 7 -> WeekDays.SATURDAY;
            default -> null;
        };
    }

    private boolean isCheckingTwiceBetweenAGivenTimeSlot(Member member, Location location) {
        List<TransactionEntity> transactionEntities = transactionService.findByMemberId(member.getId(), LocalDate.now());
        List<TransactionEntity> transactionsOfLocation = transactionEntities.stream()
                .filter(t -> t.getLocation().getId() == location.getId()).toList();
        if (transactionsOfLocation.isEmpty()) { // meaning first transaction of day for this location
            return false;
        }
        TransactionEntity transaction = getMostRecentTransaction(transactionsOfLocation);
        TimeSlot timeSlot = getPresentTimeSlot(location);
        return hasMostRecentTransactionRegisteredInThisTimeSlot(transaction, timeSlot);
    }

    private boolean hasMostRecentTransactionRegisteredInThisTimeSlot(TransactionEntity transaction, TimeSlot timeSlot) {
        return transaction.getDateTime().toLocalTime().isAfter(timeSlot.getStartTime())
                && transaction.getDateTime().toLocalTime().isBefore(timeSlot.getEndTime());
    }

    private TimeSlot getPresentTimeSlot(Location location) {
        LocalTime localTime = LocalTime.now();
        WeekDay weekDay = getWeekDay(location);
        for (TimeSlot timeSlot : weekDay.getTimeSlotList()) {
            System.out.println(timeSlot +" "+timeSlot.isBetweenStartTimeAndEndTime(localTime));
            if (timeSlot.isBetweenStartTimeAndEndTime(localTime)) {
                return timeSlot;
            }
        }
        return weekDay.getTimeSlotList().get(0);
    }

    private TransactionEntity getMostRecentTransaction(List<TransactionEntity> transactions) {
        LocalDateTime localDateTime = transactions.get(0).getDateTime();
        TransactionEntity transaction = transactions.get(0);
        for (int i = 1; i < transactions.size(); i++) {
            if (transactions.get(i).getDateTime().isAfter(localDateTime)) {
                localDateTime = transactions.get(i).getDateTime();
                transaction = transactions.get(i);
            }
        }
        return transaction;
    }

    private boolean isStudent(Member member) {
        return member.getRole().equals(Role.STUDENT);
    }

    private boolean isCheckingInBetweenStartDateAndEndDateOfMembership(Calendar calendar, Membership membership) {
        LocalDate localDate = LocalDateTime.ofInstant(calendar.toInstant(), calendar.getTimeZone().toZoneId()).toLocalDate();
        return localDate.isAfter(membership.getStartDate()) && localDate.isBefore(membership.getEndDate());
    }

    private Membership findMembershipIfExists(List<Membership> memberships, int planId) {
        for (Membership membership : memberships) {
            if (membership.getPlan().getId() == planId) {
                return membership;
            }
        }
        return null;
    }
}
