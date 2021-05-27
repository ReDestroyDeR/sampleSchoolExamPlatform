package ru.red.sampleschoolexamplatform.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.red.sampleschoolexamplatform.model.User;

import java.util.Set;

public interface UserService extends UserDetailsService {
    User updateUser(User user);

    User deleteUser(User user);

    User addUser(User user);

    User findUser(Long id);

    Set<User> getAllUsers();
}
