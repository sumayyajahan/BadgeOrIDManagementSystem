package com.miu.bmsapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miu.bmsapi.enums.LocationType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private int capacity;
    @Enumerated(EnumType.STRING)
    private LocationType type;
    @OneToOne
    private Schedule schedule;

    @JsonIgnore
    @ManyToOne
    private PlanEntity planEntity;
}
