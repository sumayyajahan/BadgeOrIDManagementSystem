package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.Schedule;
import com.miu.bmsapi.domain.WeekDay;
import com.miu.bmsapi.enums.OperationResult;
import com.miu.bmsapi.repository.ScheduleRepository;
import com.miu.bmsapi.service.ScheduleService;
import com.miu.bmsapi.service.WeekDayService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private ScheduleRepository scheduleRepository;
    private WeekDayService weekDayRepo;

    @Override
    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule update(int id, Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule getById(int id) {
        return scheduleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Schedule> getAll() {
        return (List<Schedule>) scheduleRepository.findAll();
    }

    @Override
    public OperationResult delete(int id) {
        scheduleRepository.delete(getById(id));
        return OperationResult.SUCCEED;
    }

    @Override
    public OperationResult assignWeekDayToSchedule(Integer scheduleId, Integer weekdayId) {
        WeekDay weekDay = weekDayRepo.getById(weekdayId);
        Schedule schedule = getById(scheduleId);
        if (weekDay == null || schedule == null) {
            return OperationResult.FAILED;
        }
        schedule.addWeekDay(weekDay);
        save(schedule);
        return OperationResult.SUCCEED;
    }
}
