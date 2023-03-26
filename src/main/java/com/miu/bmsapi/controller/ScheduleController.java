package com.miu.bmsapi.controller;

import com.miu.bmsapi.domain.Schedule;
import com.miu.bmsapi.enums.OperationResult;
import com.miu.bmsapi.service.*;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/schedules")
@AllArgsConstructor
public class ScheduleController {
    private ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<Schedule> save(@RequestBody Schedule schedule) {
        return new ResponseEntity<>(scheduleService.save(schedule), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Schedule>> getAll() {
        return ResponseEntity.ok(scheduleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getById(@PathVariable int id) {
        Schedule schedule = scheduleService.getById(id);
        if (schedule == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(schedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> update(@PathVariable int id, @RequestBody Schedule schedule) {
        Schedule s = scheduleService.getById(id);
        if (s == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(scheduleService.update(id, schedule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OperationResult> delete(@PathVariable int id) {
        Schedule schedule = scheduleService.getById(id);
        if (schedule == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(scheduleService.delete(id));
    }
}
