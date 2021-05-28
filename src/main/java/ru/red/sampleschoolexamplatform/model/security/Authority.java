package ru.red.sampleschoolexamplatform.model.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authority")
public class Authority implements GrantedAuthority {
    @Id
    private String authority;
}
