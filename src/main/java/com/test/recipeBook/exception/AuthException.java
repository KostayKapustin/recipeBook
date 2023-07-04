package com.test.recipeBook.exception;

public class AuthException extends RuntimeException{
    public AuthException(String msg) {
        super(String.format(msg));
    }
}
