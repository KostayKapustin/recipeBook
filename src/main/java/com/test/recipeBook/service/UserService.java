package com.test.recipeBook.service;

import com.test.recipeBook.model.User;

import java.util.List;

public interface UserService {
    User findByUsername(String name);

    List<User> getAll();

    User getByLogin(String login);
}
