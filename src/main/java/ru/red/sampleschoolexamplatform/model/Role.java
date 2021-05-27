package ru.red.sampleschoolexamplatform.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    private String role;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_authorities",
               joinColumns = @JoinColumn(name = "role", referencedColumnName = "role"),
               inverseJoinColumns = @JoinColumn(name = "authority", referencedColumnName = "authority"))
    private Set<Authority> authorities;
}
