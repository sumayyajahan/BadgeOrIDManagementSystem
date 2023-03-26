package com.miu.bmsapi.controller;

import com.miu.bmsapi.domain.TransactionEntity;
import com.miu.bmsapi.enums.OperationResult;
import com.miu.bmsapi.service.*;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/transactions")
@AllArgsConstructor
public class TransactionController {
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionEntity> save(@RequestBody TransactionEntity transaction) {
        return new ResponseEntity<>(transactionService.save(transaction), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TransactionEntity>> getAll() {
        return ResponseEntity.ok(transactionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionEntity> getById(@PathVariable int id) {
        TransactionEntity transaction = transactionService.getById(id);
        if (transaction == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(transaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionEntity> update(@PathVariable int id, @RequestBody TransactionEntity transaction) {
        TransactionEntity t = transactionService.getById(id);
        if (t == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(transactionService.update(id, transaction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OperationResult> delete(@PathVariable int id) {
        TransactionEntity transaction = transactionService.getById(id);
        if (transaction == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(transactionService.delete(id));
    }
}
