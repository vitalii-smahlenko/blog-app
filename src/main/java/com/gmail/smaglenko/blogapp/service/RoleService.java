package com.gmail.smaglenko.blogapp.service;

import com.gmail.smaglenko.blogapp.model.Role;
import com.gmail.smaglenko.blogapp.model.Role.RoleName;

public interface RoleService {
    Role findByRoleName(RoleName roleName);

    Role add(Role role);
}
