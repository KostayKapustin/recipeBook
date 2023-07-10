package com.test.recipeBook.service;

import com.test.recipeBook.dto.IngredientDto;
import com.test.recipeBook.dto.RecipeDto;
import com.test.recipeBook.model.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe addRecipe(RecipeDto recipeDto);

    RecipeDto addStep(Long id, String step);

    RecipeDto addIngredient(Long id, IngredientDto ingredientDto);

    RecipeDto getRecipeById(Long id);

    RecipeDto getRecipeByName(String name);

    List<RecipeDto> getListRecipeByTag(String tagName);

    RecipeDto updateRecipe(Long id, RecipeDto recipeDto);

    void deleteRecipe(Long id);

    List<RecipeDto> getAllRecipe();

    Recipe getRecipe(Long id);

    void saveRecipe(Recipe recipe);

    List<RecipeDto> getListRecipeLikeUser(Long id);

    List<RecipeDto> getFavoritesRecipeLikeUser(Long id);

}
