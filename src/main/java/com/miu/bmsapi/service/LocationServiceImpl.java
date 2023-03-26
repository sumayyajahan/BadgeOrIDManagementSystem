package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.Location;
import com.miu.bmsapi.domain.Schedule;
import com.miu.bmsapi.enums.OperationResult;
import com.miu.bmsapi.repository.LocationRepository;
import com.miu.bmsapi.service.LocationService;
import com.miu.bmsapi.service.ScheduleService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {
    private LocationRepository locationRepository;
    private ScheduleService scheduleService;

    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location update(int id, Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location getById(int id) {
        return locationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    @Override
    public OperationResult delete(int id) {
        locationRepository.delete(getById(id));
        return OperationResult.SUCCEED;
    }

    @Override
    public OperationResult assignScheduleToLocation(Integer locationId, Integer scheduleId) {
        Location location = getById(locationId);
        Schedule schedule = scheduleService.getById(scheduleId);
        if (null == location || null == schedule) {
            return OperationResult.FAILED;
        }
        location.setSchedule(schedule);
        save(location);
        return OperationResult.SUCCEED;
    }
}
