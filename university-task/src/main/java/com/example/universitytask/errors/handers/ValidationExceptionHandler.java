package com.example.universitytask.errors.handers;

import com.example.universitytask.errors.models.ErrorResponse;
import com.example.universitytask.errors.models.GenericResponse;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedList;
import java.util.List;

import static com.example.universitytask.utills.times.TimeHelper.currentTimestamp;


@RestControllerAdvice
public class ValidationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(exception = MethodArgumentNotValidException.class)
    public GenericResponse<List<ErrorResponse>> handleMethodArgumentNotValidException(
            final MethodArgumentNotValidException e) {

        final List<ErrorResponse> errorResponsesList = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(this::from).toList();

//        final List<ErrorResponse> errorResponsesList = new LinkedList<>();
//        for (final FieldError fieldError : e.getBindingResult().getFieldErrors()) {
//            final String message = fieldError.getField();
//            final String defaultMessage = fieldError.getDefaultMessage();
//            errorResponsesList.add(new ErrorResponse(message, defaultMessage));

        return new GenericResponse<>(9000, currentTimestamp(), errorResponsesList);

    }

    private ErrorResponse from(final FieldError fieldError) {
        return new ErrorResponse(fieldError.getField(), fieldError.getDefaultMessage());
    }
}

