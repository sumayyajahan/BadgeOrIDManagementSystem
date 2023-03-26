package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.*;
import com.miu.bmsapi.enums.OperationResult;
import com.miu.bmsapi.repository.TransactionRepository;
import com.miu.bmsapi.service.TransactionService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private TransactionRepository transactionRepository;

    @Override
    public TransactionEntity save(TransactionEntity transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public TransactionEntity update(int id, TransactionEntity transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public TransactionEntity getById(int id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public List<TransactionEntity> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    public List<TransactionEntity> findByMemberId(int memberId) {
        return transactionRepository.findByMemberId(memberId);
    }

    @Override
    public List<TransactionEntity> findByMemberId(int id, LocalDate now) {
        return transactionRepository.findByMemberId(id).parallelStream()
                .filter(it -> it.getDateTime().getYear() == now.getYear())
                .filter(it -> it.getDateTime().getMonth() == now.getMonth())
                .filter(it -> it.getDateTime().getDayOfMonth() == now.getDayOfMonth())
                .toList();
        //TODO make this method work
//        return transactionRepository.findByMemberId(id, LocalDate.now());
    }

    @Override
    public OperationResult delete(int id) {
        transactionRepository.delete(getById(id));
        return OperationResult.SUCCEED;
    }
}
