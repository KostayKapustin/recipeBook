package com.test.recipeBook.exception;

public class RecipeNotFoundException extends RuntimeException {

    public RecipeNotFoundException(Long id) {
        super(String.format("Recipe с id = %d не найдена!", id));
    }
}
