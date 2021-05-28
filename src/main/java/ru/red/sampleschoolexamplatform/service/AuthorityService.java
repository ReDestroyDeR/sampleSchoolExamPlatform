package ru.red.sampleschoolexamplatform.service;

import ru.red.sampleschoolexamplatform.model.security.Authority;

import java.util.Set;

public interface AuthorityService {
    void addAuthority(String authority);
    Set<Authority> getAuthorities();
}
