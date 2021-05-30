package ru.red.sampleschoolexamplatform.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import ru.red.sampleschoolexamplatform.dao.security.AuthorityDao;
import ru.red.sampleschoolexamplatform.model.security.Authority;

import java.util.List;

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
        authorityDao.save(new Authority(authority));
    }

    @Override
    public List<Authority> getAuthorities() {
        return authorityDao.findAll();
    }
}
