package com.gmail.smaglenko.blogapp.controller;

import com.gmail.smaglenko.blogapp.dto.request.UserRequestDto;
import com.gmail.smaglenko.blogapp.dto.response.UserResponseDto;
import com.gmail.smaglenko.blogapp.model.Color;
import com.gmail.smaglenko.blogapp.model.User;
import com.gmail.smaglenko.blogapp.service.ArticleService;
import com.gmail.smaglenko.blogapp.service.UserService;
import com.gmail.smaglenko.blogapp.service.mapper.RequestDtoMapper;
import com.gmail.smaglenko.blogapp.service.mapper.ResponseDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ArticleService articleService;
    private final ResponseDtoMapper<UserResponseDto, User> responseDtoMapper;
    private final RequestDtoMapper<UserRequestDto, User> requestDtoMapper;

    @PostMapping("/save")
    public UserResponseDto save(@RequestBody UserRequestDto userRequestDto) {
        userRequestDto.getArticles().forEach(articleService::save);
        return responseDtoMapper
                .mapToDto(userService.save(requestDtoMapper.mapToModel(userRequestDto)));
    }

    @PostMapping("/addArticle")
    public UserResponseDto addArticle(@RequestParam Long userId, @RequestParam String text,
                                      @RequestParam Color color){
        return responseDtoMapper.mapToDto(userService.addArticleToUser(userId,text,color));
    }

    @GetMapping("/getAllByAgeAfter")
    public List<UserResponseDto> getAllByAgeAfter(@RequestParam int age) {
        return userService.getAllByAgeAfter(age).stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/getAllByArticleColor")
    public List<UserResponseDto> getUsersWithArticleColor(@RequestParam Color color) {
        return userService.getUsersWithArticleColor(color).stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/getUsersWithUniqueName")
    public List<String> getUsersWithUniqueNameAndMoreThanThreeArticle() {
        return userService.getUsersWithUniqueNameAndMoreThanThreeArticle();
    }
}
