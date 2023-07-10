package com.test.recipeBook.controller;

import com.test.recipeBook.controller.builder.RequestBuilder;
import com.test.recipeBook.dto.RecipeDto;
import com.test.recipeBook.dto.UserDto;
import com.test.recipeBook.dto.UserRegistrationDto;
import com.test.recipeBook.model.User;
import com.test.recipeBook.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Api(value = "Контроллер пользователя",
        description = "Выполняются все операции связанные с пользователем")
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "Добавления пользователя")
    @PostMapping
    public UserDto addUser(@ApiParam(value = "Параметр пользователя для регистрации")
                           @Valid @RequestBody UserRegistrationDto userRegistrationDto,
                           HttpServletRequest request) throws AuthException {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return userService.addUser(userRegistrationDto);
    }

    @ApiOperation(value = "Получение пользовтаеля по ID")
    @GetMapping("/{id}")
    public UserDto getUser(@ApiParam(value = "ID пользователя") @PathVariable Long id,
                           HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return userService.getUserById(id);
    }

    @ApiOperation(value = "Получение всех пользователей")
    @GetMapping
    public List<UserDto> getAllUser(HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return userService.getAllUserById();
    }

    @ApiOperation(value = "Обновления параметров пользовтаеля по ID")
    @PatchMapping("/{id}")
    public UserDto updateUser(@ApiParam(value = "ID пользователя") @PathVariable Long id,
                              @ApiParam(value = "Параметры пользователя") @Valid @RequestBody UserDto userDto,
                              HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return userService.updateUser(id, userDto);
    }

    @ApiOperation(value = "Удаление пользовтаеля по ID")
    @DeleteMapping("/{id}")
    public void deleteUser(@ApiParam(value = "ID пользователя") @PathVariable Long id,
                           HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        userService.deleteUser(id);
    }

    @ApiOperation(value = "Добавление своего рецепта пользователем")
    @PostMapping("/{id}")
    public RecipeDto addRecipe(@ApiParam(value = "ID пользователя") @PathVariable Long id,
                               @ApiParam(value = "Параметры рецепта") @Valid @RequestBody RecipeDto recipeDto,
                               HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return userService.addMyRecipe(id, recipeDto);
    }

    @ApiOperation(value = "Добавление рецепта пользователем в Like")
    @PostMapping("/{id}/recipe/{recipeId}/like")
    public List<User> likeRecipe(@ApiParam(value = "ID пользователя") @PathVariable Long id,
                                 @ApiParam(value = "ID рецепта") @PathVariable Long recipeId,
                                 HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return userService.likeRecipe(id, recipeId);
    }

    @ApiOperation(value = "Добавление рецепта пользователем в Favorites")
    @PostMapping("/{id}/recipe/{recipeId}/favorites")
    public List<User> addTatteredRecipe(@ApiParam(value = "ID пользователя") @PathVariable Long id,
                                        @ApiParam(value = "ID рецепта") @PathVariable Long recipeId,
                                        HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return userService.addTatteredRecipe(id, recipeId);
    }

    @ApiOperation(value = "Удаление рецепта пользователем из Favorites")
    @DeleteMapping("/{id}/recipe/{recipeId}/delete/favorites")
    public List<User> deleteFavorites(@ApiParam(value = "ID пользователя") @PathVariable Long id,
                                      @ApiParam(value = "ID рецепта") @PathVariable Long recipeId,
                                      HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return userService.deleteFavorites(id, recipeId);
    }

    @ApiOperation(value = "Удаление рецепта пользователем из Like")
    @DeleteMapping("/{id}/recipe/{recipeId}/delete/like")
    public List<User> deleteLike(@ApiParam(value = "ID пользователя") @PathVariable Long id,
                                 @ApiParam(value = "ID рецепта") @PathVariable Long recipeId,
                                 HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return userService.deleteLike(id, recipeId);
    }

    @ApiOperation(value = "Получение рецептов пользователем из Like")
    @GetMapping("/{id}/like")
    public List<RecipeDto> getListRecipeLikeUser(@ApiParam(value = "ID пользователя") @PathVariable Long id,
                                                 HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return userService.getListRecipeLikeUser(id);
    }

    @ApiOperation(value = "Получение рецептов пользователем из Favorites")
    @GetMapping("/{id}/favorites")
    public List<RecipeDto> getFavoritesRecipeLikeUser(@ApiParam(value = "ID пользователя") @PathVariable Long id,
                                                      HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return userService.getFavoritesRecipeLikeUser(id);
    }
}
