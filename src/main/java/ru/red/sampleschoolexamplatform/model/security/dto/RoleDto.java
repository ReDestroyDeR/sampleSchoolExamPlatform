package ru.red.sampleschoolexamplatform.model.security.dto;

import ru.red.sampleschoolexamplatform.model.security.Role;

import java.util.Set;
import java.util.stream.Collectors;

public record RoleDto(String role, Set<AuthorityDto> authorityDtoSet) {
    public Role toRole() {
        Role role = new Role();
        role.setRole(this.role);
        // Same trick as in UserDto
        role.setAuthorities(authorityDtoSet.stream()
                                           .map(AuthorityDto::toAuthority)
                                           .collect(Collectors.toSet()));
        return role;
    }
}
