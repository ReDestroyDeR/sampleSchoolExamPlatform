package ru.red.sampleschoolexamplatform.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "authority")
public class Authority implements GrantedAuthority {
    @Id
    private String authority;
}
