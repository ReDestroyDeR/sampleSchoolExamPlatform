package ru.red.sampleschoolexamplatform.dao;

import lombok.extern.java.Log;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.red.sampleschoolexamplatform.model.security.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;
import java.util.stream.Collectors;

@Log
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findUser(Long id) {
        return entityManager
                .createQuery("SELECT u FROM User u WHERE u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public User findUser(String username) {
        return entityManager
                .createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    @Override
    public Set<User> getAllUsers() {
        return entityManager
                .createQuery("SELECT u FROM User u", User.class)
                .getResultStream()
                .collect(Collectors.toSet());
    }
}
