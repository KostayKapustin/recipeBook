package com.test.recipeBook.service;

import com.test.recipeBook.dto.IngredientDto;
import com.test.recipeBook.dto.RecipeDto;

public interface IngredientService {
    RecipeDto addIngredient(Long id, IngredientDto ingredientDto);

    IngredientDto updateIngredient(Long id, IngredientDto ingredientDto);

    void deleteIngredient(Long id);
}
