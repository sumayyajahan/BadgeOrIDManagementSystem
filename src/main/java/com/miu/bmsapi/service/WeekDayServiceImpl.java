package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.TimeSlot;
import com.miu.bmsapi.domain.WeekDay;
import com.miu.bmsapi.enums.OperationResult;
import com.miu.bmsapi.repository.WeekDayRepository;
import com.miu.bmsapi.service.TimeSlotService;
import com.miu.bmsapi.service.WeekDayService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class WeekDayServiceImpl implements WeekDayService {
    private TimeSlotService timeSlotService;
    private WeekDayRepository weekDayRepository;

    @Override
    public WeekDay save(WeekDay weekDay) {
        return weekDayRepository.save(weekDay);
    }

    @Override
    public WeekDay update(int id, WeekDay weekDay) {
        return null;
    }

    @Override
    public WeekDay getById(int id) {
        return weekDayRepository.findById(id).orElse(null);
    }

    @Override
    public OperationResult delete(int id) {
        weekDayRepository.delete(getById(id));
        return OperationResult.SUCCEED;
    }

    @Override
    public List<WeekDay> getAll() {
        return weekDayRepository.findAll();
    }

    @Override
    public OperationResult assignTimeSlotToWeekDay(Integer weekId, Integer timeslotId) {
        TimeSlot timeSlot = timeSlotService.getById(timeslotId);
        WeekDay weekDay = weekDayRepository.findById(weekId).orElse(null);
        if (null == timeSlot || null == weekDay) {
            return OperationResult.FAILED;
        }
        weekDay.addTimeSlotList(timeSlot);
        weekDayRepository.save(weekDay);
        return OperationResult.SUCCEED;
    }
}
