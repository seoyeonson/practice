package com.ll.chat_ai.domain.member.member.service;

import com.ll.chat_ai.domain.member.member.entity.Member;
import com.ll.chat_ai.domain.member.member.repository.MemberRepository;
import com.ll.chat_ai.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public RsData<Member> join(String username, String password) {
        Member member = memberRepository.save(Member.builder()
                .username(username)
                .password(password)
                .build());

        return RsData.of("200", "%s님 가입을 환영합니다.".formatted(username), member);
    }
}
