package com.gmail.smaglenko.blogapp.repository;

import com.gmail.smaglenko.blogapp.model.Role;
import com.gmail.smaglenko.blogapp.model.Role.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(RoleName roleName);
}
