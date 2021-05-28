package ru.red.sampleschoolexamplatform.service;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.red.sampleschoolexamplatform.dao.RoleDao;
import ru.red.sampleschoolexamplatform.model.security.Role;

import java.util.Set;

@Log
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    @Override
    public void deleteRole(Role role) {
        roleDao.deleteRole(role);
    }

    @Override
    public void addRole(Role role) {
         roleDao.addRole(role);
    }

    @Override
    public Role findRole(String role) {
        return roleDao.findRole(role);
    }

    @Override
    public Set<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}
