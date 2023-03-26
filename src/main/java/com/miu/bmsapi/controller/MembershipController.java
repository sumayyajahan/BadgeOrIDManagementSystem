package com.miu.bmsapi.controller;

import com.miu.bmsapi.domain.Membership;
import com.miu.bmsapi.enums.OperationResult;
import com.miu.bmsapi.service.*;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/memberships")
public class MembershipController {
    private MembershipService membershipService;

    @PostMapping
    public ResponseEntity<Membership> save(@RequestBody Membership membership) {
        return new ResponseEntity<>(membershipService.save(membership), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Membership>> getAll() {
        return ResponseEntity.ok(membershipService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membership> getById(@PathVariable int id) {
        Membership membership = membershipService.getById(id);
        if (membership == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(membership);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Membership> update(@PathVariable int id, @RequestBody Membership membership) {
        Membership mem = membershipService.getById(id);
        if (mem == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(membershipService.update(id, membership));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OperationResult> delete(@PathVariable int id) {
        Membership membership = membershipService.getById(id);
        if (membership == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(membershipService.delete(id));
    }
}
