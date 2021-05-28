package ru.red.sampleschoolexamplatform.model.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    // Keep in mind that if we're using LAZY fetch we're forced to fetch roles by request
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name="id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "role", referencedColumnName = "role"))
    private Set<Role> roles;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().flatMap(r -> r.getAuthorities().stream()).collect(Collectors.toSet());
    }
}
