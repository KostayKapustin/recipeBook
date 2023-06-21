package com.test.recipeBook.security;

import com.test.recipeBook.model.authentication.JwtAuthentication;
import io.jsonwebtoken.Claims;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collections;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JwtUtils {
    public static JwtAuthentication generate(Claims claims) {
        final JwtAuthentication jwtInfoToken = new JwtAuthentication(claims.get("username",String.class), Collections.emptyList());
        jwtInfoToken.setUsername(claims.get("username",String.class));
        jwtInfoToken.setUsername(claims.getSubject());
        return jwtInfoToken;
    }



}
