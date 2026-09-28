package com.example.universitytask.controllers;

import com.example.universitytask.errors.exceptions.*;
import com.example.universitytask.models.dtos.requests.StudentLogin;
import com.example.universitytask.models.dtos.requests.StudentRegister;
import com.example.universitytask.models.dtos.responses.GenericResponse;
import com.example.universitytask.services.AuthStudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthStudentService authStudentService;

    @PostMapping("register")
    public ResponseEntity<Collection<String>> registerStudentApi(
            @RequestBody final StudentRegister studentRegister) {

        final String methodName = "Register Student Api";
        log.info("[{}]Implementing Registration flow[{}", methodName, studentRegister.email());

        try {
            authStudentService.signup(studentRegister);
        } catch (final RegisterException e) {
            return ResponseEntity.badRequest().body(List.of(e.getMessage()));
        } catch (final ValidationException e) {
            return ResponseEntity.badRequest().body(e.getErrors());
        }

        log.info("{}, Successfully registered student with email [{}]", methodName, studentRegister.email());

        return ResponseEntity.ok(List.of(
                "Successfully registered student with Email: " + studentRegister.email()));

    }

    @PostMapping("login")
    public ResponseEntity<String> loginStudentApi(
            @RequestBody final StudentLogin studentLogin) {
        try {
            authStudentService.login(studentLogin);
        } catch (final LoginException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (final CredentialsExceptions e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("password does not match");
        }

        return ResponseEntity.ok("student with email: " + studentLogin.email() + "logged in successfully");
    }

    @PostMapping("logout")
    public ResponseEntity<GenericResponse<String>> logoutApi(@RequestParam final String email) {

        try {
            authStudentService.logout(email);
        } catch (final LogoutException e) {
            return ResponseEntity.badRequest().body(new GenericResponse<>(e.getMessage(), null));
        }

        return ResponseEntity.ok(new GenericResponse<>("Successfully logged out!", null));
    }

    @PostMapping("saveAll")
    public ResponseEntity<?> saveAllStudent(@RequestBody final List<StudentRegister> studentRegisters) {

        try {
            final Object response = authStudentService.saveAll(studentRegisters);

            return ResponseEntity.ok(response);
        } catch (RegisterException e) {
            return ResponseEntity.badRequest().body(List.of(e.getMessage()));
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getErrors());
        }
    }

}
