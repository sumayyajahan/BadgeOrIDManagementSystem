package com.miu.bmsapi.controller;


import com.miu.bmsapi.domain.*;
import com.miu.bmsapi.enums.OperationResult;
import com.miu.bmsapi.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
@AllArgsConstructor
public class LocationController {
    private LocationService locationService;

    @PostMapping
    public ResponseEntity<Location> save(@RequestBody Location location) {
        return ResponseEntity.ok(locationService.save(location));
    }

    @GetMapping
    public ResponseEntity<List<Location>> getAll() {
        return ResponseEntity.ok(locationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getById(@PathVariable int id) {
        Location location = locationService.getById(id);
        if (location == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(location);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> update(@PathVariable int id, @RequestBody Location location) {
        Location l = locationService.getById(id);
        if (l == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(locationService.update(id, location));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OperationResult> delete(@PathVariable int id) {
        Location location = locationService.getById(id);
        if (location == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(locationService.delete(id));
    }
}
