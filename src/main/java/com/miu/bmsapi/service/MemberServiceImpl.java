package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.Badge;
import com.miu.bmsapi.domain.Member;
import com.miu.bmsapi.domain.Role;
import com.miu.bmsapi.domain.User;
import com.miu.bmsapi.enums.OperationResult;
import com.miu.bmsapi.repository.MemberRepository;
import com.miu.bmsapi.repository.RoleRepo;
import com.miu.bmsapi.repository.UserRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;
    private BadgeService badgeService;
    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private PasswordEncoder passwordEncoder;

    @Override
    public Member save(Member member) {
        saveUser(member);
        return memberRepository.save(member);
    }

    // We can use AOP to create login credential for this member
    private void saveUser(Member member) {
        Role role = roleRepo.findByRole(member.getRole().name());
        User user = User.builder()
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .email(member.getEmail())
                .password(passwordEncoder.encode("12345"))
                .roles(List.of(role)).build();
        userRepo.save(user);
    }

    @Override
    public Member update(int id, Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member getById(int id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    @Override
    public OperationResult delete(int id) {
        memberRepository.delete(getById(id));
        return OperationResult.SUCCEED;
    }

    @Override
    public OperationResult assignBadge(Integer memberId, Integer badgeId) {
        Member member = getById(memberId);
        Badge badge = badgeService.getById(badgeId);
        if (member == null || badge == null) {
            return OperationResult.FAILED;
        }
        badgeService.inactiveAllBadgesOfThisMember(memberId);
        badge.setMember(member);
        badge.setActive(true);
        badgeService.save(badge);
        return OperationResult.SUCCEED;
    }
}
