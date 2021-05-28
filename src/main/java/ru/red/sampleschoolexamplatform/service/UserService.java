package ru.red.sampleschoolexamplatform.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.red.sampleschoolexamplatform.model.security.User;

import java.util.Set;

public interface UserService extends UserDetailsService {
    User updateUser(User user);

    void deleteUser(User user);

    void addUser(User user);

    User findUser(Long id);

    Set<User> getAllUsers();
}
