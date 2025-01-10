package com.ll.chat_ai.domain.member.member.service;

import com.ll.chat_ai.domain.member.member.entity.Member;
import com.ll.chat_ai.domain.member.member.repository.MemberRepository;
import com.ll.chat_ai.global.jwt.JwtProvider;
import com.ll.chat_ai.global.rsData.RsData;
import com.ll.chat_ai.global.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public Member join(String username, String password) {
        Member CheckedSignUpMember = memberRepository.findByUsername(username);

        if (CheckedSignUpMember != null) {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        }

        Member member = memberRepository.save(Member.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .build());

        return memberRepository.save(member);
    }

    public Optional<Member> findById(long id) {
        return memberRepository.findById(id);
    }

    public Member getMember(String username) {
        return memberRepository.findByUsername(username);
    }

    // 토큰 유효성 검증
    public boolean validateToken(String token) {
        return jwtProvider.validateToken(token);
    }

    // 토큰 갱신 (리프레쉬 토큰)
    public RsData<String> refreshAccessToken(String refreshToken) {
        Member member = memberRepository.findByRefreshToken(refreshToken).orElseThrow(() -> new IllegalArgumentException("유효하지 않은 토큰입니다."));
        String accessToken = jwtProvider.genAccessToken(member);
        return new RsData<>("200", "토큰 갱신 성공", accessToken);
    }

    // 토큰으로 유저 정보 가져오기
    public SecurityUser getUserFromAccessToken(String accessToken) {
        Map<String, Object> payloadBody = jwtProvider.getClaims(accessToken);
        long id = (int) payloadBody.get("id");
        String username = (String) payloadBody.get("username");
        List<GrantedAuthority> authorities = new ArrayList<>();
        return new SecurityUser(id, username, "", authorities);
    }
}
