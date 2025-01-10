package com.ll.chat_ai.domain.article.article.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ll.chat_ai.domain.article.articleComment.entity.ArticleComment;
import com.ll.chat_ai.domain.article.articleTag.entity.ArticleTag;
import com.ll.chat_ai.domain.member.member.entity.Member;
import com.ll.chat_ai.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Article extends BaseEntity {
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;

    @JsonIgnore
    @OneToMany(mappedBy = "article", cascade = ALL, orphanRemoval = true)
    @Builder.Default // 순환 참조 방지
    @ToString.Exclude
    private List<ArticleComment> comments = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "article", cascade = ALL, orphanRemoval = true) // ferch = FetchType.LAZY
    @Builder.Default // 순환 참조 방지
    @ToString.Exclude
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
                .map(ArticleTag::getContent)
                .reduce((a, b) -> "#" + a + " #" + b)
                .orElse("");
    }

    public void addTag(String articleTag) {
        tags.add(ArticleTag.builder().article(this).content(articleTag).build());
    }

    public void addTags(String... tagContents) {
        for (String tagContent : tagContents) {
            addTag(tagContent);
        }
    }
}
