package com.ll.rest2501.domain.article.repository;

import com.ll.rest2501.domain.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
