package com.test.recipeBook.controller;

import com.test.recipeBook.dto.IngredientDto;
import com.test.recipeBook.dto.RecipeDto;
import com.test.recipeBook.dto.TagDto;
import com.test.recipeBook.service.IngredientService;
import com.test.recipeBook.service.RecipeService;
import com.test.recipeBook.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/recipe")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final TagService tagService;

    @PostMapping("/user/{id}")
    public RecipeDto addRecipe(@PathVariable Long id,
                               @Valid @RequestBody RecipeDto recipeDto,
                               HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return recipeService.addRecipe(id, recipeDto);
    }

    @PostMapping("/{id}/ingredient")
    public RecipeDto addIngredient(@PathVariable Long id,
                                   @Valid @RequestBody IngredientDto ingredientDto,
                                   HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return ingredientService.addIngredient(id, ingredientDto);
    }

    @PostMapping("/{id}/step")
    public RecipeDto addDescriptionStep(@PathVariable Long id,
                                        @Valid @RequestBody String step,
                                        HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return recipeService.addStep(id, step);
    }

    @PostMapping("/tag")
    public TagDto addTag(@Valid @RequestBody TagDto tagDto,
                         HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return tagService.addTag(tagDto);
    }

    @GetMapping("/{id}")
    public RecipeDto getRecipeById(@PathVariable Long id,
                                   HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return recipeService.getRecipeById(id);
    }

    @GetMapping
    public List<RecipeDto> getAllRecipe(HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return recipeService.getAllRecipe();
    }

    @GetMapping("/name/{name}")
    public RecipeDto getRecipeByName(@PathVariable String name,
                                     HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return recipeService.getRecipeByName(name);
    }

    @GetMapping("/tag/{tagName}")
    public List<RecipeDto> getListRecipeByTag(@PathVariable String tagName,
                                              HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return recipeService.getListRecipeByTag(tagName);
    }

    @PatchMapping("/{id}")
    public RecipeDto updateRecipe(@PathVariable Long id,
                                  @RequestBody RecipeDto recipeDto,
                                  HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return recipeService.updateRecipe(id, recipeDto);
    }

    @PatchMapping("/tag/{id}")
    public TagDto updateTag(@PathVariable Long id,
                            @RequestBody TagDto tagDto,
                            HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return tagService.updateTag(id, tagDto);
    }

    @PatchMapping("/ingredient/{id}")
    public IngredientDto updateIngredient(@PathVariable Long id,
                                          @RequestBody IngredientDto ingredientDto,
                                          HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return ingredientService.updateIngredient(id, ingredientDto);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id,
                             HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        recipeService.deleteRecipe(id);
    }

    @DeleteMapping("/tag/{id}")
    public void deleteTag(@PathVariable Long id,
                          HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        tagService.deleteTag(id);
    }

    @DeleteMapping("/ingredient/{id}")
    public void deleteIngredient(@PathVariable Long id,
                                 HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        ingredientService.deleteIngredient(id);
    }
}
