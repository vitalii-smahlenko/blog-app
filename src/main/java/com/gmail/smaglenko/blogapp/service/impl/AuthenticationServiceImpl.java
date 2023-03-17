package com.gmail.smaglenko.blogapp.service.impl;

import com.gmail.smaglenko.blogapp.exception.AuthenticationException;
import com.gmail.smaglenko.blogapp.model.Role;
import com.gmail.smaglenko.blogapp.model.Role.RoleName;
import com.gmail.smaglenko.blogapp.model.UserAuth;
import com.gmail.smaglenko.blogapp.service.AuthenticationService;
import com.gmail.smaglenko.blogapp.service.RoleService;
import com.gmail.smaglenko.blogapp.service.UserAuthService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserAuthService userAuthService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserAuth register(String name, String password) {
        Role role = roleService.findByRoleName(RoleName.USER);
        if(role == null) {
            role = new Role();
            role.setRoleName(RoleName.USER);
            role = roleService.add(role);
        }
        UserAuth userAuth = new UserAuth();
        userAuth.setUsername(name);
        userAuth.setPassword(password);
        userAuth.getRoles().add(role);
        return userAuthService.save(userAuth);
    }

    @Override
    public UserAuth login(String username, String password) throws AuthenticationException {
        Optional<UserAuth> userAuth = userAuthService.findByUsername(username);
        if (!userAuth.isPresent()
                || userAuth.get().getPassword().equals(passwordEncoder.encode(password))) {
            throw new AuthenticationException("Incorrect username or password!!!");
        }
        return userAuth.get();
    }
}
