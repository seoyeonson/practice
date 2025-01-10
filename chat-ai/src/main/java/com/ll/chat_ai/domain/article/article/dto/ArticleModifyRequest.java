package com.ll.chat_ai.domain.article.article.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ArticleModifyRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String content;
}
