package ru.red.sampleschoolexamplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import ru.red.sampleschoolexamplatform.dao.AuthorityDao;
import ru.red.sampleschoolexamplatform.model.security.Authority;

import java.util.Set;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    private final AuthorityDao authorityDao;

    @Autowired
    public AuthorityServiceImpl(AuthorityDao authorityDao) {
        this.authorityDao = authorityDao;
    }

    @Override
    @Secured("")
    public void addAuthority(String authority) {
        authorityDao.addAuthority(new Authority(authority));
    }

    @Override
    public Set<Authority> getAuthorities() {
        return authorityDao.getAuthorities();
    }
}
