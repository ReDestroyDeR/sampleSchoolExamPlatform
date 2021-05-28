package ru.red.sampleschoolexamplatform.controller.rest;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.red.sampleschoolexamplatform.model.security.User;
import ru.red.sampleschoolexamplatform.model.security.dto.UserDto;
import ru.red.sampleschoolexamplatform.service.UserService;

import java.util.Set;

@Log
@RestController
@RequestMapping("/api/users")
public class UsersRestController {
    private final UserService userService;

    @Autowired
    public UsersRestController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping
    public User updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto.toUser());
    }

    @DeleteMapping
    public void deleteUser(@RequestBody UserDto userDto) {
        userService.deleteUser(userDto.toUser());
    }

    @PostMapping
    public void addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto.toUser());
    }

    @GetMapping("/{user}")
    public User findUser(@PathVariable String user) {
        return (User) userService.loadUserByUsername(user);
    }

    @GetMapping
    public Set<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
