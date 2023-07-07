package com.test.recipeBook.config.dto;

import com.test.recipeBook.model.Ingredient;
import com.test.recipeBook.model.Tag;
import com.test.recipeBook.model.User;
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
public class RecipeDto {

    @NotNull(message = "Name не может быть пустым")
    @Size(max = 50)
    String name;

    @NotNull(message = "ImagePath не может быть пустым")
    String imagePath;

    @NotNull(message = "Description не может быть пустым")
    @Size(max = 150)
    String description;

    List<Tag> tags = new ArrayList<>();

    @NotNull(message = "CookingTime не может быть пустым")
    Integer cookingTime;

    @NotNull(message = "PortionsDish не может быть пустым")
    Integer portionsDish;

    List<Ingredient> ingredients = new ArrayList<>();

    List<User> favorites = new ArrayList<>();

    List<User> likes = new ArrayList<>();

    List<String> descriptionStep = new ArrayList<>();
}
