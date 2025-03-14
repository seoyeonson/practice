package com.sy.sbrabbitmq.global.initData;

import com.sy.sbrabbitmq.domain.chat.chat.entity.ChatRoom;
import com.sy.sbrabbitmq.domain.chat.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@Profile("!prod")
@Configuration
@RequiredArgsConstructor
public class InitData {
    @Autowired
    @Lazy
    private InitData self;
    private final ChatService chatService;

    @Bean
    public ApplicationRunner initNotProd() {
        return args -> {
            self.work1();
        };
    }

    @Transactional
    public void work1() {
        ChatRoom room1 = chatService.createRoom("room1");
        ChatRoom room2 = chatService.createRoom("room2");
        ChatRoom room3 = chatService.createRoom("room3");

        chatService.writeMessage(room1, "user1", "message1");
        chatService.writeMessage(room1, "user1", "message2");
        chatService.writeMessage(room1, "user1", "message3");

        chatService.writeMessage(room1, "user2", "message4");
        chatService.writeMessage(room1, "user2", "message5");

        chatService.writeMessage(room1, "user3", "message6");

        chatService.writeMessage(room2, "user1", "message7");
        chatService.writeMessage(room2, "user2", "message8");

        chatService.writeMessage(room3, "user1", "message9");
    }
}
