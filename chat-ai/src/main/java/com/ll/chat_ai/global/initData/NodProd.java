package com.ll.chat_ai.global.initData;

import com.ll.chat_ai.domain.article.article.entity.Article;
import com.ll.chat_ai.domain.article.article.service.ArticleService;
import com.ll.chat_ai.domain.chat.chatMessage.service.ChatMessageService;
import com.ll.chat_ai.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chat_ai.domain.chat.chatRoom.service.ChatRoomService;
import com.ll.chat_ai.domain.member.member.entity.Member;
import com.ll.chat_ai.domain.member.member.service.MemberService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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
        return args -> {
            ChatRoom chatRoom1 = chatRoomService.create("room1");
            ChatRoom chatRoom2 = chatRoomService.create("room2");
            ChatRoom chatRoom3 = chatRoomService.create("room3");

            IntStream.rangeClosed(1, 100).forEach(i->{
                chatMessageService.createChatMessage(chatRoom2, "홍길동", "메세지" + i);
            });

            Member member1 = memberService.join("user1", "1234").getData();
            Member member2 = memberService.join("user2", "1234").getData();
            Member member3 = memberService.join("user3", "1234").getData();

            Article article1 = articleService.write(member1.getId(), "제목1", "내용1").getData();
            Article article2 = articleService.write(member1.getId(), "제목2", "내용2").getData();

            Article article3 = articleService.write(member2.getId(), "제목3", "내용3").getData();
            Article article4 = articleService.write(member2.getId(), "제목4", "내용4").getData();

        };
    }
}
