package com.test.recipeBook.exception;

public class TagNotFoundException extends RuntimeException {
    public TagNotFoundException(Long id) {
        super(String.format("Tag с id = %d не найдена!", id));
    }
}
