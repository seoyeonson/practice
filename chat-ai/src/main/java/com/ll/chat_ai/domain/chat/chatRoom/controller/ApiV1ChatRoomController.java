package com.ll.chat_ai.domain.chat.chatRoom.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chat/rooms")
public class ApiV1ChatRoomController {
    // 다건 조회
    @GetMapping("")
    @ResponseBody
    public String getChatRooms() {
        return "채팅방 목록 조회완료";
    }

    // 단건 조회
    @GetMapping("/{roomId}")
    @ResponseBody
    public String getChatRooms(@PathVariable Long roomId) {
        return String.format("%d번 채팅방 조회완료", roomId);
    }

    @PostMapping("")
    @ResponseBody
    public String createChatRoom() {
        return "채팅방 생성완료";
    }
}
