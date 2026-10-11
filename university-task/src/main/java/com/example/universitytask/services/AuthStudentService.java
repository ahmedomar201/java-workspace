package com.example.universitytask.services;

import com.example.universitytask.errors.exceptions.*;
import com.example.universitytask.models.dtos.requests.StudentLogin;
import com.example.universitytask.models.dtos.requests.StudentRegister;
import com.example.universitytask.models.dtos.responses.GenericResponse;
import jakarta.validation.constraints.Email;

import java.util.List;

public interface AuthStudentService {

    void signup(StudentRegister studentRegister) throws RegisterException, ValidationException;

    void login(StudentLogin studentLogin) throws LoginException, CredentialsException;

    void logout(@Email(message = "{validation.email.pattern}")String email) throws LogoutException;

    GenericResponse<?> saveAll(List<StudentRegister> students) throws RegisterException, ValidationException;
}
