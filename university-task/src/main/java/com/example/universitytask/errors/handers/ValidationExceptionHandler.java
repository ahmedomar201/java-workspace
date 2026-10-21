package com.example.universitytask.errors.handers;

import com.example.universitytask.errors.models.ErrorResponse;
import com.example.universitytask.errors.models.GenericResponse;

import com.example.universitytask.utills.validators.ValidationRules;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ElementKind;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static com.example.universitytask.utills.times.TimeHelper.currentTimestamp;


@RestControllerAdvice
public class ValidationExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(exception = ValidationRules.RuleException.class)
    public GenericResponse<ErrorResponse> handleRuleException(final ValidationRules.RuleException e) {

        final ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), e.getDescription());

        return new GenericResponse<>(
                ValidationRules.ValidationException.CODE, currentTimestamp(), errorResponse);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(exception = ValidationRules.ValidationException.class)
    public GenericResponse<List<ErrorResponse>> handleValidationException(
            final ValidationRules.ValidationException e) {

        final List<ErrorResponse> errorResponseList = e.getErrors()
                .entrySet()
                .stream()
                .map(ValidationExceptionHandler::toErrorResponse)
                .toList();

        return new GenericResponse<>(
                ValidationRules.ValidationException.CODE, currentTimestamp(), errorResponseList);
    }

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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(exception = ConstraintViolationException.class)
    public GenericResponse<List<ErrorResponse>> handleConstraintViolationException(final ConstraintViolationException e) {
        final List<ErrorResponse> errorResponseList = e.getConstraintViolations().stream()
                .toList()
                .stream()
                .map(this::from)
                .toList();
        return new GenericResponse<>(9100, currentTimestamp(), errorResponseList);
    }

    private ErrorResponse from(final ConstraintViolation<?> constraintViolation) {
        final AtomicReference<String> fieldName = new AtomicReference<>();
        constraintViolation.getPropertyPath()
                .forEach(node -> {
                    if (isNodeKindParameter(node.getKind())) {
                        fieldName.set(node.getName());
                    }
                });
        return new ErrorResponse(fieldName.get(), constraintViolation.getMessage());
    }

    private boolean isNodeKindParameter(final ElementKind elementKind) {
        return ElementKind.PARAMETER.equals(elementKind);
    }

    private ErrorResponse from(final FieldError fieldError) {
        return new ErrorResponse(fieldError.getField(), fieldError.getDefaultMessage());
    }

    private static ErrorResponse toErrorResponse(final Map.Entry<String, String> entry) {
        return new ErrorResponse(entry.getKey(), entry.getValue());
    }
}

