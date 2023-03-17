package com.gmail.smaglenko.blogapp.controller;

import com.gmail.smaglenko.blogapp.dto.request.UserAuthRequestDto;
import com.gmail.smaglenko.blogapp.dto.response.UserAuthResponseDto;
import com.gmail.smaglenko.blogapp.exception.AuthenticationException;
import com.gmail.smaglenko.blogapp.model.Role;
import com.gmail.smaglenko.blogapp.model.UserAuth;
import com.gmail.smaglenko.blogapp.security.jwt.JwtTokenProvider;
import com.gmail.smaglenko.blogapp.service.AuthenticationService;
import com.gmail.smaglenko.blogapp.service.mapper.ResponseDtoMapper;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final ResponseDtoMapper<UserAuthResponseDto, UserAuth> responseDtoMapper;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public UserAuthResponseDto register(@RequestBody UserAuthRequestDto dto) {
        return responseDtoMapper.mapToDto(authenticationService
                .register(dto.getUsername(), dto.getPassword()));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserAuthRequestDto dto)
            throws AuthenticationException {
        UserAuth userAuth = authenticationService.login(dto.getUsername(), dto.getPassword());
        String token = jwtTokenProvider.createToken(userAuth.getUsername(), userAuth.getRoles()
                .stream()
                .map(Role::toString)
                .collect(Collectors.toList()));
        Map<String, String> tokens = new HashMap<>();
        tokens.put("token", token);
        return new ResponseEntity<>(tokens, HttpStatus.OK);

    }
}