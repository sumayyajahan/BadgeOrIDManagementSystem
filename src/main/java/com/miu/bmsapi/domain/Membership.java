package com.miu.bmsapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miu.bmsapi.enums.AllowanceCounterResetCycle;
import com.miu.bmsapi.enums.MembershipType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Membership {
    @Id
    @GeneratedValue
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private MembershipType membershipType;
    @Enumerated(EnumType.STRING)
    private AllowanceCounterResetCycle resetCycle; // we can use this if there are more than one role which needs to be reset weekly/monthly
    private LocalDate lastRestDate; // we can use this one if we plan to reset every 4 weeks for the monthly reset plan
    private int allowedCheckIn;
    private int currentCheckIn;
    @ManyToOne
    private PlanEntity plan;
    @JsonIgnore
    @ManyToOne
    private Member member;

    public boolean isMaximumCheckInReached() {
        return currentCheckIn >= allowedCheckIn;
    }

    public boolean isMembershipActive() { // A membership is considered active if it is between start and end date
        return LocalDate.now().isAfter(startDate) && LocalDate.now().isBefore(endDate);
    }
}
