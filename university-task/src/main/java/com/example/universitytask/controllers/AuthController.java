package com.example.universitytask.controllers;

import com.example.universitytask.errors.exceptions.CredentialsExceptions;
import com.example.universitytask.models.dtos.requests.StudentLogin;
import com.example.universitytask.models.dtos.requests.StudentRegister;
import com.example.universitytask.models.dtos.responses.StudentResponse;
import com.example.universitytask.models.entities.Student;
import com.example.universitytask.utills.mappers.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.example.universitytask.repositories.StudentRepository.findByEmail;
import static com.example.universitytask.repositories.StudentRepository.save;
import static com.example.universitytask.utills.CredentialsHelper.hashPassword;
import static com.example.universitytask.utills.NameBuilder.buildFullName;
import static com.example.universitytask.utills.validators.StudentValidator.validateRegisterRequest;

@Slf4j
@RestController
@RequestMapping("auth")
public class AuthController {
    @PostMapping("register")
    public ResponseEntity<List<String>> registerStudentApi(
            @RequestBody final StudentRegister studentRegister) {
        final String methodName = "Register Student Api";
        log.info("[{}]Implementing Registration flow[{}", methodName, studentRegister.email());
        final ResponseEntity<List<String>> errorsResponseEntities =
                validateRegisterRequest(studentRegister);

        final List<String> errorMessages = errorsResponseEntities.getBody();

        if (!errorMessages.isEmpty()) {
            log.error("[{}]errors in register student api[{}]", methodName, errorMessages);
            return ResponseEntity.badRequest().body(errorMessages);
        }

        final Optional<Student> optionalStudent = findByEmail(studentRegister.email());

        if (optionalStudent.isPresent()) {
            return ResponseEntity.badRequest().body(
                    List.of("already Registered " + studentRegister.email())
            );
        }

        final String fullName =
                buildFullName(studentRegister.firstName(), studentRegister.secondName());
        final String hashPassword;
        try {
            hashPassword = hashPassword(studentRegister.password());
        } catch (CredentialsExceptions e) {
            log.error("can't hash pass");
            return ResponseEntity.badRequest().build();
        }
        final Student student = new Student(UUID.randomUUID(),
                fullName
                , studentRegister.age(),
                studentRegister.email(),
                hashPassword, false,
                0.0F, 0.0F);
        save(student);
        return ResponseEntity.ok(List.of(
                "Successfully registered student with Email: " + studentRegister.email()));
    }

    @PostMapping("login")
    public ResponseEntity<String> loginStudentApi(
            @RequestBody final StudentLogin studentLogin) {

        final Optional<Student> optionalStudent = findByEmail(studentLogin.email());

        if (optionalStudent.isEmpty()) {
            return ResponseEntity.badRequest().body(
                    "Student with Email: " + studentLogin.email() + " not found");
        }

        //معناها هاتلي كل student اللي موجود جوه الـ Optional.
        //عشان اعرف استخدمها في مثلا email or password
        final Student foundStudent = optionalStudent.get();

        if (foundStudent.isLoggedIn()) {
            return ResponseEntity.badRequest().body("Student already logged in");
        }
        final String hashPassword;
        try {
            hashPassword = hashPassword(studentLogin.password());
        } catch (CredentialsExceptions e) {
            return ResponseEntity.badRequest().build();
        }

        if (hashPassword.equals(studentLogin.password())) {
            foundStudent.setPassword(hashPassword);
        }

        foundStudent.setLoggedIn(true);

        return ResponseEntity.ok(
                "Successfully logged in with Email: " + foundStudent.getEmail());
    }

    @PostMapping("logout")
    public ResponseEntity<String> logoutStudentApi(
            @RequestParam final String email) {

        final Optional<Student> optionalStudent = findByEmail(email);

        if (optionalStudent.isEmpty()) {
            return ResponseEntity.badRequest().body(
                    "Student with Email: " + email + " not Registered");

        }

        final Student foundStudent = optionalStudent.get();

        if (!foundStudent.isLoggedIn()) {
            return ResponseEntity.badRequest().body("student not logged in");
        }
        foundStudent.setLoggedIn(false);

        return ResponseEntity.ok(
                "Successfully logged out with Email: " + foundStudent.getEmail());
    }

    @PostMapping("saveAll")
    public ResponseEntity<String> saveAllStudent(@RequestBody final List<StudentRegister> students) {
        final List<Student> registerStudent = new ArrayList<>();
        students.forEach(student -> {
                    Optional<Student> optionalStudent = findByEmail(student.email());
                    if ( optionalStudent.isPresent()) {
                        registerStudent.add(optionalStudent.get());
                        return;
                    }
                    registerStudentApi(student);
                }
        );
        if ( registerStudent.isEmpty()) {
            return ResponseEntity.ok("Save all student Successfully");
        }
    final List<StudentResponse>rejectedStudents=registerStudent.stream().map(
                StudentMapper::toStudentResponse
        ).toList();
        return ResponseEntity.ok().body(rejectedStudents.toString());
    }
}
