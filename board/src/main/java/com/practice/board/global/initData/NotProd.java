package com.practice.board.global.initData;

import com.practice.board.domain.question.entity.Question;
import com.practice.board.domain.question.repository.QuestionRepository;
import com.practice.board.domain.question.service.QuestionService;
import com.practice.board.domain.user.entity.SiteUser;
import com.practice.board.domain.user.service.UserService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.stream.IntStream;

@Configuration
@Profile("!prod")
public class NotProd {

    @Bean
    public ApplicationRunner initNotProd(QuestionRepository questionRepository, QuestionService questionService, UserService userService) {
        return args -> {

            SiteUser user1 = userService.create("admin", "test@t.t", "aaaa");
            SiteUser user2 = userService.create("user", "user@u.u", "uuuu");

            Question q1 = Question.builder()
                    .subject("sbb가 무엇인가요?")
                    .content("sbb에 대해서 알고 싶습니다.")
                    .author(user1)
                    .build();
            questionRepository.save(q1);

            Question q2 = Question.builder()
                    .subject("스프링부트 모델 질문입니다.")
                    .content("id는 자동으로 생성되나요?")
                    .author(user1)
                    .build();
            questionRepository.save(q2);


            IntStream.rangeClosed(1, 300).forEach(i -> {
                String subject = String.format("테스트 데이터입니다:[%03d]", i);
                String content = "내용무";
                questionService.create(subject, content, user2);
            });
        };
    }
}
