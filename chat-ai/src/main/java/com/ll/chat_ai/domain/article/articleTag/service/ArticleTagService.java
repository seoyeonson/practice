package com.ll.chat_ai.domain.article.articleTag.service;

import com.ll.chat_ai.domain.article.articleTag.repository.ArticleTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleTagService {
    private ArticleTagRepository articleTagRepository;


}
