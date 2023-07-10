package com.test.recipeBook.controller;

import com.test.recipeBook.exception.AuthException;
import com.test.recipeBook.model.authentication.JwtRequest;
import com.test.recipeBook.model.authentication.JwtResponse;
import com.test.recipeBook.model.authentication.RefreshJwtRequest;
import com.test.recipeBook.repository.AuthRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
@Api(value = "Контроллер для получения токена",
        description = "Вход получаем токен и рефреш-токен, обновления токена и рефреш-токена")
public class AuthController {

    private final AuthRepository authService;

    @ApiOperation(value = "Вход пользователя")
    @PostMapping("login")
    public ResponseEntity<JwtResponse> login(@ApiParam(value = "Пароль и логин") @RequestBody JwtRequest authRequest)
            throws AuthException {
        final JwtResponse token = authService.login(authRequest);
        return ResponseEntity.ok(token);
    }

    @ApiOperation(value = "Обновления токена")
    @PostMapping("token")
    public ResponseEntity<JwtResponse> getNewAccessToken(
            @ApiParam(value = "Рефреш-токен") @RequestBody RefreshJwtRequest request)
            throws AuthException {
        final JwtResponse token = authService.getAccessToken(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @ApiOperation(value = "Обновления руфреш-токена")
    @PostMapping("refresh")
    public ResponseEntity<JwtResponse> getNewRefreshToken(
            @ApiParam(value = "Рефреш-токен") @RequestBody RefreshJwtRequest request)
            throws AuthException {
        final JwtResponse token = authService.refresh(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

}