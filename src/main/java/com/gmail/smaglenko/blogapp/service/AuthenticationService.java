package com.gmail.smaglenko.blogapp.service;

import com.gmail.smaglenko.blogapp.exception.AuthenticationException;
import com.gmail.smaglenko.blogapp.model.UserAuth;

public interface AuthenticationService {
    UserAuth register(String name, String password);

    UserAuth login(String username, String password) throws AuthenticationException;
}
