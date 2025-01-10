package com.ll.chat_ai.domain.article.article.controller;

import com.ll.chat_ai.domain.article.article.dto.ArticleDto;
import com.ll.chat_ai.domain.article.article.dto.ArticleModifyRequest;
import com.ll.chat_ai.domain.article.article.dto.ArticleWriteRequest;
import com.ll.chat_ai.domain.article.article.entity.Article;
import com.ll.chat_ai.domain.article.article.service.ArticleService;
import com.ll.chat_ai.global.rsData.RsData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/article")
@RequiredArgsConstructor
public class ApiV1ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public List<ArticleDto> getArticles() {
        List<Article> articles = articleService.findAll();
        List<ArticleDto> articleDtoList = articles.stream()
                .map(ArticleDto::new)
                .toList();
        return articleDtoList;
    }

    @GetMapping("/{id}")
    private ArticleDto getArticle(@PathVariable("id") Long id) {
        Article article = articleService.findById(id).orElseGet(Article::new);
        return new ArticleDto(article);
    }

    @PostMapping
    public RsData<ArticleDto> writeArticle(@Valid @RequestBody ArticleWriteRequest articleWriteRequest) {
        Article article = articleService.write(articleWriteRequest.getTitle(), articleWriteRequest.getContent());
        return new RsData<>(
                "200",
                "게시글이 작성에 성공하였습니다.",
                new ArticleDto(article)
        );
    }
    @PatchMapping("/{id}")
    public RsData<ArticleDto> updateArticle(@PathVariable("id") Long id, @Valid @RequestBody ArticleModifyRequest articleModifyRequest) {
        Article article = this.articleService.findById(id).orElseGet(Article::new);
        Article modifiedArticle = this.articleService.modify(article, articleModifyRequest.getTitle(), articleModifyRequest.getContent());
        return new RsData<>(
                "200",
                "게시글이 수정에 성공하였습니다.",
                new ArticleDto(modifiedArticle)
        );
    }


    @DeleteMapping("/{id}")
    public RsData<Void> deleteArticle(@PathVariable("id") Long id) {
        this.articleService.delete(id);
        return new RsData<>(
                "200",
                "게시글이 삭제에 성공하였습니다."
        );
    }

}
