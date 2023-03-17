package com.gmail.smaglenko.blogapp.dto.request;

import com.gmail.smaglenko.blogapp.model.Color;
import lombok.Data;

@Data
public class ArticleRequestDto {
    private String text;
    private Color color;
}
