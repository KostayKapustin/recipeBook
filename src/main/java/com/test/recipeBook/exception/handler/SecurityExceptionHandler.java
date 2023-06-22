package com.test.recipeBook.exception.handler;

import com.test.recipeBook.exception.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
@Slf4j
public class SecurityExceptionHandler {


    @ExceptionHandler({AuthenticationException.class, SessionAuthenticationException.class, BadCredentialsException.class,
            AuthException.class})
    public ErrorResponse handleAuthenticationException(RuntimeException e, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        log.info(HttpStatus.FORBIDDEN + ": " + e.getMessage());
        return new ErrorResponse(e.getClass().toString(), e.getMessage(), "Ошибка авторизации",
                HttpStatus.FORBIDDEN.toString());
    }
}
