package com.ll.chat_ai.domain.chat.chatRoom;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatRoomForm {
    @NotEmpty
    private String name;
}
