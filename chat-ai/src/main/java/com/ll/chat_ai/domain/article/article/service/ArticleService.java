package com.ll.chat_ai.domain.article.article.service;

import com.ll.chat_ai.domain.article.article.entity.Article;
import com.ll.chat_ai.domain.article.article.respository.ArticleRepository;
import com.ll.chat_ai.domain.member.member.entity.Member;
import com.ll.chat_ai.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public RsData<Article> write(long authorId, String title, String body) {
        Article article = Article.builder()
                .modifyDate(LocalDateTime.now())
                .author(Member.builder().id(authorId).build())
                .title(title)
                .body(body)
                .build();

        articleRepository.save(article);

        return RsData.of("200", "%d번 게시글이 작성되었습니다.".formatted(article.getId()), article);
    }

    public Optional<Article> findById(long id) {
        return articleRepository.findById(id);
    }
}
