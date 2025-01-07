package com.ll.chat_ai.domain.chat.chatMessage.dto.reuquest;

import lombok.Getter;

@Getter
public class RequestGetMessage {
    private Long roomId;
    private Long afterChatMessageId;
}
