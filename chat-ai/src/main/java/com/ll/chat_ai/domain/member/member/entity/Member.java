package com.ll.chat_ai.domain.member.member.entity;

import com.ll.chat_ai.domain.article.article.entity.Article;
import com.ll.chat_ai.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static lombok.AccessLevel.PROTECTED;

@Entity
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
@Getter @Setter
@SuperBuilder
@ToString(callSuper = true)
public class Member extends BaseEntity {
    private String username;
    private String password;

    @OneToMany(mappedBy = "author", cascade = ALL,orphanRemoval = true)
    @ToString.Exclude
    private List<Article> articles;
}
