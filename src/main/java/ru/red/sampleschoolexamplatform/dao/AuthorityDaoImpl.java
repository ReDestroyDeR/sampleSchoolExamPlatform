package ru.red.sampleschoolexamplatform.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.red.sampleschoolexamplatform.model.security.Authority;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@Transactional
public class AuthorityDaoImpl implements AuthorityDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addAuthority(Authority authority) {
        try {
            //noinspection ResultOfMethodCallIgnored
            entityManager.getReference(Authority.class, authority.getAuthority()).toString();
        } catch (EntityNotFoundException e) {
            entityManager.persist(authority);
        }
    }

    @Override
    public Set<Authority> getAuthorities() {
        return entityManager
                .createQuery("SELECT a FROM Authority a", Authority.class)
                .getResultStream()
                .collect(Collectors.toSet());
    }
}
