package com.gmail.smaglenko.blogapp.service.impl;

import com.gmail.smaglenko.blogapp.model.UserAuth;
import com.gmail.smaglenko.blogapp.repository.UserAuthRepository;
import com.gmail.smaglenko.blogapp.service.UserAuthService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {
    private final UserAuthRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<UserAuth> findByUsername(String username) {
        return Optional.of(repository.findByUsername(username));
    }

    @Override
    public UserAuth save(UserAuth userAuth) {
        userAuth.setPassword(passwordEncoder.encode(userAuth.getPassword()));
        return repository.save(userAuth);
    }
}
