package com.ll.chat_ai.global.initData;

import com.ll.chat_ai.domain.chat.chatMessage.service.ChatMessageService;
import com.ll.chat_ai.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chat_ai.domain.chat.chatRoom.service.ChatRoomService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.stream.IntStream;

@Configuration
@Profile("!prod")
public class NodProd {

    @Bean
    ApplicationRunner initNodProd(ChatRoomService chatRoomService, ChatMessageService chatMessageService){
        return args -> {
            ChatRoom chatRoom1 = chatRoomService.create("room1");
            ChatRoom chatRoom2 = chatRoomService.create("room2");
            ChatRoom chatRoom3 = chatRoomService.create("room3");

            IntStream.rangeClosed(1, 100).forEach(i->{
                chatMessageService.createChatMessage(chatRoom2, "홍길동", "메세지" + i);
            });

        };
    }
}
