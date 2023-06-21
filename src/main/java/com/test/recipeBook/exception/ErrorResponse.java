package com.test.recipeBook.exception;

import com.test.recipeBook.mapper.DateTimeMapper;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Data
public class ErrorResponse {
    private final List<String> errors;
    private final String message;
    private final String reason;
    private final String status;
    private final String timestamp;

    public ErrorResponse(String error, String message, String reason, String status) {
        errors = Collections.singletonList(error);
        this.message = message;
        this.reason = reason;
        this.status = status;
        timestamp = DateTimeMapper.toString(LocalDateTime.now());
    }
}
