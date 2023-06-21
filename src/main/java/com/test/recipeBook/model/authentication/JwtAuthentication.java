package com.test.recipeBook.model.authentication;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.DigestUtils;

import java.util.Collection;

@Getter
@Setter
public class JwtAuthentication extends AbstractAuthenticationToken {
    private String username;

    public JwtAuthentication(String principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.username = principal;
    }

    public void authenticate() {
        if (getDetails() != null && getDetails() instanceof JwtRequest && !((JwtRequest) getDetails()).hasExpired()) {
            setAuthenticated(true);
        } else {
            setAuthenticated(false);
        }
    }

    @Override
    public Object getCredentials() {
        return "";
    }

    @Override
    public Object getPrincipal() {
        return username != null ? username.toString() : "";
    }

    public String getHash() {
        return DigestUtils.md5DigestAsHex(String.format("%s_%d", username, ((JwtRequest) getDetails()).getCreated().getTime()).getBytes());
    }
}
