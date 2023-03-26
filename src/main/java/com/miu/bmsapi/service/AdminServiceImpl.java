package com.miu.bmsapi.service;

import com.miu.bmsapi.enums.OperationResult;
import com.miu.bmsapi.service.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private MemberService memberService;
    private MembershipService membershipService;
    private LocationService locationService;
    private ScheduleService scheduleService;
    private PlanService planService;
    private WeekDayService weekDayService;

    @Override
    public OperationResult assignBadgeToMember(Integer memberId, Integer badgeId) {
        return memberService.assignBadge(memberId, badgeId);
    }

    @Override
    public OperationResult assignMembershipToMember(Integer memberId, Integer badgeId) {
        return membershipService.assignMembership(memberId, badgeId);
    }

    @Override
    public OperationResult assignPlanToMembership(Integer membershipId, Integer planId) {
        return membershipService.assignPlanToMembership(membershipId, planId);
    }

    @Override
    public OperationResult assignLocationToPlan(Integer planId, Integer locationId) {
        return planService.assignLocationToPlan(planId, locationId);
    }

    @Override
    public OperationResult assignScheduleToLocation(Integer locationId, Integer scheduleId) {
        return locationService.assignScheduleToLocation(locationId, scheduleId);
    }

    @Override
    public OperationResult assignWeekDayToSchedule(Integer scheduleId, Integer weekdayId) {
        return scheduleService.assignWeekDayToSchedule(scheduleId, weekdayId);
    }

    @Override
    public OperationResult assignTimeslotToWeekDay(Integer weekId, Integer timeslotId) {
        return weekDayService.assignTimeSlotToWeekDay(weekId, timeslotId);
    }
}
