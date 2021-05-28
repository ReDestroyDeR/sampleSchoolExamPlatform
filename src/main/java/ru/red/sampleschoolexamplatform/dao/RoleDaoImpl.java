package ru.red.sampleschoolexamplatform.dao;

import lombok.extern.java.Log;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.red.sampleschoolexamplatform.model.security.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;
import java.util.stream.Collectors;

@Log
@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role updateRole(Role role) {
        return entityManager.merge(role);
    }

    @Override
    public void deleteRole(Role role) {
        entityManager.remove(role);
    }

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Role findRole(String role) {
        return entityManager
                .createQuery("SELECT r FROM Role r WHERE r.role = :role", Role.class)
                .setParameter("role", role)
                .getSingleResult();
    }

    @Override
    public Set<Role> getAllRoles() {
        return entityManager
                .createQuery("SELECT r FROM Role r", Role.class)
                .getResultStream()
                .collect(Collectors.toSet());
    }
}
