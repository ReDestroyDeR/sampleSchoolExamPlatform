package ru.red.sampleschoolexamplatform.dao;

import ru.red.sampleschoolexamplatform.model.security.User;

import java.util.Set;

public interface UserDao {
    User updateUser(User user);

    void deleteUser(User user);

    void addUser(User user);

    User findUser(Long id);

    User findUser(String username);

    Set<User> getAllUsers();
}
