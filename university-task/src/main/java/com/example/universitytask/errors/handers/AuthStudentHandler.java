package com.example.universitytask.errors.handers;

import com.example.universitytask.errors.exceptions.LoginException;
import com.example.universitytask.errors.exceptions.LogoutException;
import com.example.universitytask.errors.exceptions.RegisterException;
import com.example.universitytask.errors.exceptions.StudentException;
import com.example.universitytask.errors.exceptions.CredentialsException;

import com.example.universitytask.errors.models.ErrorResponse;
import com.example.universitytask.errors.models.GenericResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthStudentHandler {


    @ExceptionHandler(exception = RegisterException.class)
    public GenericResponse<?> handleRegisterException(final RegisterException e) {
        return new GenericResponse<>(
                StudentException.CODE,
                e.getCurrentTimestamp(),
                new ErrorResponse(StudentException.MESSAGE, e.getDescription())
        );
    }

    @ExceptionHandler(exception = LogoutException.class)
    public GenericResponse<?> handleLogoutException(final LogoutException e) {
        return new GenericResponse<>(
                StudentException.CODE,
                e.getCurrentTimestamp(),
                new ErrorResponse(StudentException.MESSAGE, e.getDescription())
        );
    }

    @ExceptionHandler(exception = LoginException.class)
    public GenericResponse<?> handleLoginException(final LoginException e) {
        return new GenericResponse<>(
                StudentException.CODE,
                e.getCurrentTimestamp(),
                new ErrorResponse(StudentException.MESSAGE, e.getDescription())
        );
    }

    @ExceptionHandler(exception = CredentialsException.class)
    public GenericResponse<?> handleCredentialsException(final CredentialsException e) {
        return new GenericResponse<>(
                StudentException.CODE,
                e.getCurrentTimestamp(),
                new ErrorResponse(StudentException.MESSAGE, e.getDescription())
        );
    }
}
