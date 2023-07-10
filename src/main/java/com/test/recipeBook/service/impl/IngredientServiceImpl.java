package com.test.recipeBook.service.impl;

import com.test.recipeBook.dto.IngredientDto;
import com.test.recipeBook.exception.IngredientNotFoundException;
import com.test.recipeBook.mapper.IngredientMapper;
import com.test.recipeBook.model.Ingredient;
import com.test.recipeBook.model.Recipe;
import com.test.recipeBook.repository.IngredientRepository;
import com.test.recipeBook.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Override
    public Recipe addIngredient(Recipe recipe, IngredientDto ingredientDto) {
            Ingredient ingredient = ingredientRepository.save(IngredientMapper.toIngredient(ingredientDto));
            recipe.getIngredients().add(ingredient);
            return recipe;
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
