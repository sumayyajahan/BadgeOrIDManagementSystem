package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.Membership;
import com.miu.bmsapi.enums.OperationResult;

public interface MembershipService extends GenericService<Membership>{
    OperationResult assignMembership(Integer memberId, Integer badgeId);
    OperationResult assignPlanToMembership(Integer membershipId, Integer planId);
    void incrementCurrentCheckInCountForMemberId(int id);
}
