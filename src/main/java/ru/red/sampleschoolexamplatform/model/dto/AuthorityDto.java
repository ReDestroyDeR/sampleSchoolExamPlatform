package ru.red.sampleschoolexamplatform.model.dto;

import ru.red.sampleschoolexamplatform.model.Authority;

public record AuthorityDto(String authority) {
    public Authority toAuthority() {
        Authority authority = new Authority();
        authority.setAuthority(this.authority);
        return authority;
    }
}
