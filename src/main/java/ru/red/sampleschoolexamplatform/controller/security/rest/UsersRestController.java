package ru.red.sampleschoolexamplatform.controller.security.rest;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.red.sampleschoolexamplatform.model.security.User;
import ru.red.sampleschoolexamplatform.dto.security.UserDto;
import ru.red.sampleschoolexamplatform.service.security.UserService;

import java.util.List;

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
    public ResponseEntity<User> updateUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.updateUser(userDto.toUser()), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestBody UserDto userDto) {
        userService.deleteUser(userDto.toUser());
        return new ResponseEntity<>("Deleted " + userDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto.toUser());
        return new ResponseEntity<>("Added " + userDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUser(@PathVariable String id) {
        return new ResponseEntity<>(userService.findUserById(Long.parseLong(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}
