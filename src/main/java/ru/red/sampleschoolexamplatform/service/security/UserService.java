package ru.red.sampleschoolexamplatform.service.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.red.sampleschoolexamplatform.model.security.User;

import java.util.List;

public interface UserService {
    User updateUser(User user);

    void deleteUser(User user);

    void addUser(User user);

    List<User> getAllUsers();

    User findUserById(Long id);

    User findUserByUsername(String user);
}
