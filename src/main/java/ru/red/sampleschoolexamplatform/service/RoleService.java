package ru.red.sampleschoolexamplatform.service;

import ru.red.sampleschoolexamplatform.model.security.Role;

import java.util.Set;

public interface RoleService {
    Role updateRole(Role role);

    void deleteRole(Role role);

    void addRole(Role role);

    Role findRole(String role);

    Set<Role> getAllRoles();
}
