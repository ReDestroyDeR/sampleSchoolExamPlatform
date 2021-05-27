package ru.red.sampleschoolexamplatform.dao;

import ru.red.sampleschoolexamplatform.model.User;

import java.util.Set;

public interface UserDao {
    User updateUser(User user);

    User deleteUser(User user);

    User addUser(User user);

    User findUser(Long id);

    User findUser(String username);

    Set<User> getAllUsers();
}
