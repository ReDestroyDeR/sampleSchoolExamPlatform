package ru.red.sampleschoolexamplatform.dto.security;

import ru.red.sampleschoolexamplatform.model.security.User;

import java.util.Arrays;
import java.util.stream.Collectors;

public record UserDto(Long id, String username, String password, RoleDto[] roleDtoSet) {
    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        // Converting role DTO via Stream API
        // Maybe slow but still faster than DB access
        user.setRoles(Arrays.stream(roleDtoSet)
                                .map(RoleDto::toRole)
                                .collect(Collectors.toList()));
        return user;
    }
}
