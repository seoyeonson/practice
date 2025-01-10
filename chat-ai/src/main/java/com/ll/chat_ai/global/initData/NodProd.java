package com.ll.chat_ai.global.initData;

import com.ll.chat_ai.domain.article.article.entity.Article;
import com.ll.chat_ai.domain.article.article.service.ArticleService;
import com.ll.chat_ai.domain.chat.chatMessage.service.ChatMessageService;
import com.ll.chat_ai.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chat_ai.domain.chat.chatRoom.service.ChatRoomService;
import com.ll.chat_ai.domain.member.member.entity.Member;
import com.ll.chat_ai.domain.member.member.service.MemberService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@Configuration
@Profile("!prod")
public class NodProd {

    @Bean
    ApplicationRunner initNodProd(
            ChatRoomService chatRoomService,
            ChatMessageService chatMessageService,
            MemberService memberService,
            ArticleService articleService){
        return new ApplicationRunner() {
            @Override
            @Transactional
            public void run(ApplicationArguments args) throws Exception {
                ChatRoom chatRoom1 = chatRoomService.create("room1");
                ChatRoom chatRoom2 = chatRoomService.create("room2");
                ChatRoom chatRoom3 = chatRoomService.create("room3");

                IntStream.rangeClosed(1, 100).forEach(i->{
                    chatMessageService.createChatMessage(chatRoom2, "홍길동", "메세지" + i);
                });

                // 회원 추가
                Member member1 = memberService.join("user1", "1234");
                Member member2 = memberService.join("user2", "1234");
                Member member3 = memberService.join("user3", "1234");

                // 글 작성
                Article article1 = articleService.write("제목1", "내용1");
                Article article2 = articleService.write("제목2", "내용2");

                Article article3 = articleService.write( "제목3", "내용3");
                Article article4 = articleService.write("제목4", "내용4");

                article1.addComment(member1, "댓글1");
                article1.addComment(member1, "댓글2");

                article2.addComment(member1, "댓글3");
                article2.addComment(member1, "댓글4");
                article2.addComment(member1, "댓글5");

                article3.addComment(member1, "댓글5");
                article3.addComment(member1, "댓글6");
                article3.addComment(member1, "댓글7");
                article3.addComment(member1, "댓글8");
                article3.addComment(member1, "댓글9");
                article3.addComment(member1, "댓글10");
                article3.addComment(member1, "댓글11");
                article3.addComment(member1, "댓글12");

                article1.addTag("자바");
                article1.addTag("백엔드");
            }
        };
    }
}
