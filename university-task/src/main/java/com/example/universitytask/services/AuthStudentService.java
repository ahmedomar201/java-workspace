package com.example.universitytask.services;

import com.example.universitytask.errors.exceptions.*;
import com.example.universitytask.models.dtos.requests.StudentLogin;
import com.example.universitytask.models.dtos.requests.StudentRegister;

import java.util.List;

public interface AuthStudentService {

    void signup(final StudentRegister studentRegister) throws RegisterException, ValidationException;

    void login(final StudentLogin studentLogin) throws LoginException, CredentialsExceptions;

    void logout(final String email) throws LogoutException;

    Object saveAll(final List<StudentRegister> students) throws RegisterException, ValidationException;
}
