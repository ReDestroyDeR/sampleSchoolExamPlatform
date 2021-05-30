package ru.red.sampleschoolexamplatform.service.security;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.red.sampleschoolexamplatform.dao.security.UserDao;
import ru.red.sampleschoolexamplatform.model.security.User;

import java.util.List;

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
        return userDao.findByUsername(username).orElse(null);
    }

    @Override
    public User updateUser(User user) {
        // New password situation
        if (!passwordEncoder.matches(user.getPassword(),
                                     findUser(user.getId()).getPassword()))
            user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userDao.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.delete(user);
    }

    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public User findUser(Long id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}
