package com.test.recipeBook.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE)
@ApiModel(value = "Пользователь регистрация" , description ="Класс объектов для последующей передачи данных")
public class UserRegistrationDto {

    @ApiModelProperty(notes = "Имя", required = true, example = "Костя",  position = 0)
    @NotNull(message = "Name не может быть Null!")
    @Size(min = 3, max = 50)
    String name;

    @ApiModelProperty(notes = "ЛОгин", required = true, example = "Kostya2000",  position = 1)
    @NotNull(message = "Login не может быть Null!")
    @Size(min = 3, max = 50)
    String login;

    @ApiModelProperty(notes = "Пароль", required = true, example = "qwerty",  position = 2)
    @NotNull(message = "Password не может быть Null!")
    @Size(min = 8, max = 50)
    String password;

    @ApiModelProperty(notes = "Пароль повторный", required = true, example = "qwerty",  position = 3)
    @NotNull(message = "RepeatedPassword не может быть Null!")
    @Size(min = 8, max = 50)
    String repeatedPassword;
}
