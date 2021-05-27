package ru.red.sampleschoolexamplatform.model.dto;

import ru.red.sampleschoolexamplatform.model.User;

import java.util.Set;
import java.util.stream.Collectors;

public record UserDto(Long id, String username, String password, Set<RoleDto> roleDtoSet) {
    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        // Converting role DTO via Stream API
        // Maybe slow but still faster than DB access
        user.setRoles(roleDtoSet.stream()
                                .map(RoleDto::toRole)
                                .collect(Collectors.toSet()));
        return user;
    }
}
