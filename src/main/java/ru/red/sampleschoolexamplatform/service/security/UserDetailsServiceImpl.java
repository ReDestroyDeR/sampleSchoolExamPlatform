package ru.red.sampleschoolexamplatform.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.red.sampleschoolexamplatform.dao.security.UserDao;
import ru.red.sampleschoolexamplatform.model.security.Authority;
import ru.red.sampleschoolexamplatform.model.security.Role;
import ru.red.sampleschoolexamplatform.model.security.User;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;
    private final RoleService roleService;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao, RoleService roleService) {
        this.userDao = userDao;
        this.roleService = roleService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return new UserDetailsImpl(userDao.findByUsername(username).orElseThrow());
        } catch (NoSuchElementException e) {
            throw new UsernameNotFoundException(e.getMessage(), e);
        }
    }


    private List<Authority> convertRoleToAuthorities(Role role) {
        return roleService.findRole(role.getRole()).getAuthorities();
    }

    private class UserDetailsImpl implements UserDetails {
        private final User user;

        public UserDetailsImpl(User user) {
            this.user = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return user.getRoles()
                    .stream()
                    .flatMap(r -> convertRoleToAuthorities(r).stream())
                    .distinct()
                    .collect(Collectors.toList());
        }

        @Override
        public String getPassword() {
            return user.getPassword();
        }

        @Override
        public String getUsername() {
            return user.getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return user.isAccountNonExpired();
        }

        @Override
        public boolean isAccountNonLocked() {
            return user.isAccountNonLocked();
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return user.isCredentialsNonExpired();
        }

        @Override
        public boolean isEnabled() {
            return user.isEnabled();
        }
    }
}
