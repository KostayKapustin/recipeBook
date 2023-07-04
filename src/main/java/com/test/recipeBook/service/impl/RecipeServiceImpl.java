package com.test.recipeBook.service.impl;

import com.test.recipeBook.dto.RecipeDto;
import com.test.recipeBook.exception.RecipeByNameNotFoundException;
import com.test.recipeBook.exception.RecipeByTagNotFoundException;
import com.test.recipeBook.exception.RecipeNotFoundException;
import com.test.recipeBook.mapper.RecipeMapper;
import com.test.recipeBook.model.Recipe;
import com.test.recipeBook.repository.RecipeRepository;
import com.test.recipeBook.service.RecipeService;
import com.test.recipeBook.service.TagService;
import com.test.recipeBook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final TagService tagService;
    private final UserService userService;

    @Override
    public RecipeDto addRecipe(Long id, RecipeDto recipeDto) {
        System.out.println(recipeDto.getTags());
        if (userService.getUser(id) != null) {
            Recipe recipe = RecipeMapper.toRecipe(recipeDto);
            recipeRepository.save(recipe);
            userService.addMyRecipe(id, recipe);
            return RecipeMapper.toRecipeDto(recipe);
        }
        return null;
    }

    @Override
    public RecipeDto addStep(Long id, String step) {
        getRecipe(id).getDescriptionStep().add(step);
        return getRecipeById(id);
    }

    @Override
    public RecipeDto getRecipeById(Long id) {
        return RecipeMapper.toRecipeDto(recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id)));
    }

    @Override
    public RecipeDto getRecipeByName(String name) {
        return RecipeMapper.toRecipeDto(recipeRepository.getRecipeByName(name)
                .orElseThrow(() -> new RecipeByNameNotFoundException(name)));
    }

    @Override
    public List<RecipeDto> getListRecipeByTag(String tagName) {
        Long tagId = tagService.getTagByName(tagName);
        if (tagId == null) throw new RecipeByTagNotFoundException(tagName);
        List<RecipeDto> recipe = new ArrayList<>();
        for(var id : tagService.getRecipeIdByTagId(tagId)) {
            recipe.add(getRecipeById(id));
        }
        return recipe;
    }

    @Override
    public RecipeDto updateRecipe(Long id, RecipeDto recipeDtoUpdate) {
        Recipe recipe = getRecipe(id);
        if (recipeDtoUpdate.getName() != null) recipe.setName(recipeDtoUpdate.getName());
        if (recipeDtoUpdate.getImagePath() != null) recipe.setImagePath(recipeDtoUpdate.getImagePath());
        if (recipeDtoUpdate.getDescription() != null) recipe.setDescription(recipeDtoUpdate.getDescription());
        if (recipeDtoUpdate.getCookingTime() != null) recipe.setCookingTime(recipeDtoUpdate.getCookingTime());
        if (recipeDtoUpdate.getPortionsDish() != null) recipe.setPortionsDish(recipeDtoUpdate.getPortionsDish());
        recipeRepository.save(recipe);
        return RecipeMapper.toRecipeDto(recipe);
    }

    @Override
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public List<RecipeDto> getAllRecipe() {
        List<RecipeDto> recipeDto = new ArrayList<>();
        for (var recipe : recipeRepository.findAll()) {
            recipeDto.add(RecipeMapper.toRecipeDto(recipe));
        }
        return recipeDto;
    }

    @Override
    public Recipe getRecipe(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id));
    }
}
