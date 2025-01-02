package com.practice.board.domain.answer.entity;

import com.practice.board.domain.question.entity.Question;
import com.practice.board.global.baseEntity.BaseEntity;
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
public class Answer extends BaseEntity {
    @Column(length = 200)
    private String subject;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;
}
