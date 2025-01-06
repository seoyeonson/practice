package com.ll.chat_ai.domain.chat.chatMessage.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chat/rooms/{roomId}/messages")
public class ApiV1ChatMessageController {
    @GetMapping
    public String getMessageList(@PathVariable Long roomId, @RequestParam Long afterChatMessageId){
        return String.format("%d번 채팅방 메시지 목록 조회 완료 id : %d", roomId, afterChatMessageId);
    }

    @PostMapping
    public String createMessage(){
        return "채팅방 메시지 생성 완료";
    }
}
