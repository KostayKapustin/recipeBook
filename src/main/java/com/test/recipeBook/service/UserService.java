package com.test.recipeBook.service;

import com.test.recipeBook.dto.RecipeDto;
import com.test.recipeBook.dto.UserDto;
import com.test.recipeBook.dto.UserRegistrationDto;
import com.test.recipeBook.model.User;
import com.test.recipeBook.model.authentication.JwtRequest;
import lombok.NonNull;

import javax.security.auth.message.AuthException;
import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getByLogin(@NonNull String login);

    UserDto addUser(UserRegistrationDto userRegistrationDto) throws AuthException;

    boolean verificationPassword(JwtRequest jwtRequest);

    UserDto getUserById(Long id);

    List<UserDto> getAllUserById();

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);

    User getUser(Long id);

    RecipeDto addMyRecipe(Long id, RecipeDto recipeDto);

    List<User> likeRecipe(Long userId, Long recipeId);

    List<User> addTatteredRecipe(Long userId, Long recipeId);

    List<User> deleteLike(Long userId, Long recipeId);

    List<User> deleteFavorites(Long userId, Long recipeId);

    List<RecipeDto> getListRecipeLikeUser(Long userId);

    List<RecipeDto> getFavoritesRecipeLikeUser(Long userId);
}
