package com.ll.chat_ai.domain.article.article.controller;

import com.ll.chat_ai.domain.article.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/article")
@RequiredArgsConstructor
public class ApiV1ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public void getArticles() {

    }

    @GetMapping("/{id}")
    public void getArticle(@PathVariable("id") Long id) {

    }

    @PostMapping("/write")
    public void writeArticle() {

    }

    @PatchMapping("/{id}")
    public void patchArticle(@PathVariable("id") Long id) {

    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable("id") Long id) {

    }

}
