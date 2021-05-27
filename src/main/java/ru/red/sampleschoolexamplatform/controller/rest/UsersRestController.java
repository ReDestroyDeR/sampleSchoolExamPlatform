package ru.red.sampleschoolexamplatform.controller.rest;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.red.sampleschoolexamplatform.model.User;
import ru.red.sampleschoolexamplatform.model.dto.RoleDto;
import ru.red.sampleschoolexamplatform.model.dto.UserDto;
import ru.red.sampleschoolexamplatform.service.RoleService;
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
    public User deleteUser(@RequestBody UserDto userDto) {
        return userService.deleteUser(userDto.toUser());
    }

    @PostMapping
    public User addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto.toUser());
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