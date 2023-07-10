package com.test.recipeBook.mapper;

import com.test.recipeBook.dto.UserDto;
import com.test.recipeBook.dto.UserRegistrationDto;
import com.test.recipeBook.model.User;

public class UserMapper {

    public static User toUser(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setName(userRegistrationDto.getName());
        user.setLogin(userRegistrationDto.getLogin());
        user.setPassword(userRegistrationDto.getPassword());
        return user;
    }

    public static User toUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setDescription(userDto.getDescription());
        return user;
    }

    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        userDto.setDescription(user.getDescription());
        for(var recipe : user.getMyRecipes()){
            userDto.getMyRecipes().add(RecipeMapper.toRecipeDto(recipe));
        }
        return userDto;
    }

    public static UserRegistrationDto toUserRegistrationDto(User user) {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        userRegistrationDto.setName(user.getName());
        userRegistrationDto.setLogin(user.getLogin());
        userRegistrationDto.setPassword(user.getPassword());
        return userRegistrationDto;
    }
}
