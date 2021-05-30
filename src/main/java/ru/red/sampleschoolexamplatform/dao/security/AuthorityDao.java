package ru.red.sampleschoolexamplatform.dao.security;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.red.sampleschoolexamplatform.model.security.Authority;

public interface AuthorityDao extends JpaRepository<Authority, String> {
}
