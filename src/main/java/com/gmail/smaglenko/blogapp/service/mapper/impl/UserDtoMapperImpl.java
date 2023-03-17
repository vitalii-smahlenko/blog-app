package com.gmail.smaglenko.blogapp.service.mapper.impl;

import com.gmail.smaglenko.blogapp.dto.request.UserRequestDto;
import com.gmail.smaglenko.blogapp.dto.response.UserResponseDto;
import com.gmail.smaglenko.blogapp.model.User;
import com.gmail.smaglenko.blogapp.service.mapper.RequestDtoMapper;
import com.gmail.smaglenko.blogapp.service.mapper.ResponseDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapperImpl implements RequestDtoMapper<UserRequestDto, User>,
        ResponseDtoMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setName(user.getName());
        responseDto.setAge(user.getAge());
        responseDto.setArticles(user.getArticles());
        return responseDto;
    }

    @Override
    public User mapToModel(UserRequestDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setArticles(dto.getArticles());
        return user;
    }
}
