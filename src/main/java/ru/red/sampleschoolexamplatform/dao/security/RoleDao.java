package ru.red.sampleschoolexamplatform.dao.security;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.red.sampleschoolexamplatform.model.security.Role;

import java.util.Optional;

public interface RoleDao extends JpaRepository<Role, String> {

    @NotNull
    @EntityGraph(attributePaths = "authorities")
    Optional<Role> findByRole(@NotNull String id);
}
