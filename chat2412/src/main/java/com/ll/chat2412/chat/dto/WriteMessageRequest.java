package com.ll.chat2412.chat.dto;

import com.ll.chat2412.chat.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class WriteMessageRequest {
    private String authorName;
    private String content;
}
