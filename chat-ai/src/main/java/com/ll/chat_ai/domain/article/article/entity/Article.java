package com.ll.chat_ai.domain.article.article.entity;

import com.ll.chat_ai.domain.article.articleComment.entity.ArticleComment;
import com.ll.chat_ai.domain.article.articleTag.entity.ArticleTag;
import com.ll.chat_ai.domain.member.member.entity.Member;
import com.ll.chat_ai.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
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

    @OneToMany(mappedBy = "article", cascade = ALL, orphanRemoval = true)
    @Builder.Default // 순환 참조 방지
    @ToString.Exclude
    private List<ArticleComment> comments = new ArrayList<>();

    @OneToMany
    private List<ArticleTag> tags = new ArrayList<>();


    public void addComment(Member memberAuthor, String commentBody) {
        ArticleComment articleComment = ArticleComment.builder()
                .article(this)
                .author(memberAuthor)
                .body(commentBody)
                .build();
        comments.add(articleComment);
    }

    public void removeComment(ArticleComment comment) {
        comments.remove(comment);
    }

    public String getTagsStr() {
        return tags.stream()
                .map(ArticleTag::getName)
                .reduce((a, b) -> "#" + a + " #" + b)
                .orElse("");
    }
}
