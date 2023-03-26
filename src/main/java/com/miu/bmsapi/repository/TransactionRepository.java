package com.miu.bmsapi.repository;

import com.miu.bmsapi.domain.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {
    //TODO make this query work
//    @Query("SELECT t FROM TransactionEntity t where t.badge.member.id = :memberId and DATE(t.dateTime) = :today")
//    List<TransactionEntity> findByMemberId(int memberId, LocalDate today);

    @Query("SELECT t FROM TransactionEntity t where t.badge.member.id = :memberId")
    List<TransactionEntity> findByMemberId(int memberId);
}
