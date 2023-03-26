package com.miu.bmsapi.repository;

import com.miu.bmsapi.domain.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Integer> {
    @Query("UPDATE Membership e SET e.currentCheckIn = FUNCTION('ABS', e.currentCheckIn + 1) WHERE e.member.id = :id")
    void incrementCurrentCheckInCountForMemberId(int id);

}
