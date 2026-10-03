package com.example.universitytask.controllers;

import com.example.universitytask.models.dtos.requests.StudentLogin;
import com.example.universitytask.models.dtos.requests.StudentRegister;
import com.example.universitytask.models.dtos.responses.GenericResponse;
import com.example.universitytask.services.AuthStudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthStudentService authStudentService;

    @PostMapping("register")
    public String registerStudentApi(
            @RequestBody final StudentRegister studentRegister) {

        final String methodName = "Register Student Api";
        log.info("[{}]Implementing Registration flow[{}", methodName, studentRegister.email());

        authStudentService.signup(studentRegister);

        log.info("{}, Successfully registered student with email [{}]", methodName, studentRegister.email());

        return "Successfully registered student with Email: " + studentRegister.email();

    }

    @PostMapping("login")
    public String loginStudentApi(
            @RequestBody final StudentLogin studentLogin) {

        authStudentService.login(studentLogin);

        return "student with email: " + studentLogin.email() + "logged in successfully";
    }

    @PostMapping("logout")
    public String logoutApi(@RequestParam final String email) {

        authStudentService.logout(email);

        return "Successfully logged out!";
    }

    @PostMapping("saveAll")
    public GenericResponse<?> saveAllStudent(@RequestBody final List<StudentRegister> studentRegisters) {

        return authStudentService.saveAll(studentRegisters);

    }

}
