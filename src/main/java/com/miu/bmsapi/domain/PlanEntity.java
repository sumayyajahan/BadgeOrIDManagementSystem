package com.miu.bmsapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanEntity {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "planEntity")
    private List<Location> locations;
    public void addLocation(Location location){
        locations.add(location);
    }
}
