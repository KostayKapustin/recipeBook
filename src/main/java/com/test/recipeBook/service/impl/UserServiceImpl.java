package com.test.recipeBook.service.impl;

import com.test.recipeBook.model.User;
import com.test.recipeBook.service.UserService;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final List<User> users;

    public UserServiceImpl() {
        this.users = List.of(
                new User(1l,"12345", "123451", "12345", "dsdsd", null),
                new User(2l,"12345", "123452", "12345", "Петров", null)
        );
    }

    @Override
    public Optional<User> getByLogin(@NonNull String login) {
        return users.stream()
                .filter(user -> login.equals(user.getLogin()))
                .findFirst();
    }

}
