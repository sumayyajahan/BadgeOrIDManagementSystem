package com.miu.bmsapi.controller;

import com.miu.bmsapi.contract.BadgeProcessRequest;
import com.miu.bmsapi.contract.BadgeProcessResponse;
import com.miu.bmsapi.domain.Badge;
import com.miu.bmsapi.enums.OperationResult;
import com.miu.bmsapi.service.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/badges")
@AllArgsConstructor
public class BadgeController {
    private BadgeService badgeService;

    @PostMapping
    public ResponseEntity<Badge> save(@RequestBody Badge badge) {
        return ResponseEntity.ok(badgeService.save(badge));
    }

    @GetMapping
    public ResponseEntity<List<Badge>> getAll() {
        return ResponseEntity.ok(badgeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Badge> getById(@PathVariable int id) {
        Badge badge = badgeService.getById(id);
        if (badge == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(badge);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Badge> update(@PathVariable int id, @RequestBody Badge badge) {
        Badge b = badgeService.getById(id);
        if (b == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(badgeService.update(id, badge));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OperationResult> delete(@PathVariable int id) {
        Badge badge = badgeService.getById(id);
        if (badge == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(badgeService.delete(id));
    }

    @PostMapping("/process")
    public ResponseEntity<BadgeProcessResponse> checkIn(@RequestBody BadgeProcessRequest badgeProcessRequest) {
        return null;
//        return ResponseEntity.ok(badgeService.checkIn(badgeProcessRequest));
    }
}


