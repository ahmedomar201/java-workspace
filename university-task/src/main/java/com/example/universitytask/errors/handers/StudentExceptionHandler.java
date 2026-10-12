package com.example.universitytask.errors.handers;

import com.example.universitytask.errors.exceptions.StudentException;
import com.example.universitytask.errors.models.ErrorResponse;
import com.example.universitytask.errors.models.GenericResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@RestControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(exception = StudentException.class)
    public GenericResponse<ErrorResponse> handleStudentException(final StudentException e) {
        return new GenericResponse<>(
                StudentException.CODE,
                e.getCurrentTimestamp(),
                new ErrorResponse(StudentException.MESSAGE, e.getDescription())
        );
    }

}