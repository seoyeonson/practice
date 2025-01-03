package com.ll.rest2501.domain.article.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/articles")
public class ApiV1ArticleController {
    @GetMapping
    public String getArticles() {
        return "게시글 다건";
    }

    @GetMapping
    public String getArticle() {
        return "게시글 단건";
    }

    @PostMapping
    public String writeArticle() {
        return "게시글 등록";
    }

    @PatchMapping
    public String modifyArticle() {
        return "게시글 수정";
    }

    @DeleteMapping
    public String deleteArticle() {
        return "게시글 삭제";
    }
}
