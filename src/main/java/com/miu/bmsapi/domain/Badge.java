package com.miu.bmsapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Badge {
    @Id
    @GeneratedValue
    private int id;
    private boolean active;
    @JsonIgnore
    @ManyToOne
    private Member member;
}
