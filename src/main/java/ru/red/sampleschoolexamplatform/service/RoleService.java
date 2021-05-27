package ru.red.sampleschoolexamplatform.service;

import ru.red.sampleschoolexamplatform.model.Role;

import java.util.Set;

public interface RoleService {
    Role updateRole(Role role);

    Role deleteRole(Role role);

    Role addRole(Role role);

    Role findRole(String role);

    Set<Role> getAllRoles();
}
