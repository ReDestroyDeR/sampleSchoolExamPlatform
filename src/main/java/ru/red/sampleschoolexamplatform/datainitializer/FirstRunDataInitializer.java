package ru.red.sampleschoolexamplatform.datainitializer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.red.sampleschoolexamplatform.model.security.Role;
import ru.red.sampleschoolexamplatform.model.security.User;
import ru.red.sampleschoolexamplatform.service.security.AuthorityService;
import ru.red.sampleschoolexamplatform.service.security.RoleService;
import ru.red.sampleschoolexamplatform.service.security.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class FirstRunDataInitializer {
    private final AuthorityService authorityService;
    private final RoleService roleService;
    private final UserService userService;

    @PostConstruct
    public void init() {
        if (userService.getAllUsers().size() == 0) {
            User root = new User();
            root.setUsername("root");
            root.setPassword("root");
            root.setEnabled(true);
            root.setAccountNonExpired(true);
            root.setAccountNonLocked(true);
            root.setCredentialsNonExpired(true);

            AuthoritiesDataInitializer authoritiesDataInitializer = new AuthoritiesDataInitializer(authorityService);
            authoritiesDataInitializer.initAuthorities();

            Role rootRole;

            // Cancellation of init if ROLE_ROOT exists
            if ((rootRole = roleService.findRole("ROOT")) == null) {
                rootRole = new Role();
                rootRole.setRole("ROOT");
                rootRole.setAuthorities(authorityService.getAuthorities());
                roleService.saveRole(rootRole);
            }


            List<Role> roles = new ArrayList<>();
            roles.add(rootRole);
            root.setRoles(roles);

            userService.addUser(root);
        }
    }
}
