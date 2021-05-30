package ru.red.sampleschoolexamplatform.service.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.red.sampleschoolexamplatform.model.security.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    User updateUser(User user);

    void deleteUser(User user);

    void addUser(User user);

    User findUser(Long id);

    List<User> getAllUsers();
}
