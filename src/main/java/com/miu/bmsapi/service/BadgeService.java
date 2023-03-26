package com.miu.bmsapi.service;

import com.miu.bmsapi.contract.BadgeProcessRequest;
import com.miu.bmsapi.contract.BadgeProcessResponse;
import com.miu.bmsapi.domain.Badge;

public interface BadgeService extends GenericService<Badge> {
    BadgeProcessResponse checkIn(BadgeProcessRequest badgeProcessRequest);

    void inactiveAllBadgesOfThisMember(Integer memberId);
}
