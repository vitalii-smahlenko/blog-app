package com.gmail.smaglenko.blogapp.dto.response;

import com.gmail.smaglenko.blogapp.model.Article;
import java.util.List;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private int age;
    private List<Article> articles;
}
