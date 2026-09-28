package com.example.universitytask.errors.exceptions;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

@Slf4j
@Getter
public class ValidationException extends RuntimeException {
    private  final Collection<String> errors;
    public ValidationException(String message, String LogMessage, Collection<String>errors) {
        super(message);
        this.errors= errors;
        log.error(LogMessage);
    }
}
