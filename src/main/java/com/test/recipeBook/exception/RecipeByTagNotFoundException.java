package com.test.recipeBook.exception;

public class RecipeByTagNotFoundException extends RuntimeException {
    public RecipeByTagNotFoundException(String tag) {
        super(String.format("Recipe с tag = %d не найдена!", tag));
    }
}
