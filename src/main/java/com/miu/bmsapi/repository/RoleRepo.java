package com.miu.bmsapi.repository;

import com.miu.bmsapi.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Integer> {
    Role findByRole(String role);
}
