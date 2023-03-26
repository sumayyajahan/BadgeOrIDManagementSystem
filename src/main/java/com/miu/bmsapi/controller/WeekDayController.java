package com.miu.bmsapi.controller;

import com.miu.bmsapi.domain.WeekDay;
import com.miu.bmsapi.enums.OperationResult;
import com.miu.bmsapi.service.*;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/week-days")
@AllArgsConstructor
public class WeekDayController {
    private WeekDayService weekDayService;

    @PostMapping
    public ResponseEntity<WeekDay> save(@RequestBody WeekDay weekDay) {
        return new ResponseEntity<>(weekDayService.save(weekDay), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<WeekDay>> getAll() {
        return ResponseEntity.ok(weekDayService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeekDay> getById(@PathVariable int id) {
        WeekDay weekDay = weekDayService.getById(id);
        if (weekDay == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(weekDayService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WeekDay> update(@PathVariable int id, @RequestBody WeekDay day) {
        WeekDay weekDay = weekDayService.getById(id);
        if (weekDay == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(weekDayService.update(id, day));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OperationResult> delete(@PathVariable int id) {
        WeekDay weekDay = weekDayService.getById(id);
        if (weekDay == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(weekDayService.delete(id));
    }
}
