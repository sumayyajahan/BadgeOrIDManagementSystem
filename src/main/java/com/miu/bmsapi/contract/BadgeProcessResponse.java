package com.miu.bmsapi.contract;

import com.miu.bmsapi.domain.Member;
import com.miu.bmsapi.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Calendar;

@Data
@AllArgsConstructor
public class BadgeProcessResponse {
    private Member member;
    private TransactionType transactionType;
    private String reason;
}
