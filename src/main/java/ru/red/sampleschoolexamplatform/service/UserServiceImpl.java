package ru.red.sampleschoolexamplatform.service;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.red.sampleschoolexamplatform.dao.UserDao;
import ru.red.sampleschoolexamplatform.model.security.User;

import java.util.Set;

@Log
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.findUser(username);
    }

    @Override
    public User updateUser(User user) {
        // New password situation
        if (!passwordEncoder.matches(user.getPassword(),
                                     findUser(user.getId()).getPassword()))
            user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userDao.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.addUser(user);
    }

    @Override
    public User findUser(Long id) {
        return userDao.findUser(id);
    }

    @Override
    public Set<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
