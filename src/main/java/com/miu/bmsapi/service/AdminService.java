package com.miu.bmsapi.service;

import com.miu.bmsapi.enums.OperationResult;

public interface AdminService {
    OperationResult assignBadgeToMember(Integer memberId, Integer badgeId);

    OperationResult assignMembershipToMember(Integer memberId, Integer membershipId);

    OperationResult assignPlanToMembership(Integer membershipId, Integer planId);

    OperationResult assignLocationToPlan(Integer planId, Integer locationId);

    OperationResult assignScheduleToLocation(Integer locationId, Integer scheduleId);

    OperationResult assignWeekDayToSchedule(Integer scheduleId, Integer weekdayId);

    OperationResult assignTimeslotToWeekDay(Integer weekId, Integer timeslotId);
}
