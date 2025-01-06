package com.ll.chat_ai.domain.chat.chatMessage.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chat/rooms/{roomId}/messages")
public class ApiV1ChatMessageController {
    @GetMapping
    public String getChatMessages(@PathVariable("roomId") Long roomId, @RequestParam(value = "afterChatMessageId", defaultValue = "-1") long afterChatMessageId){
        return String.format("%d번 채팅방 메시지 목록 조회 완료 id : %d", roomId, afterChatMessageId);
    }

    @PostMapping
    public String createChatMessages(@PathVariable("roomId") Long roomId){
        return roomId + "번방 채팅방 메시지 생성 완료";
    }
}
