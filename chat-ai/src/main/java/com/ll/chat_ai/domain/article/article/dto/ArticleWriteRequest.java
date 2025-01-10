package com.ll.chat_ai.domain.article.article.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ArticleWriteRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
