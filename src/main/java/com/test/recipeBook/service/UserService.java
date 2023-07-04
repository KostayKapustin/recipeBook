package com.test.recipeBook.service;

import com.test.recipeBook.dto.UserDto;
import com.test.recipeBook.dto.UserRegistrationDto;
import com.test.recipeBook.model.Recipe;
import com.test.recipeBook.model.User;
import lombok.NonNull;

import javax.security.auth.message.AuthException;
import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getByLogin(@NonNull String login);

    UserDto addUser(UserRegistrationDto userRegistrationDto) throws AuthException;

    UserDto getUserById(Long id);

    List<UserDto> getAllUserById();

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);

    User getUser(Long id);

    void addMyRecipe(Long id, Recipe recipe);
}
