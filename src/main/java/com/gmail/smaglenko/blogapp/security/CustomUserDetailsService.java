package com.gmail.smaglenko.blogapp.security;

import com.gmail.smaglenko.blogapp.model.Role;
import com.gmail.smaglenko.blogapp.model.UserAuth;
import com.gmail.smaglenko.blogapp.service.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserAuthService userAuthService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuth userAuthFromDb = userAuthService.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found by username: " + username));
        return User
                .withUsername(userAuthFromDb.getUsername())
                .password(userAuthFromDb.getPassword())
                .roles(userAuthFromDb.getRoles().stream()
                        .map(role -> role.getRoleName().toString())
                        .toArray(String[]::new))
                .build();
    }
}
