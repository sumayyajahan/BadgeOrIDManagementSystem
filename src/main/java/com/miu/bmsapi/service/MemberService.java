package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.Member;
import com.miu.bmsapi.enums.OperationResult;

public interface MemberService extends GenericService<Member> {
    OperationResult assignBadge(Integer memberId, Integer badgeId);
}
