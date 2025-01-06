package com.ll.chat_ai.domain.chat.chatMessage.service;

import com.ll.chat_ai.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.chat_ai.domain.chat.chatMessage.repository.ChatMessageRepository;
import com.ll.chat_ai.domain.chat.chatRoom.entity.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;

    public void createChatMessage(ChatRoom chatRoom, String writerName, String content) {
        ChatMessage chatMessage = ChatMessage.builder()
                .chatRoom(chatRoom)
                .content(content)
                .writerName(writerName)
                .build();
        chatMessageRepository.save(chatMessage);
    }
}
