package com.example.universitytask.errors.handers;

import com.example.universitytask.errors.exceptions.StudentException;
import com.example.universitytask.errors.models.ErrorResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@RestControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(exception = StudentException.class)
    public ErrorResponse<?> handleStudentException(final StudentException e) {
        return new ErrorResponse<>(
                StudentException.CODE,
                StudentException.MESSAGE,
                e.getDescription(),
                e.getCurrentTimestamp(),
                Optional.empty()
        );
    }

}