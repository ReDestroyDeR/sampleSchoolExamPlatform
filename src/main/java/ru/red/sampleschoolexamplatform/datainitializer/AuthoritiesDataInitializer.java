package ru.red.sampleschoolexamplatform.datainitializer;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import ru.red.sampleschoolexamplatform.service.AuthorityService;

import java.util.Arrays;

@Log
@RequiredArgsConstructor
public class AuthoritiesDataInitializer {
    private final AuthorityService authorityService;

    private final String[] authorities = {
            "OP_ROLES_MANAGEMENT",
            "OP_USERS_MANAGEMENT",
            "OP_EXAMS_MANAGEMENT",
            "OP_USERS_ACCESS",
            "OP_EXAMS_ACCESS",
            "OP_CABINET_ACCESS"
    };

    public void initAuthorities() {
        Arrays.stream(authorities).forEach(authorityService::addAuthority);
    }
}
