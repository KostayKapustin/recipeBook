package com.test.recipeBook.config.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TagDto {

    @NotNull(message = "Name не может быть пустым")
    @Size(max = 100)
    String name;

    @Size(max = 150)
    String description;
}
