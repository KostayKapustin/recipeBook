package com.test.recipeBook.exception.handler;

import com.test.recipeBook.exception.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
@Slf4j
public class SecurityExceptionHandler {


    @ExceptionHandler({AuthenticationException.class, SessionAuthenticationException.class})
    public ErrorResponse handleAuthenticationException(RuntimeException e, HttpServletRequest request, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return new ErrorResponse(e.getClass().toString(), e.getMessage(), "Элемент не найден",
                HttpStatus.NOT_FOUND.toString());
    }

    @ExceptionHandler({BadCredentialsException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handleConstraintViolationException(BadCredentialsException e) {
        return new ErrorResponse(e.getClass().toString(), e.getMessage(), "Исключение ограничения",
                HttpStatus.FORBIDDEN.toString());
    }
}
