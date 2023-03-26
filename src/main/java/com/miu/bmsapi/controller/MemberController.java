package com.miu.bmsapi.controller;

import com.miu.bmsapi.domain.*;
import com.miu.bmsapi.enums.OperationResult;
import com.miu.bmsapi.service.*;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/members")
@AllArgsConstructor
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Member> save(@RequestBody Member member) {
        return new ResponseEntity<>(memberService.save(member), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAll() {
        return ResponseEntity.ok(memberService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getById(@PathVariable int id) {
        Member member = memberService.getById(id);
        if (member == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(member);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> update(@PathVariable int id, @RequestBody Member member) {
        Member mem = memberService.getById(id);
        if (mem == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(memberService.update(id, member));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OperationResult> delete(@PathVariable int id) {
        Member member = memberService.getById(id);
        if (member == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(memberService.delete(id));
    }

    @GetMapping("/{memberId}/transactions")
    public ResponseEntity<List<TransactionEntity>> getAllTransactions(@PathVariable int memberId) {
        Member member = memberService.getById(memberId);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transactionService.findByMemberId(memberId));
    }

    @GetMapping("/{memberId}/plans")
    public ResponseEntity<List<PlanEntity>> getAllPlans(@PathVariable int memberId) {
        Member member = memberService.getById(memberId);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(member.getMembershipList().stream().map(Membership::getPlan).toList());
    }

    @GetMapping("/{memberId}/badges")
    public ResponseEntity<List<Badge>> getAllBadges(@PathVariable int memberId) {
        Member member = memberService.getById(memberId);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(member.getBadgeList());
    }
    @GetMapping("/{memberId}/badges/active")
    public ResponseEntity<Badge> getAllActiveBadges(@PathVariable int memberId) {
        Member member = memberService.getById(memberId);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(member.getBadgeList().stream().filter(Badge::isActive).findFirst().orElse(null));
    }

    @GetMapping("/{memberId}/memberships")
    public ResponseEntity<List<Membership>> getAllMembership(@PathVariable int memberId) {
        Member member = memberService.getById(memberId);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(member.getMembershipList());
    }
}
