package com.example.universitytask.errors.exceptions;

import lombok.Getter;

import java.util.Collection;
import java.util.List;

@Getter
public class RegisterException extends RuntimeException {

    private final Collection<String>errors;
    public RegisterException(String message,String...errors) {
        super(message);
        this.errors= List.of(errors);
    }
}
