package ru.red.sampleschoolexamplatform.dto.security;

import ru.red.sampleschoolexamplatform.model.security.Authority;

public record AuthorityDto(String authority) {
    public Authority toAuthority() {
        Authority authority = new Authority();
        authority.setAuthority(this.authority);
        return authority;
    }
}
