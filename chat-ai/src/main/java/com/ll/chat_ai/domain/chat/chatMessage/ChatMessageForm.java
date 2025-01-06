package com.ll.chat_ai.domain.chat.chatMessage;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageForm {
    @NotEmpty
    private String name;

    @NotEmpty
    private String message;
}
