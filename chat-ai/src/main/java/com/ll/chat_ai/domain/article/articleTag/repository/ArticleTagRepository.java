package com.ll.chat_ai.domain.article.articleTag.repository;

import com.ll.chat_ai.domain.article.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleTagRepository extends JpaRepository<Article, Long> {
}
