package ru.red.sampleschoolexamplatform.dao.security;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.red.sampleschoolexamplatform.model.security.Role;

import java.util.Set;

public interface RoleDao extends JpaRepository<Role, String> {

}
