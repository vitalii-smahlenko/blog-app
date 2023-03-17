package com.gmail.smaglenko.blogapp.service.mapper.impl;

import com.gmail.smaglenko.blogapp.dto.request.ArticleRequestDto;
import com.gmail.smaglenko.blogapp.dto.response.ArticleResponseDto;
import com.gmail.smaglenko.blogapp.model.Article;
import com.gmail.smaglenko.blogapp.service.mapper.RequestDtoMapper;
import com.gmail.smaglenko.blogapp.service.mapper.ResponseDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class ArticleDtoMapperImpl implements RequestDtoMapper<ArticleRequestDto, Article>,
        ResponseDtoMapper<ArticleResponseDto, Article> {
    @Override
    public ArticleResponseDto mapToDto(Article article) {
        ArticleResponseDto articleResponseDto = new ArticleResponseDto();
        articleResponseDto.setId(article.getId());
        articleResponseDto.setText(article.getText());
        articleResponseDto.setColor(article.getColor());
        return articleResponseDto;
    }

    @Override
    public Article mapToModel(ArticleRequestDto articleRequestDto) {
        Article article = new Article();
        article.setText(articleRequestDto.getText());
        article.setColor(articleRequestDto.getColor());
        return article;
    }
}
