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
@ApiModel(value = "Тег" , description ="Класс объектов для последующей передачи данных")
public class TagDto {

    @ApiModelProperty(notes = "Имя", required = true, example = "Десерд",  position = 0)
    @NotNull(message = "Name не может быть пустым")
    @Size(max = 100)
    String name;

    @ApiModelProperty(notes = "Описание", required = true, example = "Чем удивить гостей ...",  position = 1)
    @Size(max = 150)
    String description;
}
