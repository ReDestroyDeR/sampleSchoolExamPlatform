package ru.red.sampleschoolexamplatform.service.security;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.red.sampleschoolexamplatform.dao.security.RoleDao;
import ru.red.sampleschoolexamplatform.model.security.Role;

import java.util.List;

@Log
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void deleteRole(Role role) {
        roleDao.delete(role);
    }

    @Override
    public Role saveRole(Role role) {
         return roleDao.save(role);
    }

    @Override
    public Role findRole(String role) {
        return roleDao.findById(role).orElse(null);
    }

    @Override
    public List<Role> findAllRoles() {
        return roleDao.findAll();
    }
}
