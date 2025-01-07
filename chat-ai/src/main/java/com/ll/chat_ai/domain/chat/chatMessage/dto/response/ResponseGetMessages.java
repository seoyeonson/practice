package com.ll.chat_ai.domain.chat.chatMessage.dto.response;

import com.ll.chat_ai.domain.chat.chatMessage.entity.ChatMessage;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponseGetMessages {
    private List<ChatMessage> chatMessages;
}
