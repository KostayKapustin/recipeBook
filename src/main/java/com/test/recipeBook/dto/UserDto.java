package com.test.recipeBook.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE)
@ApiModel(value = "Пользователь", description = "Класс объектов для последующей передачи данных")
public class UserDto {

    @ApiModelProperty(notes = "Имя", required = true, example = "Костя", position = 0)
    @Size(max = 50)
    String name;

    @ApiModelProperty(notes = "Логин", required = true, example = "Kostya2000", position = 1)
    @Size(max = 50)
    String login;

    @ApiModelProperty(notes = "Пароль", required = true, example = "qwerty", position = 2)
    String password;

    @ApiModelProperty(notes = "Описание", required = true, example = "Я ...", position = 3)
    @Size(max = 150)
    String description;

    @ApiModelProperty(notes = "Список своих рецептов", position = 4)
    List<RecipeDto> myRecipes = new ArrayList<>();
}
