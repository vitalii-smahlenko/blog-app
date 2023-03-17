package com.gmail.smaglenko.blogapp.service.mapper.impl;

import com.gmail.smaglenko.blogapp.dto.request.UserAuthRequestDto;
import com.gmail.smaglenko.blogapp.dto.response.UserAuthResponseDto;
import com.gmail.smaglenko.blogapp.model.UserAuth;
import com.gmail.smaglenko.blogapp.service.mapper.RequestDtoMapper;
import com.gmail.smaglenko.blogapp.service.mapper.ResponseDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class UserAuthDtoMapperImpl implements RequestDtoMapper<UserAuthRequestDto, UserAuth>,
        ResponseDtoMapper<UserAuthResponseDto, UserAuth> {
    @Override
    public UserAuthResponseDto mapToDto(UserAuth userAuth) {
        UserAuthResponseDto dto = new UserAuthResponseDto();
        dto.setId(userAuth.getId());
        dto.setUsername(userAuth.getUsername());
        return dto;
    }

    @Override
    public UserAuth mapToModel(UserAuthRequestDto dto) {
        UserAuth userUserAuth = new UserAuth();
        userUserAuth.setUsername(dto.getUsername());
        userUserAuth.setPassword(dto.getPassword());
        return userUserAuth;
    }
}
