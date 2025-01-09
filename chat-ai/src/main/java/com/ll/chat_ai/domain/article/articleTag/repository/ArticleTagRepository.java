package com.ll.chat_ai.domain.article.articleTag.repository;

import com.ll.chat_ai.domain.article.articleTag.entity.ArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleTagRepository extends JpaRepository<ArticleTag, Long> {
    List<ArticleTag> findByArticle_authorId(long id);

    List<ArticleTag> findByArticle_authorUsername(String username);
}
