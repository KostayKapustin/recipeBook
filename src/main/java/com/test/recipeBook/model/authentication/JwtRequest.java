package com.test.recipeBook.model.authentication;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Setter
@Getter
@ApiModel(value = "Вход" , description ="Класс объектов для последующей передачи данных для входа")
public class JwtRequest {

    @ApiModelProperty(notes = "логин", required = true, example = "Kostya2000",  position = 0)
    private String login;

    @ApiModelProperty(notes = "пародь", required = true, example = "qwerty",  position = 1)
    private String password;

    @ApiModelProperty(notes = "Время создания", example = "2022-05-01",  position = 2)
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