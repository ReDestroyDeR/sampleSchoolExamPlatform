package ru.red.sampleschoolexamplatform.controller.rest;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.red.sampleschoolexamplatform.model.Role;
import ru.red.sampleschoolexamplatform.model.dto.RoleDto;
import ru.red.sampleschoolexamplatform.service.RoleService;

import java.util.Set;

@Log
@RestController
@RequestMapping("/api/roles")
public class RolesRestController {
    private final RoleService roleService;

    @Autowired
    public RolesRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PutMapping
    public Role updateRole(@RequestBody RoleDto roleDto) {
        return roleService.updateRole(roleDto.toRole());
    }

    @DeleteMapping
    public Role deleteRole(@RequestBody RoleDto roleDto) {
        return roleService.deleteRole(roleDto.toRole());
    }

    @PostMapping
    public Role addRole(@RequestBody RoleDto roleDto) {
        return roleService.addRole(roleDto.toRole());
    }

    @GetMapping("/{role}")
    public Role findRole(@PathVariable String role) {
        return roleService.findRole(role);
    }

    @GetMapping
    public Set<Role> getAllRoles() {
        return roleService.getAllRoles();
    }
}
