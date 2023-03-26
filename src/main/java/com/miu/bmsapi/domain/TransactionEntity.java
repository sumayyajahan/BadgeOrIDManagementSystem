package com.miu.bmsapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.miu.bmsapi.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionEntity {
    @Id
    @GeneratedValue
    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss.SSSSSS")
    private LocalDateTime dateTime;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private String transactionTypeDescription;
    @ManyToOne
    @JoinColumn(name = "badgeID")
    private Badge badge;
    @ManyToOne
    @JoinColumn(name = "membershipID")
    private Membership membership;
    @ManyToOne
    @JoinColumn(name = "locationID")
    private Location location;
}
