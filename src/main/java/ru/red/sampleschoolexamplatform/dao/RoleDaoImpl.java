package ru.red.sampleschoolexamplatform.dao;

import lombok.extern.java.Log;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.red.sampleschoolexamplatform.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;

@Log
@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role updateRole(Role role) {
        return null;
    }

    @Override
    public Role deleteRole(Role role) {
        return null;
    }

    @Override
    public Role addRole(Role role) {
        return null;
    }

    @Override
    public Role findRole(String role) {
        return null;
    }

    @Override
    public Set<Role> getAllRoles() {
        return null;
    }
}
