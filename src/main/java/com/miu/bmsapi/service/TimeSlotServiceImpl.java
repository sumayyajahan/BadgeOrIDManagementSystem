package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.TimeSlot;
import com.miu.bmsapi.enums.OperationResult;
import com.miu.bmsapi.repository.TimeSlotRepository;
import com.miu.bmsapi.service.TimeSlotService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TimeSlotServiceImpl implements TimeSlotService {
    private TimeSlotRepository timeSlotRepository;

    @Override
    public TimeSlot save(TimeSlot timeSlot) {
        return timeSlotRepository.save(timeSlot);
    }

    @Override
    public TimeSlot update(int id, TimeSlot timeSlot) {
        return timeSlotRepository.save(timeSlot);
    }

    @Override
    public TimeSlot getById(int id) {
        return timeSlotRepository.findById(id).orElse(null);
    }

    @Override
    public List<TimeSlot> getAll() {
        return (List<TimeSlot>) timeSlotRepository.findAll();
    }

    @Override
    public OperationResult delete(int id) {
        timeSlotRepository.delete(getById(id));
        return OperationResult.SUCCEED;
    }
}
