package com.test.recipeBook.service.impl;

import com.test.recipeBook.dto.IngredientDto;
import com.test.recipeBook.dto.RecipeDto;
import com.test.recipeBook.dto.TagDto;
import com.test.recipeBook.exception.RecipeByNameNotFoundException;
import com.test.recipeBook.exception.RecipeByTagNotFoundException;
import com.test.recipeBook.exception.RecipeNotFoundException;
import com.test.recipeBook.mapper.RecipeMapper;
import com.test.recipeBook.mapper.TagMapper;
import com.test.recipeBook.model.Recipe;
import com.test.recipeBook.model.Tag;
import com.test.recipeBook.repository.RecipeRepository;
import com.test.recipeBook.service.IngredientService;
import com.test.recipeBook.service.RecipeService;
import com.test.recipeBook.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final TagService tagService;
    private final IngredientService ingredientService;

    @Override
    public Recipe addRecipe(RecipeDto recipeDto) {
        List<Tag> tags = getTagsByRequest(recipeDto);
        recipeDto.getTags().clear();
        Recipe recipe = RecipeMapper.toRecipe(recipeDto);
        recipe.getTags().addAll(tags);
        saveRecipe(recipe);
        return recipe;
    }

    @Override
    public RecipeDto addStep(Long id, String step) {
        Recipe recipe = getRecipe(id);
        recipe.getDescriptionStep().add(step);
        saveRecipe(recipe);
        return getRecipeById(id);
    }

    @Override
    public RecipeDto addIngredient(Long id, IngredientDto ingredientDto) {
        return RecipeMapper.toRecipeDto(recipeRepository.save
                (ingredientService.addIngredient(getRecipe(id), ingredientDto)));
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
        for (var id : tagService.getRecipeIdByTagId(tagId)) {
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
        if (recipeDtoUpdate.getTags() != null) {
            recipe.getTags().addAll(getTagsByRequest(recipeDtoUpdate));
        }
        saveRecipe(recipe);
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

    @Override
    public void saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    private List<Tag> getTagsByRequest(RecipeDto recipeDto) {
        List<Tag> tags = new ArrayList<>();
        if (recipeDto.getTags().size() != 0) {
            for (var tagDto : recipeDto.getTags()) {
                if (tagService.getTagByName(tagDto.getName()) == null) {
                    tagService.addTag(tagDto);
                }
                tags.add(tagService.getTag(tagService.getTagByName(tagDto.getName())));
            }
        } else {
            throw new NullPointerException("Вы не указали Tags");
        }
        return tags;
    }

    @Override
    public List<RecipeDto> getListRecipeLikeUser(Long id) {
        List<Long> recipeIds = recipeRepository.getListRecipeLikeUser(id);
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        for (var recipeId : recipeIds) {
            recipeDtoList.add(getRecipeById(recipeId));
        }
        return recipeDtoList;
    }

    @Override
    public List<RecipeDto> getFavoritesRecipeLikeUser(Long id) {
        List<Long> recipeIds = recipeRepository.getFavoritesRecipeLikeUser(id);
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        for (var recipeId : recipeIds) {
            recipeDtoList.add(getRecipeById(recipeId));
        }
        return recipeDtoList;
    }
}
