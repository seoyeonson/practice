package com.ll.chat_ai.domain.article.article.service;

import com.ll.chat_ai.domain.article.article.entity.Article;
import com.ll.chat_ai.domain.article.article.respository.ArticleRepository;
import com.ll.chat_ai.domain.article.articleComment.entity.ArticleComment;
import com.ll.chat_ai.domain.member.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional
    public Article write(String title, String body) {
        Article article = Article.builder()
                .author(Member.builder().id(1L).build())
                .title(title)
                .content(body)
                .build();

        return articleRepository.save(article);
    }

    public Optional<Article> findById(long id) {
        return articleRepository.findById(id);
    }

    @Transactional
    public Article modify(Article article, String title, String content) {
        article.setTitle(title);
        article.setContent(content);
        return article;
    }

    public void modifyComment(ArticleComment comment, String body) {
        comment.setBody(body);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public void delete(Long id) {
        this.articleRepository.deleteById(id);
    }
}
