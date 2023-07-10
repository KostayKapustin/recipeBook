package com.test.recipeBook.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE)
@ApiModel(value = "Рецепты" , description ="Класс объектов для последующей передачи данных")
public class RecipeDto {

    @ApiModelProperty(notes = "Имя", required = true, example = "Клубничная панна-котта",  position = 0)
    @NotNull(message = "Name не может быть пустым")
    @Size(max = 50)
    String name;

    @ApiModelProperty(notes = "Ссылка на фото", required = true,  position = 1)
    @NotNull(message = "ImagePath не может быть пустым")
    String imagePath;

    @ApiModelProperty(notes = "Описание", required = true, example = "Десерт, который ...",  position = 2)
    @NotNull(message = "Description не может быть пустым")
    @Size(max = 150)
    String description;

    @ApiModelProperty(notes = "Список тегов", example = "Детское, мясо, десерты",  position = 3)
    List<TagDto> tags = new ArrayList<>();

    @ApiModelProperty(notes = "Время приготовления", required = true, example = "40",  position = 4)
    @NotNull(message = "CookingTime не может быть пустым")
    Integer cookingTime;

    @ApiModelProperty(notes = "Количество порций", required = true, example = "3",  position = 5)
    @NotNull(message = "PortionsDish не может быть пустым")
    Integer portionsDish;

    @ApiModelProperty(notes = "Список ингредиентов", position = 6)
    List<IngredientDto> ingredients = new ArrayList<>();

    @ApiModelProperty(notes = "Список пользователей, которые добавили в избранные", position = 7)
    List<UserDto> favorites = new ArrayList<>();

    @ApiModelProperty(notes = "Список лайкнувших пользователей", position = 8)
    List<UserDto> likes = new ArrayList<>();

    @ApiModelProperty(notes = "Список шагов", position = 9)
    List<String> descriptionStep = new ArrayList<>();
}
