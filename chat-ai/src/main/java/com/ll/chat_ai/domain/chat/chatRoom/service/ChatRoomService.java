package com.ll.chat_ai.domain.chat.chatRoom.service;

import com.ll.chat_ai.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chat_ai.domain.chat.chatRoom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    public List<ChatRoom> getAll() {
        return chatRoomRepository.findAll();
    }

    public ChatRoom create(String name) {
        ChatRoom chatRoom = ChatRoom.builder()
                .name(name)
                .build();
        chatRoomRepository.save(chatRoom);
        return chatRoom;
    }

        public ChatRoom getChatRoom(Long roomId) {
        ChatRoom chatRoom = chatRoomRepository.findById(roomId).get();
        return chatRoom;
    }
}
