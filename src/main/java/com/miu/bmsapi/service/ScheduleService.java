package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.Schedule;
import com.miu.bmsapi.enums.OperationResult;

import java.util.List;

public interface ScheduleService extends GenericService<Schedule> {
    Schedule save(Schedule schedule);

    Schedule update(int id, Schedule schedule);

    Schedule getById(int id);

    List<Schedule> getAll();

    OperationResult assignWeekDayToSchedule(Integer scheduleId, Integer weekdayId);
}
