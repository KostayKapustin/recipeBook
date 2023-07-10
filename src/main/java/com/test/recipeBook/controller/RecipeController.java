package com.test.recipeBook.controller;

import com.test.recipeBook.controller.builder.RequestBuilder;
import com.test.recipeBook.dto.IngredientDto;
import com.test.recipeBook.dto.RecipeDto;
import com.test.recipeBook.dto.StepDto;
import com.test.recipeBook.dto.TagDto;
import com.test.recipeBook.service.IngredientService;
import com.test.recipeBook.service.RecipeService;
import com.test.recipeBook.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(value = "Контроллер рецептов",
        description = "Выполняются все операции связанные с рецептами")
public class RecipeController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final TagService tagService;

    @ApiOperation(value = "Добавления ингредиентов в рецепт")
    @PostMapping("/{id}/ingredient")
    public RecipeDto addIngredient(@ApiParam(value = "ID рецепта") @PathVariable Long id,
                                   @ApiParam(value = "Параметр ингредиента")
                                   @Valid @RequestBody IngredientDto ingredientDto,
                                   HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return recipeService.addIngredient(id, ingredientDto);
    }

    @ApiOperation(value = "Добавления шага в рецепт")
    @PostMapping("/{id}/step")
    public RecipeDto addDescriptionStep(@ApiParam(value = "ID рецепта") @PathVariable Long id,
                                        @ApiParam(value = "Параметр шага") @Valid @RequestBody StepDto step,
                                        HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return recipeService.addStep(id, step.getStep());
    }

    @ApiOperation(value = "Добавления тега")
    @PostMapping("/tag")
    public TagDto addTag(@ApiParam(value = "Параметр тега") @Valid @RequestBody TagDto tagDto,
                         HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return tagService.addTag(tagDto);
    }

    @ApiOperation(value = "Получение рецепт по ID")
    @GetMapping("/{id}")
    public RecipeDto getRecipeById(@ApiParam(value = "ID рецепта") @PathVariable Long id,
                                   HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return recipeService.getRecipeById(id);
    }

    @ApiOperation(value = "Получение всех рецептов")
    @GetMapping
    public List<RecipeDto> getAllRecipe(HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return recipeService.getAllRecipe();
    }

    @ApiOperation(value = "Получение рецепта по имени")
    @GetMapping("/name/{name}")
    public RecipeDto getRecipeByName(@ApiParam(value = "Параметр имя рецепта") @PathVariable String name,
                                     HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return recipeService.getRecipeByName(name);
    }

    @ApiOperation(value = "Получение тега по имени")
    @GetMapping("/tag/{tagName}")
    public List<RecipeDto> getListRecipeByTag(@ApiParam(value = "Параметр инени тега") @PathVariable String tagName,
                                              HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return recipeService.getListRecipeByTag(tagName);
    }

    @ApiOperation(value = "Обновление рецепта")
    @PatchMapping("/{id}")
    public RecipeDto updateRecipe(@ApiParam(value = "ID рецепта") @PathVariable Long id,
                                  @ApiParam(value = "Параметр рецепта") @RequestBody RecipeDto recipeDto,
                                  HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return recipeService.updateRecipe(id, recipeDto);
    }

    @ApiOperation(value = "Обновление тега")
    @PatchMapping("/tag/{id}")
    public TagDto updateTag(@ApiParam(value = "ID тега") @PathVariable Long id,
                            @ApiParam(value = "Параметр тега") @RequestBody TagDto tagDto,
                            HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return tagService.updateTag(id, tagDto);
    }

    @ApiOperation(value = "Обновление ингредиента по ID рецепта")

    @PatchMapping("/ingredient/{id}")
    public IngredientDto updateIngredient(@ApiParam(value = "ID ингредиента") @PathVariable Long id,
                                          @ApiParam(value = "Параметр ингредиента") @RequestBody IngredientDto ingredientDto,
                                          HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return ingredientService.updateIngredient(id, ingredientDto);
    }

    @ApiOperation(value = "Удаление рецепта")
    @DeleteMapping("/{id}")
    public void deleteRecipe(@ApiParam(value = "ID рецепта") @PathVariable Long id,
                             HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        recipeService.deleteRecipe(id);
    }

    @ApiOperation(value = "Удаление тега в рецепте")
    @DeleteMapping("/tag/{id}")
    public void deleteTag(@ApiParam(value = "ID тега") @PathVariable Long id,
                          HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        tagService.deleteTag(id);
    }

    @ApiOperation(value = "Удаление ингрединета в рецепте")
    @DeleteMapping("/ingredient/{id}")
    public void deleteIngredient(@ApiParam(value = "ID ингредиента") @PathVariable Long id,
                                 HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        ingredientService.deleteIngredient(id);
    }
}
