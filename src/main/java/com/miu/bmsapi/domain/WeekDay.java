package com.miu.bmsapi.domain;

import com.miu.bmsapi.enums.WeekDays;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeekDay {
    @Id
    @GeneratedValue
    private int id;
    @Enumerated(EnumType.STRING)
    private WeekDays name;
    @OneToMany
    @JoinColumn(name = "weekDayID")
    private List<TimeSlot> timeSlotList = new ArrayList<>();

    public void addTimeSlotList(TimeSlot timeSlot) {
        timeSlotList.add(timeSlot);
    }
}
