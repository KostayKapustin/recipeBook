package com.test.recipeBook.exception;

public class RecipeByNameNotFoundException extends RuntimeException{
    public RecipeByNameNotFoundException(String name) {
        super(String.format("Recipe с name = %d не найдена!", name));
    }
}
