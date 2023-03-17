package com.gmail.smaglenko.blogapp.service.impl;

import com.gmail.smaglenko.blogapp.model.Role;
import com.gmail.smaglenko.blogapp.model.Role.RoleName;
import com.gmail.smaglenko.blogapp.repository.RoleRepository;
import com.gmail.smaglenko.blogapp.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    public Role findByRoleName(RoleName roleName) {
        return repository.findByRoleName(roleName);
    }

    @Override
    public Role add(Role role) {
        return repository.save(role);
    }
}
