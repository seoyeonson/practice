package com.ll.chat_ai.domain.chat.chatMessage.entity;

import com.ll.chat_ai.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chat_ai.global.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
    private String name;

    @Column(columnDefinition = "TEXT")
    private String message;

    @ManyToOne
    private ChatRoom chatRoom;
}
