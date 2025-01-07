package com.ll.chat_ai.domain.chat.chatMessage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ll.chat_ai.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chat_ai.global.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
@ToString(callSuper = true)
// @ToString(callSuper = true)
// 상속받은 부모 클래스의 필드까지 toString()에 포함
// callSuper = true: 부모 클래스의 toString() 결과를 포함
public class ChatMessage extends BaseEntity {
    private String writerName;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "chat_room_id")
    @JsonIgnore
    private ChatRoom chatRoom;
}
