package com.example.universitytask.controllers;

import com.example.universitytask.errors.exceptions.CredentialsExceptions;
import com.example.universitytask.errors.exceptions.RegisterException;
import com.example.universitytask.models.dtos.requests.StudentLogin;
import com.example.universitytask.models.dtos.requests.StudentRegister;
import com.example.universitytask.models.entities.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.example.universitytask.repositories.StudentRepository.*;
import static com.example.universitytask.utills.CredentialsHelper.hashPassword;
import static com.example.universitytask.utills.NameBuilder.buildFullName;
import static com.example.universitytask.utills.validators.StudentValidator.validateRegisterRequest;

@RestController
@RequestMapping("student")
public class StudentController {


    @PostMapping("register")
    public ResponseEntity<List<String>> registerStudentApi(@RequestBody final StudentRegister studentRegister) {


        final ResponseEntity<List<String>> errorsResponseEntities = validateRegisterRequest(studentRegister);


        final List<String> errorMessages = errorsResponseEntities.getBody();

        if (!errorMessages.isEmpty()) {
            return ResponseEntity.badRequest().body(errorMessages);
        }

        try {
            findRegisterStudent(studentRegister);
        } catch (RegisterException e) {
            return ResponseEntity.badRequest().body(List.of(e.getMessage()));
        }


        final String fullName = buildFullName(studentRegister.getFirstName(), studentRegister.getSecondName());
        final String hashPassword;
        try {
            hashPassword = hashPassword(studentRegister.getPassword());
        } catch (CredentialsExceptions e) {
            return ResponseEntity.badRequest().build();
        }
        final Student student = new Student(UUID.randomUUID(),
                fullName
                , studentRegister.getAge(),
                studentRegister.getEmail(),
                hashPassword, false,
                0.0F, 0.0F);
        saveStudent(student);
        return ResponseEntity.ok(List.of("Successfully registered student with Email: " + studentRegister.getEmail()));
    }


    @PostMapping("login")
    public ResponseEntity<List<String>> loginStudentApi(
            @RequestBody final StudentLogin studentLogin,@RequestBody final StudentRegister studentRegister) {

        final String hashPassword;
        try {
            hashPassword = hashPassword(studentLogin.getPassword());
        } catch (CredentialsExceptions e) {
            return ResponseEntity.badRequest().build();
        }

        final Student student = new Student(UUID.randomUUID(),
                fullName
                , studentRegister.getAge(),
                studentLogin.getEmail(),
                hashPassword, false,
                0.0F, 0.0F);

        return ResponseEntity.ok(List.of("Successfully login student with Email: " + studentLogin.getEmail()));
    }

}
//http://localhost:8080/welcome/student/mohamed
