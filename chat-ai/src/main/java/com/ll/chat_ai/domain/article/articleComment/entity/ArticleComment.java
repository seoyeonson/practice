package com.ll.chat_ai.domain.article.articleComment.entity;

import com.ll.chat_ai.domain.article.article.entity.Article;
import com.ll.chat_ai.domain.member.member.entity.Member;
import com.ll.chat_ai.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class ArticleComment extends BaseEntity {

    @ManyToOne
    private Article article;

    @ManyToOne
    private Member author;

    private String body;
}
