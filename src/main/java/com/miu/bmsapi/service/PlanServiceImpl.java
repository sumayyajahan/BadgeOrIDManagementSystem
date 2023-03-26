package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.Location;
import com.miu.bmsapi.domain.PlanEntity;
import com.miu.bmsapi.enums.OperationResult;
import com.miu.bmsapi.repository.PlanRepository;
import com.miu.bmsapi.service.LocationService;
import com.miu.bmsapi.service.PlanService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PlanServiceImpl implements PlanService {
    private PlanRepository planRepository;
    private LocationService locationService;

    @Override
    public PlanEntity save(PlanEntity plan) {
        return planRepository.save(plan);
    }

    @Override
    public PlanEntity update(int id, PlanEntity plan) {
        return planRepository.save(plan);
    }

    @Override
    public PlanEntity getById(int id) {
        return planRepository.findById(id).orElse(null);
    }

    @Override
    public List<PlanEntity> getAll() {
        return planRepository.findAll();
    }

    @Override
    public OperationResult delete(int id) {
        planRepository.delete(getById(id));
        return OperationResult.SUCCEED;
    }

    @Override
    public OperationResult assignLocationToPlan(Integer planId, Integer locationId) {
        PlanEntity plan = getById(planId);
        Location location = locationService.getById(locationId);
        if (null == location || null == plan) {
            return OperationResult.FAILED;
        }
        plan.addLocation(location);
        save(plan);
        return OperationResult.SUCCEED;
    }
}
