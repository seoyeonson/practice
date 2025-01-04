package com.practice.board.domain.comment.entity;

import com.practice.board.domain.answer.entity.Answer;
import com.practice.board.domain.question.entity.Question;
import com.practice.board.domain.user.entity.SiteUser;
import com.practice.board.global.baseEntity.BaseEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Comment extends BaseEntity {
    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Answer answer;

    @ManyToOne
    private SiteUser author;

    @ManyToMany
    Set<SiteUser> voter;
}
