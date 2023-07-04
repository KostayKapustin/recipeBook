package com.test.recipeBook.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String login) {
        super(String.format("User с login(id) = %d не найдена!", login));
    }
}
