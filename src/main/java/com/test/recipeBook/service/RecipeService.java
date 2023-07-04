package com.test.recipeBook.service;

import com.test.recipeBook.dto.RecipeDto;
import com.test.recipeBook.model.Recipe;

import java.util.List;

public interface RecipeService {

    RecipeDto addRecipe(Long id, RecipeDto recipeDto);

    RecipeDto addStep(Long id, String step);

    RecipeDto getRecipeById(Long id);

    RecipeDto getRecipeByName(String name);

    List<RecipeDto> getListRecipeByTag(String tagName);

    RecipeDto updateRecipe(Long id, RecipeDto recipeDto);

    void deleteRecipe(Long id);

    List<RecipeDto> getAllRecipe();

    Recipe getRecipe(Long id);
}
