package com.example.universitytask.controllers;

import com.example.universitytask.errors.exceptions.CredentialsExceptions;
import com.example.universitytask.models.dtos.requests.StudentLogin;
import com.example.universitytask.models.dtos.requests.StudentRegister;
import com.example.universitytask.models.dtos.responses.GenericResponse;
import com.example.universitytask.models.dtos.responses.StudentResponse;
import com.example.universitytask.models.entities.Student;
import com.example.universitytask.services.AuthStudentService;
import com.example.universitytask.utills.mappers.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthStudentService authStudentService;

    @PostMapping("register")
    public ResponseEntity<List<String>> registerStudentApi(
            @RequestBody final StudentRegister studentRegister) {

        final String methodName = "Register Student Api";
        log.info("[{}]Implementing Registration flow[{}", methodName, studentRegister.email());

        authStudentService.signup(studentRegister);

        log.info("{}, Successfully registered student with email [{}]", methodName, studentRegister.email());

        return ResponseEntity.ok(List.of(
                "Successfully registered student with Email: " + studentRegister.email()));

    }

    @PostMapping("login")
    public ResponseEntity<String> loginStudentApi(
            @RequestBody final StudentLogin studentLogin) {


        return ResponseEntity.ok(
                "Successfully logged in with Email: " + foundStudent.getEmail());
    }

    @PostMapping("logout")
    public ResponseEntity<GenericResponse<String>> logoutApi(@RequestParam String email) {
        final Optional<Student> optionalFoundStudent = findByEmail(email);

        if (optionalFoundStudent.isEmpty()) {
            return ResponseEntity.badRequest().body(new GenericResponse<>("Student with email: " + email + " not registered", null));
        }

        final Student foundStudent = optionalFoundStudent.get();

        if (!foundStudent.isLoggedIn()) {
            return ResponseEntity.badRequest().body(new GenericResponse<>("Student not logged in", null));
        }

        foundStudent.setLoggedIn(false);

        return ResponseEntity.ok(new GenericResponse<>("Successfully logged out!", null));
    }

    @PostMapping("saveAll")
    public ResponseEntity<?> saveAllStudent(@RequestBody final List<StudentRegister> students) {
        final List<Student> registerStudent = new ArrayList<>();
        students.forEach(student -> {
                    Optional<Student> optionalStudent = findByEmail(student.email());
                    if (optionalStudent.isPresent()) {
                        registerStudent.add(optionalStudent.get());
                        return;
                    }
                    registerStudentApi(student);
                }
        );
        if (registerStudent.isEmpty()) {
            return ResponseEntity.ok("Save all student Successfully");
        }
        final List<StudentResponse> rejectedStudentsList = registerStudent.stream().map(
                StudentMapper::toStudentResponse
        ).toList();

        final GenericResponse<List<StudentResponse>> genericResponse =
                new GenericResponse<>("those list are rejected to be inserted", rejectedStudentsList);

        return ResponseEntity.ok().body(genericResponse);
    }
}
