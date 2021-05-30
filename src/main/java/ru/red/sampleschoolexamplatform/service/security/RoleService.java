package ru.red.sampleschoolexamplatform.service.security;

import ru.red.sampleschoolexamplatform.model.security.Role;

import java.util.List;

public interface RoleService {
    void deleteRole(Role role);

    Role saveRole(Role role);

    Role findRole(String role);

    List<Role> findAllRoles();
}
