package com.test.recipeBook.mapper;

import com.test.recipeBook.dto.RecipeDto;
import com.test.recipeBook.model.Recipe;

public class RecipeMapper {

    public static Recipe toRecipe(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeDto.getName());
        recipe.setImagePath(recipeDto.getImagePath());
        recipe.setDescription(recipeDto.getDescription());
        for(var tagDto : recipeDto.getTags()){
            recipe.getTags().add(TagMapper.toTag(tagDto));
        }
        recipe.setCookingTime(recipeDto.getCookingTime());
        recipe.setPortionsDish(recipeDto.getPortionsDish());
        for(var ingredientDto : recipeDto.getIngredients()) {
            recipe.getIngredients().add(IngredientMapper.toIngredient(ingredientDto));
        }
        for(var favoriteDto : recipeDto.getFavorites()) {
            recipe.getFavorites().add(UserMapper.toUser(favoriteDto));
        }
        for(var likeDto : recipeDto.getLikes()) {
            recipe.getLikes().add(UserMapper.toUser(likeDto));
        }
        recipe.setDescriptionStep(recipeDto.getDescriptionStep());
        return recipe;
    }

    public static RecipeDto toRecipeDto(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setName(recipe.getName());
        recipeDto.setImagePath(recipe.getImagePath());
        recipeDto.setDescription(recipe.getDescription());
        for(var tag : recipe.getTags()){
            recipeDto.getTags().add(TagMapper.toTagDto(tag));
        }
        recipeDto.setCookingTime(recipe.getCookingTime());
        recipeDto.setPortionsDish(recipe.getPortionsDish());
        for(var ingredient : recipe.getIngredients()) {
            recipeDto.getIngredients().add(IngredientMapper.toIngredientDto(ingredient));
        }
        for(var favorite : recipe.getFavorites()) {
            recipeDto.getFavorites().add(UserMapper.toUserDto(favorite));
        }
        for(var like : recipe.getLikes()) {
            recipeDto.getLikes().add(UserMapper.toUserDto(like));
        }
        recipeDto.setDescriptionStep(recipe.getDescriptionStep());
        return recipeDto;
    }
}
