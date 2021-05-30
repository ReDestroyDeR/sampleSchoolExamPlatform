package ru.red.sampleschoolexamplatform.service.security;

import ru.red.sampleschoolexamplatform.model.security.Authority;

import java.util.List;

public interface AuthorityService {
    void addAuthority(String authority);

    List<Authority> getAuthorities();
}
