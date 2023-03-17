package com.gmail.smaglenko.blogapp.service.impl;

import com.gmail.smaglenko.blogapp.model.Article;
import com.gmail.smaglenko.blogapp.repository.ArticleRepository;
import com.gmail.smaglenko.blogapp.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }
}
