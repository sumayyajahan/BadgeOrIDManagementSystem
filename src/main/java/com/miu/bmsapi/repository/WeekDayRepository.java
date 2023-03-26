package com.miu.bmsapi.repository;

import com.miu.bmsapi.domain.WeekDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekDayRepository extends JpaRepository<WeekDay, Integer> {
}
