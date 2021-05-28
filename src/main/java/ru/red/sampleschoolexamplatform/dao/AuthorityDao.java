package ru.red.sampleschoolexamplatform.dao;

import ru.red.sampleschoolexamplatform.model.security.Authority;

import java.util.Set;

public interface AuthorityDao {
    void addAuthority(Authority authority);
    Set<Authority> getAuthorities();
}
