package com.example.universitytask.errors.handers;

import com.example.universitytask.errors.exceptions.*;
import com.example.universitytask.errors.models.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@RestControllerAdvice
public class AuthStudentHandler {


    @ExceptionHandler(exception = RegisterException.class)
    public ErrorResponse<?> handleRegisterException(final RegisterException e) {
        return new ErrorResponse<>(
                RegisterException.CODE,
                RegisterException.MESSAGE,
                e.getDescription(),
                e.getCurrentTimestamp(),
                Optional.empty()
        );
    }

    @ExceptionHandler(exception = LogoutException.class)
    public ErrorResponse<?> handleLogoutException(final LogoutException e) {
        return new ErrorResponse<>(
                LogoutException.CODE,
                LogoutException.MESSAGE,
                e.getDescription(),
                e.getCurrentTimestamp(),
                Optional.empty()
        );
    }

    @ExceptionHandler(exception = LoginException.class)
    public ErrorResponse<?> handleLoginException(final LoginException e) {
        return new ErrorResponse<>(
                LoginException.CODE,
                LoginException.MESSAGE,
                e.getDescription(),
                e.getCurrentTimestamp(),
                Optional.empty()
        );
    }

    @ExceptionHandler(exception = CredentialsException.class)
    public ErrorResponse<?> handleCredentialsException(final CredentialsException e) {
        return new ErrorResponse<>(
                CredentialsException.CODE,
                CredentialsException.MESSAGE,
                e.getDescription(),
                e.getCurrentTimestamp(),
                Optional.empty()
        );
    }
}
