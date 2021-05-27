package ru.red.sampleschoolexamplatform.dao;

import lombok.extern.java.Log;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.red.sampleschoolexamplatform.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;

@Log
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User deleteUser(User user) {
        return null;
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User findUser(Long id) {
        return null;
    }

    @Override
    public User findUser(String username) {
        return null;
    }

    @Override
    public Set<User> getAllUsers() {
        return null;
    }
}
