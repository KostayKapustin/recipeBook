package com.test.recipeBook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.recipeBook.security.TokenAuthenticationService;
import com.test.recipeBook.service.RedisService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RecipeBookApplication {

    private final RedisService redisService;

    @Value("${ENC_KEY}")
    private String encKey;

    public RecipeBookApplication(RedisService redisService) {
        this.redisService = redisService;
    }

    @Bean
    public TokenAuthenticationService tokenAuthService() {
        return new TokenAuthenticationService(redisService,encKey);
    }

    @Bean
    public ObjectMapper mapper(){
        return new ObjectMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(RecipeBookApplication.class, args);
    }
}
