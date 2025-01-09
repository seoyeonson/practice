package com.ll.chat_ai.domain.article.article.respository;

import com.ll.chat_ai.domain.article.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long>, ArticleRepositoryCustom {
    List<Article> findByOrderByIdDesc();
}
