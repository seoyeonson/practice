package com.ll.chat_ai.domain.chat.chatMessage.dto.response;

import com.ll.chat_ai.domain.chat.chatMessage.entity.ChatMessage;

import java.util.List;

public record ResponseGetMessageList(List<ChatMessage> messages) {
}
