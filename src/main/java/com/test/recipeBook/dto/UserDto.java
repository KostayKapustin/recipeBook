package com.test.recipeBook.config.dto;

import com.test.recipeBook.model.Recipe;
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
public class UserDto {

    @Size(max = 50)
    String name;

    @Size(max = 50)
    String login;

    String password;

    @Size(max = 150)
    String description;

    List<Recipe> myRecipes = new ArrayList<>();
}
