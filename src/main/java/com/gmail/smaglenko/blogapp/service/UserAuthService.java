package com.gmail.smaglenko.blogapp.service;

import com.gmail.smaglenko.blogapp.model.UserAuth;
import java.util.Optional;

public interface UserAuthService {
    Optional<UserAuth> findByUsername(String username);

    UserAuth save(UserAuth userUserAuth);
}
