package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.TransactionEntity;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService extends GenericService<TransactionEntity> {
    TransactionEntity save(TransactionEntity transaction);

    TransactionEntity update(int id, TransactionEntity transaction);

    TransactionEntity getById(int id);

    List<TransactionEntity> getAll();

    List<TransactionEntity> findByMemberId(int memberId);

    List<TransactionEntity> findByMemberId(int id, LocalDate now);
}
