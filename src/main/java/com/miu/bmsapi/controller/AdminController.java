package com.miu.bmsapi.controller;

import com.miu.bmsapi.enums.OperationResult;
import com.miu.bmsapi.service.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {
    AdminService adminService;

    @PostMapping("/member/{memberId}/badge/{badgeId}")
    public ResponseEntity<OperationResult> assignBadgeToMember(@PathVariable("memberId") Integer memberId, @PathVariable("badgeId") Integer badgeId) {
        return getResponse(adminService.assignBadgeToMember(memberId, badgeId));
    }

    @PostMapping("/member/{memberId}/membership/{membershipId}")
    public ResponseEntity<OperationResult> assignMembershipToMember(@PathVariable("memberId") Integer memberId, @PathVariable("membershipId") Integer membershipId) {
        return getResponse(adminService.assignMembershipToMember(memberId, membershipId));
    }

    @PostMapping("/membership/{membershipId}/plan/{planId}")
    public ResponseEntity<OperationResult> assignPlanToMembership(@PathVariable("membershipId") Integer membershipId, @PathVariable("planId") Integer planId) {
        return getResponse(adminService.assignPlanToMembership(membershipId, planId));
    }

    @PostMapping("/plan/{planId}/location/{locationId}")
    public ResponseEntity<OperationResult> assignLocationToPlan(@PathVariable("planId") Integer planId, @PathVariable("locationId") Integer locationId) {
        return getResponse(adminService.assignLocationToPlan(planId, locationId));
    }

    @PostMapping("/location/{locationId}/schedule/{scheduleId}")
    public ResponseEntity<OperationResult> assignScheduleToLocation(@PathVariable("locationId") Integer locationId, @PathVariable("scheduleId") Integer scheduleId) {
        return getResponse(adminService.assignScheduleToLocation(locationId, scheduleId));
    }

    @PostMapping("/schedule/{scheduleId}/weekday/{weekdayId}")
    public ResponseEntity<OperationResult> assignWeekDayToSchedule(@PathVariable("scheduleId") Integer scheduleId, @PathVariable("weekdayId") Integer weekdayId) {
        return getResponse(adminService.assignWeekDayToSchedule(scheduleId, weekdayId));
    }

    @PostMapping("/weekday/{weekId}/timeslot/{timeslotId}")
    public ResponseEntity<OperationResult> assignTimeslotToWeekDay(@PathVariable("weekId") Integer weekId, @PathVariable("timeslotId") Integer timeslotId) {
        return getResponse(adminService.assignTimeslotToWeekDay(weekId, timeslotId));
    }

    public ResponseEntity<OperationResult> getResponse(OperationResult operationResult) {
        if (operationResult.equals(OperationResult.FAILED))
            return ResponseEntity.badRequest().body(operationResult);
        return ResponseEntity.ok(operationResult);
    }
}
