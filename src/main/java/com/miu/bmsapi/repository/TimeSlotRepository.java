package com.miu.bmsapi.repository;

import com.miu.bmsapi.domain.TimeSlot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotRepository extends CrudRepository<TimeSlot, Integer> {
}
