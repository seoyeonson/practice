package com.ll.chat_ai.domain.chat.chatRoom.controller;

import com.ll.chat_ai.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chat_ai.domain.chat.chatRoom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chat/rooms")
@RequiredArgsConstructor
@CrossOrigin(
        origins = "https://cdpn.io"
)
public class ApiV1ChatRoomController {
    private final ChatRoomService chatRoomService;

    // 다건 조회
    @GetMapping
    public List<ChatRoom> getChatRooms() {
        // json 형태로 보내야함.
        List<ChatRoom> chatRooms = chatRoomService.getAll();
        return chatRooms;
    }

    // 단건 조회
    @GetMapping("/{roomId}")
    public ChatRoom getChatRooms(@PathVariable("roomId") Long roomId) {
        ChatRoom chatRoom = chatRoomService.getChatRoom(roomId);
        return chatRoom;
    }

    @PostMapping("")
    @ResponseBody
    public String createChatRoom() {
        return "채팅방 생성완료";
    }
}
