package com.miu.bmsapi.domain;

import com.miu.bmsapi.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "member")
    private List<Membership> membershipList = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Badge> badgeList = new ArrayList<>();
}
