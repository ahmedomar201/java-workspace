package com.example.universitytask.errors.exceptions;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.List;

@Slf4j
@Getter
public class RegisterException extends RuntimeException {

    private final Collection<String>errors;
    public RegisterException(String message,String LogMessage,String...errors) {
        super(message);
        this.errors= List.of(errors);
        log.error(LogMessage);
    }
}
