package com.test.recipeBook.exception;

public class IngredientNotFoundException extends RuntimeException {
    public IngredientNotFoundException(Long id) {
        super(String.format("Ingredient с id = %d не найдена!", id));
    }

}
