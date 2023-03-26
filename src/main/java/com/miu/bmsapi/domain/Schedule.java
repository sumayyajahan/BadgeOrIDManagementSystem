package com.miu.bmsapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Schedule {
    @Id
    @GeneratedValue
    private int Id;
    private String name;
    @OneToMany
    @JoinColumn(name = "scheduleID")
    private List<WeekDay> weekDayList;
    public void addWeekDay(WeekDay weekDay){
        weekDayList.add(weekDay);
    }
}
