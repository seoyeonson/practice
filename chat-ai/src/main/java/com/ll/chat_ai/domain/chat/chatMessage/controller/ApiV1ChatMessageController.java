package com.ll.chat_ai.domain.chat.chatMessage.controller;

import com.ll.chat_ai.domain.chat.chatMessage.dto.response.ResponseGetMessage;
import com.ll.chat_ai.domain.chat.chatMessage.dto.response.ResponseGetMessageList;
import com.ll.chat_ai.domain.chat.chatMessage.dto.reuquest.RequestCreateMessage;
import com.ll.chat_ai.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.chat_ai.domain.chat.chatMessage.service.ChatMessageService;
import com.ll.chat_ai.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chat_ai.domain.chat.chatRoom.service.ChatRoomService;
import com.ll.chat_ai.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chat/rooms/{roomId}/messages")
@RequiredArgsConstructor
@CrossOrigin(origins = {"https://cdpn.io", "https://chat-app-front2501-pink.vercel.app/"})
public class ApiV1ChatMessageController {
    private final ChatMessageService chatMessageService;
    private final ChatRoomService chatRoomService;
    @GetMapping
    public RsData<ResponseGetMessageList> getChatMessages(
            @PathVariable("roomId") Long roomId,
            @RequestParam(value = "afterChatMessageId", defaultValue = "-1") long afterChatMessageId){
        List<ChatMessage> messages = chatMessageService.getMessagesAndafterChatMessageId(roomId, afterChatMessageId);
        return RsData.of("200", "메세지 조회 완료", new ResponseGetMessageList(messages));
    }

    @PostMapping
    public RsData<ResponseGetMessage> createChatMessages(@PathVariable("roomId") Long roomId, @RequestBody RequestCreateMessage createMessage){
        ChatRoom chatRoom = chatRoomService.getChatRoom(roomId);
        ChatMessage chatMessage = chatMessageService.createChatMessage(chatRoom, createMessage.getWriterName(), createMessage.getContent());
        return RsData.of("200", "메세지 작성 완료", new ResponseGetMessage(chatMessage.getId()));
    }
}
