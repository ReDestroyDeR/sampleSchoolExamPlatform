package ru.red.sampleschoolexamplatform.datainitializer;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import ru.red.sampleschoolexamplatform.model.security.Role;
import ru.red.sampleschoolexamplatform.model.security.User;
import ru.red.sampleschoolexamplatform.service.security.AuthorityService;
import ru.red.sampleschoolexamplatform.service.security.RoleService;
import ru.red.sampleschoolexamplatform.service.security.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

@Log
@Service
@AllArgsConstructor
public class FirstRunDataInitializer {
    private final AuthorityService authorityService;
    private final RoleService roleService;
    private final UserService userService;

    @PostConstruct
    public void init() {
        if (userService.getAllUsers().size() == 0) {
            log.log(Level.INFO, "Executing first run event sequence");
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
                log.log(Level.INFO, "Generating ROLE_ROOT");
                rootRole = new Role();
                rootRole.setRole("ROOT");
                rootRole.setAuthorities(authorityService.getAuthorities());
                roleService.saveRole(rootRole);
            }


            List<Role> roles = new ArrayList<>();
            roles.add(rootRole);
            root.setRoles(roles);

            log.log(Level.INFO, "Adding root:root account");
            userService.addUser(root);
        }
    }
}
