package com.ll.chat_ai.domain.chat.chatRoom.controller;

import com.ll.chat_ai.domain.chat.chatRoom.dto.reuquest.RequestCreateRoom;
import com.ll.chat_ai.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chat_ai.domain.chat.chatRoom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chat/rooms")
@RequiredArgsConstructor
@CrossOrigin(origins = {"https://cdpn.io", "https://chat-app-front2501-pink.vercel.app/"})
public class ApiV1ChatRoomController {
    private final ChatRoomService chatRoomService;

    // 다건 조회
    @GetMapping
    public List<ChatRoom> getChatRooms() {
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
    public ChatRoom createChatRoom(@RequestBody RequestCreateRoom createRoom) {
        ChatRoom chatRoom = chatRoomService.create(createRoom.getName());
        return chatRoom;
    }
}
