package com.test.recipeBook.exception;

public class RepetitionsException extends RuntimeException{
    public RepetitionsException(String str) {
        super(String.format("Вы уже добавили рецепт в : %d !", str));
    }
}
