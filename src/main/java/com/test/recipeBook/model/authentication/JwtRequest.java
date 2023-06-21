package com.test.recipeBook.model.authentication;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Setter
@Getter
public class JwtRequest {

    private String login;
    private String password;
    private Date created;

    public boolean hasExpired() {
        if (created == null) {
            return true;
        }
        LocalDateTime localDateTime = created.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        localDateTime = localDateTime.plusHours(1);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()).before(new Date());
    }

}