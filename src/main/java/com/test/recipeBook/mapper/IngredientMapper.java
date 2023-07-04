package com.test.recipeBook.mapper;

import com.test.recipeBook.dto.IngredientDto;
import com.test.recipeBook.model.Ingredient;

public class IngredientMapper {

    public static Ingredient toIngredient(IngredientDto ingredientDto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientDto.getName());
        ingredient.setDescription(ingredientDto.getDescription());
        return ingredient;
    }

    public static IngredientDto toIngredientDto(Ingredient ingredient) {
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setDescription(ingredient.getDescription());
        return ingredientDto;
    }
}
