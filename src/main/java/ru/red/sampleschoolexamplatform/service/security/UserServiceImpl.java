package ru.red.sampleschoolexamplatform.service.security;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User updateUser(User user) {
        // New password situation
        if (!passwordEncoder.matches(user.getPassword(),
                                     findUserById(user.getId()).getPassword()))
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
    public User findUserById(Long id) {
        return userDao.findById(id).orElseThrow();
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findByUsername(username).orElseThrow();
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}
