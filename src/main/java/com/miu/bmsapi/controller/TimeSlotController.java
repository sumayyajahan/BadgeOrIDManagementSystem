package com.miu.bmsapi.controller;

import com.miu.bmsapi.domain.TimeSlot;
import com.miu.bmsapi.enums.OperationResult;
import com.miu.bmsapi.service.TimeSlotService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/timeslots")
@AllArgsConstructor
public class TimeSlotController {
    private TimeSlotService timeSlotService;

    @PostMapping
    public ResponseEntity<TimeSlot> save(@RequestBody TimeSlot timeSlot) {
        return new ResponseEntity<>(timeSlotService.save(timeSlot), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TimeSlot>> getAll() {
        return ResponseEntity.ok(timeSlotService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeSlot> getById(@PathVariable int id) {
        TimeSlot timeSlot = timeSlotService.getById(id);
        if (timeSlot == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(timeSlotService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimeSlot> update(@PathVariable int id, @RequestBody TimeSlot timeSlot) {
        TimeSlot ts = timeSlotService.getById(id);
        if (ts == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(timeSlotService.update(id, timeSlot));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OperationResult> delete(@PathVariable int id) {
        TimeSlot timeSlot = timeSlotService.getById(id);
        if (timeSlot == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(timeSlotService.delete(id));
    }
}
