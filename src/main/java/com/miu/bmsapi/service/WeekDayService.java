package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.WeekDay;
import com.miu.bmsapi.enums.OperationResult;

public interface WeekDayService extends GenericService<WeekDay> {
    OperationResult assignTimeSlotToWeekDay(Integer weekId, Integer timeslotId);
}
