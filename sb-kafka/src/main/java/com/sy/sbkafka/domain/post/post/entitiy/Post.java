package com.sy.sbkafka.domain.post.post.entitiy;

import com.sy.sbkafka.domain.post.author.entity.Author;
import com.sy.sbkafka.global.jpa.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
@Getter
@Setter
public class Post extends BaseEntity {
    private String title;
    private String content;

    @ManyToOne
    private Author author;
}
