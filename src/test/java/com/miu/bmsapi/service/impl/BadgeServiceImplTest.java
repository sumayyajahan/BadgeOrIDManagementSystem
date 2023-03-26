package com.miu.bmsapi.service.impl;

import com.miu.bmsapi.contract.BadgeProcessRequest;
import com.miu.bmsapi.contract.BadgeProcessResponse;
import com.miu.bmsapi.domain.*;
import com.miu.bmsapi.enums.*;
import com.miu.bmsapi.enums.Role;
import com.miu.bmsapi.repository.BadgeRepository;
import com.miu.bmsapi.service.BadgeService;
import com.miu.bmsapi.service.BadgeServiceImpl;
import com.miu.bmsapi.service.MembershipService;
import com.miu.bmsapi.service.TransactionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;


import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
class BadgeServiceImplTest {

    @TestConfiguration
    static class BadgeServiceImplTestContextConfiguration {
        @Bean
        public BadgeService badgeService() {
            return new BadgeServiceImpl();
        }
    }

    @Autowired
    private BadgeService badgeService;

    @MockBean
    private BadgeRepository badgeRepository;

    @MockBean
    private TransactionService transactionService;

    @MockBean
    private MembershipService membershipService;

    @BeforeEach
    void setUp() {
        // assuming argiro
        Badge badge = new Badge(1, true, getMember());
        Mockito.when(badgeRepository.findById(1)).thenReturn(Optional.of(badge));
        Mockito.when(badgeRepository.findById(2)).thenReturn(null);
    }

    private Member getMember() {
        Member member = Member.builder().id(1).firstName("Vishal").lastName("Kumar").role(Role.STUDENT).build();
        member.setMembershipList(getMemberships(member));
        member.setBadgeList(getBadges(member));
        return member;
    }

    private List<Badge> getBadges(Member member) {
        return List.of();
    }

    private List<Membership> getMemberships(Member member) {
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 6, 1);
        LocalDate lastUpdate = LocalDate.of(2022, 2, 1);
        return List.of(new Membership(1,
                startDate,
                endDate,
                MembershipType.LIMITED,
                AllowanceCounterResetCycle.WEEKLY,
                lastUpdate,
                20,
                0,
                getPlan(),
                member
        ));
    }

    private PlanEntity getPlan() {
        return new PlanEntity(1, "meal-plan", "argiro", getLocations());
    }

    private List<Location> getLocations() {
        return List.of();
    }

    private Schedule getSchedule() {
        return new Schedule(1, "argiro-schedule", getWeekDays());
    }

    private List<WeekDay> getWeekDays() {
        return List.of(
                new WeekDay(1, WeekDays.SUNDAY, getTimeSlot())
        );
    }

    private List<TimeSlot> getTimeSlot() {
        return List.of(
                new TimeSlot(1, LocalTime.of(8, 30, 0), LocalTime.of(10, 0, 0)),
                new TimeSlot(2, LocalTime.of(12, 0, 0), LocalTime.of(13, 30, 0)),
                new TimeSlot(3, LocalTime.of(18, 0, 0), LocalTime.of(19, 30, 0)));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void checkIn_when_badgeIdDoesNotExists_returnDeny() {
        //given

        //when
        BadgeProcessResponse badgeProcessResponse = badgeService.checkIn(
                new BadgeProcessRequest(2, 1, 1, 1, Calendar.getInstance()));

        //then
        assertEquals(badgeProcessResponse.getTransactionType(), TransactionType.DECLINED);
    }
}