package com.test.recipeBook.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE)
@ApiModel(value = "Шаг" , description ="Класс объектов для последующей передачи данных")
public class StepDto {

    @ApiModelProperty(notes = "Описание шага", required = true, example = "Разморозить...")
    @NotNull(message = "Step не может быть пустым")
    String step;
}
