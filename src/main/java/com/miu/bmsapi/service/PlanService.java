package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.PlanEntity;
import com.miu.bmsapi.enums.OperationResult;

import java.util.List;

public interface PlanService extends GenericService<PlanEntity> {
    PlanEntity save(PlanEntity plan);

    PlanEntity update(int id, PlanEntity plan);

    PlanEntity getById(int id);

    List<PlanEntity> getAll();

    OperationResult assignLocationToPlan(Integer planId, Integer locationId);
}
