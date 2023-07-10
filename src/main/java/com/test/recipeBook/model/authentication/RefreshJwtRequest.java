package com.test.recipeBook.model.authentication;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "Рефреш-токен" , description ="Класс объектов для последующей передачи данных для входа")
public class RefreshJwtRequest {

    @ApiModelProperty(notes = "Рефреш-токен", position = 0)
    public String refreshToken;

}
