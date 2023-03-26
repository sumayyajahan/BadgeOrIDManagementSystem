package com.miu.bmsapi.event;

import com.miu.bmsapi.domain.Membership;
import com.miu.bmsapi.enums.MembershipType;
import com.miu.bmsapi.enums.Role;
import com.miu.bmsapi.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResetAllowanceCounterJob {
    @Autowired
    private MembershipService memberService;

    //weekly counter reset for students
    @Scheduled(cron = "* * 3 * * 1")
    public void restCount() {
        List<Membership> membershipsToReset = memberService.getAll().parallelStream()
                .filter(it -> it.getMembershipType().equals(MembershipType.LIMITED))
                .filter(it -> it.getMember().getRole().equals(Role.STUDENT))
                .filter(Membership::isMembershipActive)
                .toList();

        for (Membership membership : membershipsToReset) {
            //TODO lets create a query which resets the checkIn counter to zero when given a membership id
            membership.setCurrentCheckIn(0);
            memberService.save(membership);
        }
    }

    //Monthly counter reset for others
    @Scheduled(cron = "* 0 3 1 * *")
    public void restCountMonthly() {
        List<Membership> membershipsToReset = memberService.getAll().parallelStream()
                .filter(it -> it.getMembershipType().equals(MembershipType.LIMITED))
                .filter(it -> !it.getMember().getRole().equals(Role.STUDENT))
                .filter(Membership::isMembershipActive)
                .toList();

        for (Membership membership : membershipsToReset) {
            //TODO lets create a query which resets the checkIn counter to zero when given a membership id
            membership.setCurrentCheckIn(0);
            memberService.save(membership);
        }
    }
}
