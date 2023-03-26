package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.Location;
import com.miu.bmsapi.enums.OperationResult;

public interface LocationService extends GenericService<Location> {
    OperationResult assignScheduleToLocation(Integer locationId, Integer scheduleId);
}
