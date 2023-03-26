package com.miu.bmsapi.repository;

import com.miu.bmsapi.domain.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Integer> {

    @Query("UPDATE Badge b SET b.active = false WHERE b.member.id =:memberId")
    void inactiveAllBadgesOfThisMember(Integer memberId);
}
