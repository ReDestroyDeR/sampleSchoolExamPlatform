package ru.red.sampleschoolexamplatform.dao;

import ru.red.sampleschoolexamplatform.model.security.Role;

import java.util.Set;

public interface RoleDao {
    Role updateRole(Role role);

    void deleteRole(Role role);

    void addRole(Role role);

    Role findRole(String role);

    Set<Role> getAllRoles();
}
