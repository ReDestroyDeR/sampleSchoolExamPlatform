package ru.red.sampleschoolexamplatform.dao.security;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.red.sampleschoolexamplatform.model.security.User;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {
    @EntityGraph(value = "user-with-roles", type = EntityGraph.EntityGraphType.LOAD)
    Optional<User> findByUsername(String username);

    @NotNull
    @EntityGraph("user-with-roles")
    Optional<User> findById(@NotNull Long id);

    Optional<User> getByUsername(String username);
}
