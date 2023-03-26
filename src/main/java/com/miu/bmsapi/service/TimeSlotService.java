package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.TimeSlot;

import java.util.List;

public interface TimeSlotService extends GenericService<TimeSlot> {

    TimeSlot save(TimeSlot timeSlot);

    TimeSlot update(int id, TimeSlot timeSlot);

    TimeSlot getById(int id);

    List<TimeSlot> getAll();
}
