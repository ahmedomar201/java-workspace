package com.example.service.errors.exceptions;

public class RegisterException extends RuntimeException {
    public RegisterException(String message) {
        super(message);
    }
}
