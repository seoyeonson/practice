package com.ll.chat_ai.domain.article.article.entity;

import com.ll.chat_ai.domain.member.member.entity.Member;
import com.ll.chat_ai.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Setter
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
@SuperBuilder
@ToString(callSuper = true)
public class Article extends BaseEntity {
    private String title;
    private String body;

    @ManyToOne
    private Member author;
}
