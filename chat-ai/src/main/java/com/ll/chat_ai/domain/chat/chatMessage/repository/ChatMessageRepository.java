package com.ll.chat_ai.domain.chat.chatMessage.repository;

import com.ll.chat_ai.domain.chat.chatMessage.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    public List<ChatMessage> findByChatRoomId(Long roomId);
    public List<ChatMessage> findByChatRoomIdAndIdAfter(Long roomId, Long afterChatMessageId);
}
