package com.ll.chat_ai.domain.article.articleTag.entity;

import com.ll.chat_ai.domain.article.article.entity.Article;
import com.ll.chat_ai.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter @Setter
@SuperBuilder
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
@ToString(callSuper = true)
public class ArticleTag extends BaseEntity {
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;
}
