package com.test.recipeBook.service.impl;

import com.test.recipeBook.dto.IngredientDto;
import com.test.recipeBook.dto.RecipeDto;
import com.test.recipeBook.exception.IngredientNotFoundException;
import com.test.recipeBook.mapper.IngredientMapper;
import com.test.recipeBook.mapper.RecipeMapper;
import com.test.recipeBook.model.Ingredient;
import com.test.recipeBook.model.Recipe;
import com.test.recipeBook.repository.IngredientRepository;
import com.test.recipeBook.service.IngredientService;
import com.test.recipeBook.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final RecipeService recipeService;

    @Override
    public RecipeDto addIngredient(Long id, IngredientDto ingredientDto) {
        if(recipeService.getRecipe(id) != null) {
            Ingredient ingredient = ingredientRepository.save(IngredientMapper.toIngredient(ingredientDto));
            Recipe recipe = recipeService.getRecipe(id);
            recipe.getIngredients().add(ingredient);
            return RecipeMapper.toRecipeDto(recipe);
        }
        return null;
    }

    @Override
    public IngredientDto updateIngredient(Long id, IngredientDto ingredientDto) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new IngredientNotFoundException(id));
        ingredient.setName(ingredientDto.getName());
        ingredient.setDescription(ingredientDto.getDescription());
        return IngredientMapper.toIngredientDto(ingredient);
    }

    @Override
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }
}
