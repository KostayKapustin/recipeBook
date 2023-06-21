package com.test.recipeBook.service;

import com.test.recipeBook.model.User;
import lombok.NonNull;

import java.util.Optional;

public interface UserService {
    Optional<User> getByLogin(@NonNull String login);
}
