package ru.red.sampleschoolexamplatform.model.security;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "role")
    private String role;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_authorities",
               joinColumns = @JoinColumn(name = "role", referencedColumnName = "role"),
               inverseJoinColumns = @JoinColumn(name = "authority", referencedColumnName = "authority"))
    private List<Authority> authorities;
}
