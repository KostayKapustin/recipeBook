package com.test.recipeBook.controller;

import com.test.recipeBook.dto.UserDto;
import com.test.recipeBook.dto.UserRegistrationDto;
import com.test.recipeBook.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDto addUser(@Valid @RequestBody UserRegistrationDto userRegistrationDto,
                                 HttpServletRequest request) throws AuthException {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return userService.addUser(userRegistrationDto);
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id,
                           HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserDto> getAllUser(HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return userService.getAllUserById();
    }

    @PatchMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id,
                           @Valid @RequestBody UserDto userDto,
                               HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id,
            HttpServletRequest request) {
        log.info("Получить новый запрос: {}", RequestBuilder.getStringFromRequest(request));
        userService.deleteUser(id);
    }
}
