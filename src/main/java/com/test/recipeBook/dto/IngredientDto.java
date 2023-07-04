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
public class IngredientDto {

    @NotNull(message = "Name не может быть пустым")
    @Size(max = 50)
    String name;

    @NotNull(message = "Description не может быть пустым")
    @Size(max = 150)
    String description;
}
