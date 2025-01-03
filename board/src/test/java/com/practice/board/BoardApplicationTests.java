package com.practice.board;

import com.practice.board.domain.question.entity.Question;
import com.practice.board.domain.question.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class BoardApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testJpa(){
		Question q1= Question.builder().subject("sbb가 무엇인가요?").content("sbb에 대해서 알고 싶습니다.").createDate(LocalDateTime.now()).build();
		Question q2 = Question.builder().subject("스프링부트 모델 질문입니다.").content("id는 자동으로 생성되나요?").createDate(LocalDateTime.now()).build();

		questionRepository.save(q1);
		questionRepository.save(q2);

	}

}
