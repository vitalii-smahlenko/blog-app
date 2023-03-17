package com.gmail.smaglenko.blogapp.controller;

import com.gmail.smaglenko.blogapp.dto.request.ArticleRequestDto;
import com.gmail.smaglenko.blogapp.dto.response.ArticleResponseDto;
import com.gmail.smaglenko.blogapp.model.Article;
import com.gmail.smaglenko.blogapp.service.mapper.RequestDtoMapper;
import com.gmail.smaglenko.blogapp.service.mapper.ResponseDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ResponseDtoMapper<ArticleResponseDto, Article> responseDtoMapper;
    private final RequestDtoMapper<ArticleRequestDto, Article> requestDtoMapper;

    @PostMapping("/save")
    public ArticleResponseDto save(ArticleRequestDto articleRequestDto) {
        return responseDtoMapper.mapToDto(requestDtoMapper.mapToModel(articleRequestDto));
    }
}
