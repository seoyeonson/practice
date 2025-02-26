package com.sy.sbkafka.domain.member.member.service;

import com.sy.sbkafka.domain.member.member.entity.Member;
import com.sy.sbkafka.domain.member.member.repository.MemberRepository;
import com.sy.sbkafka.global.rsData.RsData;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public RsData<Member> join(String username, String password, String nickname) {
        return RsData.of(
            memberRepository.save(Member.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .build()
            )
        );
    }

    public long count(){
        return memberRepository.count();
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}
