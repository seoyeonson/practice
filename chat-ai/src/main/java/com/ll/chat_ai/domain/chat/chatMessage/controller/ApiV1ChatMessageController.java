package com.ll.chat_ai.domain.chat.chatMessage.controller;

import com.ll.chat_ai.domain.chat.chatMessage.dto.reuquest.RequestCreateMessage;
import com.ll.chat_ai.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.chat_ai.domain.chat.chatMessage.service.ChatMessageService;
import com.ll.chat_ai.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chat_ai.domain.chat.chatRoom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chat/rooms/{roomId}/messages")
@RequiredArgsConstructor
@CrossOrigin(origins = {"https://cdpn.io", "https://chat-app-front2501-pink.vercel.app/"})
@Slf4j
public class ApiV1ChatMessageController {
    private final ChatMessageService chatMessageService;
    private final ChatRoomService chatRoomService;
    @GetMapping
    public List<ChatMessage> getChatMessages(
            @PathVariable("roomId") Long roomId,
            @RequestParam(value = "afterChatMessageId", defaultValue = "-1") long afterChatMessageId){
        return chatMessageService.getMessagesAndafterChatMessageId(roomId, afterChatMessageId);
    }

    @PostMapping
    public Long createChatMessages(@PathVariable("roomId") Long roomId, @RequestBody RequestCreateMessage createMessage){
        log.info("roomId: {}, writerName: {}, content: {}", roomId, createMessage.getWriterName(), createMessage.getContent());
        ChatRoom chatRoom = chatRoomService.getChatRoom(roomId);
        ChatMessage chatMessage = chatMessageService.createChatMessage(chatRoom, createMessage.getWriterName(), createMessage.getContent());
        return chatMessage.getId();
    }
}
