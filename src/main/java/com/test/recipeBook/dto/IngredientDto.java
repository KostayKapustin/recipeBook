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
@ApiModel(value = "Ингредиенты" , description ="Класс объектов для последующей передачи данных")
public class IngredientDto {

    @ApiModelProperty(notes = "Имя", required = true, example = "Для панна котты",  position = 0)
    @NotNull(message = "Name не может быть пустым")
    @Size(max = 50)
    String name;

    @ApiModelProperty(notes = "Описание", required = true, example = "сахар-3ст.л.",  position = 1)
    @NotNull(message = "Description не может быть пустым")
    @Size(max = 150)
    String description;
}
