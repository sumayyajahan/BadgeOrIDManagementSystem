package com.miu.bmsapi.controller;


import com.miu.bmsapi.domain.Location;
import com.miu.bmsapi.domain.PlanEntity;
import com.miu.bmsapi.enums.OperationResult;
import com.miu.bmsapi.service.*;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/plans")
@AllArgsConstructor
public class PlanController {
    private PlanService planService;

    @PostMapping
    public ResponseEntity<PlanEntity> save(@RequestBody PlanEntity plan) {
        return new ResponseEntity<>(planService.save(plan), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlanEntity>> getAll() {
        return ResponseEntity.ok(planService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanEntity> getById(@PathVariable int id) {
        PlanEntity plan = planService.getById(id);
        if (plan == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(plan);
    }

    @GetMapping("/{planId}/locations")
    public ResponseEntity<List<Location>> getAllTransactions(@PathVariable int planId) {
        PlanEntity plan = planService.getById(planId);
        if (plan == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(plan.getLocations());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanEntity> update(@PathVariable int id, @RequestBody PlanEntity planEntity) {
        PlanEntity plan = planService.getById(id);
        if (plan == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(planService.update(id, planEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OperationResult> delete(@PathVariable int id) {
        PlanEntity plan = planService.getById(id);
        if (plan == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(planService.delete(id));
    }
}
