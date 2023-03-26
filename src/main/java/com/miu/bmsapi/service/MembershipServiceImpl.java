package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.Member;
import com.miu.bmsapi.domain.Membership;
import com.miu.bmsapi.domain.PlanEntity;
import com.miu.bmsapi.enums.OperationResult;
import com.miu.bmsapi.repository.MemberRepository;
import com.miu.bmsapi.repository.MembershipRepository;
import com.miu.bmsapi.service.MembershipService;
import com.miu.bmsapi.service.PlanService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class MembershipServiceImpl implements MembershipService {
    private MembershipRepository membershipRepository;
    private MemberRepository memberRepository; // using repository because service creating a circular dependency.
    private PlanService planService;

    @Override
    public Membership save(Membership membership) {
        return membershipRepository.save(membership);
    }

    @Override
    public Membership update(int id, Membership membership) {
        return membershipRepository.save(membership);
    }

    @Override
    public Membership getById(int id) {
        return membershipRepository.findById(id).orElse(null);
    }

    @Override
    public List<Membership> getAll() {
        return membershipRepository.findAll();
    }

    @Override
    public OperationResult delete(int id) {
        membershipRepository.delete(getById(id));
        return OperationResult.SUCCEED;
    }

    @Override
    public OperationResult assignMembership(Integer memberId, Integer membershipId) {
        Member member = memberRepository.findById(memberId).orElse(null);
        Membership membership = getById(membershipId);
        if (member == null || membership == null) {
            return OperationResult.FAILED;
        }

        // ASSUMPTION: For now everyone is allowed to subscribe to any plan, every plan has all roles as allowed roles
//        if(!membership.getPlan().getAllowedRoles().contains(member.getRole())){
//            return OperationResult.FAILED;
//        }
        membership.setMember(member);
        save(membership);
        return OperationResult.SUCCEED;
    }

    @Override
    public OperationResult assignPlanToMembership(Integer membershipId, Integer planId) {
        PlanEntity plan = planService.getById(planId);
        Membership membership = getById(membershipId);
        if (null == plan || null == membership) {
            return OperationResult.FAILED;
        }
        membership.setPlan(plan);
        save(membership);
        return OperationResult.SUCCEED;
    }

    @Override
    public void incrementCurrentCheckInCountForMemberId(int id) {
        Membership membership = getById(id);
        membership.setCurrentCheckIn(membership.getCurrentCheckIn()+1);
        save(membership);

        //TODO make following method work
//        membershipRepository.incrementCurrentCheckInCountForMemberId(id);
    }
}
