package com.test.recipeBook.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRegistrationDto {

    @NotNull(message = "Name не может быть Null!")
    @Size(min = 3, max = 50)
    String name;

    @NotNull(message = "Login не может быть Null!")
    @Size(min = 3, max = 50)
    String login;

    @NotNull(message = "Password не может быть Null!")
    @Size(min = 8, max = 50)
    String password;

    @NotNull(message = "RepeatedPassword не может быть Null!")
    @Size(min = 8, max = 50)
    String repeatedPassword;
}
