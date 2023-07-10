package com.test.recipeBook.service;

import com.test.recipeBook.dto.IngredientDto;
import com.test.recipeBook.model.Recipe;

public interface IngredientService {

    Recipe addIngredient(Recipe recipe, IngredientDto ingredientDto);

    IngredientDto updateIngredient(Long id, IngredientDto ingredientDto);

    void deleteIngredient(Long id);
}
