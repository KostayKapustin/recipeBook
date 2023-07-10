package com.test.recipeBook.service.impl;

import com.test.recipeBook.dto.RecipeDto;
import com.test.recipeBook.dto.UserDto;
import com.test.recipeBook.dto.UserRegistrationDto;
import com.test.recipeBook.exception.AuthException;
import com.test.recipeBook.exception.RepetitionsException;
import com.test.recipeBook.exception.UserNotFoundException;
import com.test.recipeBook.mapper.RecipeMapper;
import com.test.recipeBook.mapper.UserMapper;
import com.test.recipeBook.model.Recipe;
import com.test.recipeBook.model.User;
import com.test.recipeBook.model.authentication.JwtRequest;
import com.test.recipeBook.repository.UserRepository;
import com.test.recipeBook.service.RecipeService;
import com.test.recipeBook.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RecipeService recipeService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Optional<User> getByLogin(@NonNull String login) {
        return Optional.ofNullable(userRepository.getByLogin(login)
                .orElseThrow(() -> new UserNotFoundException(login)));
    }

    @Override
    public UserDto addUser(UserRegistrationDto userRegistrationDto) throws AuthException {
        if (userRegistrationDto.getPassword().equals(userRegistrationDto.getRepeatedPassword())) {
            userRegistrationDto.setPassword(bCryptPasswordEncoder.encode(userRegistrationDto.getPassword()));
            return UserMapper.toUserDto(userRepository.save(UserMapper.toUser(userRegistrationDto)));
        } else {
            throw new AuthException("Пароль не совпадает");
        }
    }

    @Override
    public boolean verificationPassword(JwtRequest jwtRequest) {
       User user =  getByLogin(jwtRequest.getLogin()).get();
       if (bCryptPasswordEncoder.matches(jwtRequest.getPassword(), user.getPassword()))
           return true;
    return false;
    }

    @Override
    public UserDto getUserById(Long id) {
        return UserMapper.toUserDto(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id.toString())));
    }

    @Override
    public List<UserDto> getAllUserById() {
        List<UserDto> usersDto = new ArrayList<>();
        for (var user : userRepository.findAll()) {
            usersDto.add(UserMapper.toUserDto(user));
        }
        return usersDto;
    }

    @Override
    public UserDto updateUser(Long id, UserDto userUpdate) {
        User user = getUser(id);
        if (userUpdate.getName() != null) user.setName(userUpdate.getName());
        if (userUpdate.getLogin() != null) user.setLogin(userUpdate.getLogin());
        if (userUpdate.getPassword() != null) user.setPassword(userUpdate.getPassword());
        if (userUpdate.getDescription() != null) user.setDescription(userUpdate.getDescription());
        userRepository.save(user);
        return UserMapper.toUserDto(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id.toString()));
    }

    @Override
    public RecipeDto addMyRecipe(Long id, RecipeDto recipeDto) {
        User user = getUser(id);
        Recipe recipe = recipeService.addRecipe(recipeDto);
        user.getMyRecipes().add(recipe);
        userRepository.save(user);
        return RecipeMapper.toRecipeDto(recipe);
    }

    @Override
    public List<User> likeRecipe(Long userId, Long recipeId) {
        User user = getUser(userId);
        Recipe recipe = recipeService.getRecipe(recipeId);
        if (!recipe.getLikes().contains(user)) {
            recipe.getLikes().add(user);
            recipeService.saveRecipe(recipe);
        } else {
            throw new RepetitionsException("like");
        }
        return recipe.getLikes();
    }

    @Override
    public List<User> addTatteredRecipe(Long userId, Long recipeId) {
        User user = getUser(userId);
        Recipe recipe = recipeService.getRecipe(recipeId);
        if (!recipe.getFavorites().contains(user)) {
            recipe.getFavorites().add(user);
            recipeService.saveRecipe(recipe);
        } else {
            throw new RepetitionsException("favorites");
        }
        return recipe.getFavorites();
    }

    @Override
    public List<User> deleteLike(Long userId, Long recipeId) {
        User user = getUser(userId);
        Recipe recipe = recipeService.getRecipe(recipeId);
        recipe.getLikes().remove(user);
        recipeService.saveRecipe(recipe);
        return recipe.getLikes();
    }

    @Override
    public List<User> deleteFavorites(Long userId, Long recipeId) {
        User user = getUser(userId);
        Recipe recipe = recipeService.getRecipe(recipeId);
        recipe.getFavorites().remove(user);
        recipeService.saveRecipe(recipe);
        return recipe.getFavorites();
    }

    @Override
    public List<RecipeDto> getListRecipeLikeUser(Long userId){
        List<RecipeDto> recipeDtos = recipeService.getListRecipeLikeUser(userId);
        return recipeDtos;
    }

    @Override
    public List<RecipeDto> getFavoritesRecipeLikeUser(Long userId){
        List<RecipeDto> recipeDtos = recipeService.getFavoritesRecipeLikeUser(userId);
        return recipeDtos;
    }
}
