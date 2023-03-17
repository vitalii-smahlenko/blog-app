package com.gmail.smaglenko.blogapp.dto.response;

import com.gmail.smaglenko.blogapp.model.Color;
import lombok.Data;

@Data
public class ArticleResponseDto {
    private Long id;
    private String text;
    private Color color;
}
