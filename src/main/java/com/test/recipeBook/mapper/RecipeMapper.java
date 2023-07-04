package com.test.recipeBook.mapper;

import com.test.recipeBook.dto.RecipeDto;
import com.test.recipeBook.model.Recipe;

public class RecipeMapper {

    public static Recipe toRecipe(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeDto.getName());
        recipe.setImagePath(recipeDto.getImagePath());
        recipe.setDescription(recipeDto.getDescription());
        recipe.setTags(recipeDto.getTags());
        recipe.setCookingTime(recipeDto.getCookingTime());
        recipe.setPortionsDish(recipeDto.getPortionsDish());
        recipe.setIngredients(recipeDto.getIngredients());
        recipe.setFavorites(recipeDto.getFavorites());
        recipe.setLikes(recipeDto.getLikes());
        recipe.setDescriptionStep(recipeDto.getDescriptionStep());
        return recipe;
    }

    public static RecipeDto toRecipeDto(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setName(recipe.getName());
        recipeDto.setImagePath(recipe.getImagePath());
        recipeDto.setDescription(recipe.getDescription());
        recipeDto.setTags(recipe.getTags());
        recipeDto.setCookingTime(recipe.getCookingTime());
        recipeDto.setPortionsDish(recipe.getPortionsDish());
        recipeDto.setIngredients(recipe.getIngredients());
        recipeDto.setFavorites(recipe.getFavorites());
        recipeDto.setLikes(recipe.getLikes());
        recipeDto.setDescriptionStep(recipe.getDescriptionStep());
        return recipeDto;
    }
}
