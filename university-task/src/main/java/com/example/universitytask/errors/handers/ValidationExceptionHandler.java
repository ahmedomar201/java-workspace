package com.example.universitytask.errors.handers;

import com.example.universitytask.errors.exceptions.ValidationException;
import com.example.universitytask.errors.models.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collection;
import java.util.Optional;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(exception = ValidationException.class)
    public ErrorResponse<Collection<String>> handleValidationException(final ValidationException e) {
        return new ErrorResponse<>(
                ValidationException.CODE,
                ValidationException.MESSAGE,
                e.getDescription(),
                e.getCurrentTimestamp(),
                Optional.of(e.getErrors())
        );
    }
}
