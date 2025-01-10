package com.ll.chat_ai.domain.member.service;

import com.ll.chat_ai.domain.member.member.entity.Member;
import com.ll.chat_ai.domain.member.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

// @Transactional 테스트 완료 후 롤백한다.
@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @DisplayName("회원가입")
    @Test
    void t1() {
        Member member = memberService.join("usernew", "1234");
        assertThat(member.getId()).isGreaterThan(0L);
    }
}
