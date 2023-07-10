package com.test.recipeBook.model.authentication;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@ApiModel(value = "Токены" , description ="Класс объектов для последующей передачи данных токена")
public class JwtResponse {

    @ApiModelProperty(notes = "Тип", example = "Bearer",  position = 0)
    private final String type = "Bearer";

    @ApiModelProperty(notes = "токен", position = 1)
    private String accessToken;

    @ApiModelProperty(notes = "рефреш-токен", position = 0)
    private String refreshToken;

}
