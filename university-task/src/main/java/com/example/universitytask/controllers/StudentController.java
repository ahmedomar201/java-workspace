package com.example.universitytask.controllers;

import com.example.universitytask.errors.exceptions.CredentialsExceptions;
import com.example.universitytask.models.dtos.requests.StudentLogin;
import com.example.universitytask.models.dtos.requests.StudentRegister;
import com.example.universitytask.models.dtos.responses.StudentResponse;
import com.example.universitytask.models.entities.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.example.universitytask.repositories.StudentRepository.*;
import static com.example.universitytask.utills.CredentialsHelper.hashPassword;
import static com.example.universitytask.utills.NameBuilder.buildFullName;
import static com.example.universitytask.utills.validators.StudentValidator.validateRegisterRequest;

@RestController
@RequestMapping("student")
public class StudentController {


    @PostMapping("register")
    public ResponseEntity<List<String>> registerStudentApi(
            @RequestBody final StudentRegister studentRegister) {


        final ResponseEntity<List<String>> errorsResponseEntities =
                validateRegisterRequest(studentRegister);


        final List<String> errorMessages = errorsResponseEntities.getBody();

        if (!errorMessages.isEmpty()) {
            return ResponseEntity.badRequest().body(errorMessages);
        }

        final Optional<Student> optionalStudent = findByEmail(studentRegister.getEmail());

        if (optionalStudent.isPresent()) {
            return ResponseEntity.badRequest().body(
                    List.of("already Registered " + studentRegister.getEmail())
            );
        }


        final String fullName =
                buildFullName(studentRegister.getFirstName(), studentRegister.getSecondName());
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
        save(student);
        return ResponseEntity.ok(List.of(
                "Successfully registered student with Email: " + studentRegister.getEmail()));
    }


    @PostMapping("login")
    public ResponseEntity<String> loginStudentApi(
            @RequestBody final StudentLogin studentLogin) {

        final Optional<Student> optionalStudent = findByEmail(studentLogin.getEmail());

        if (optionalStudent.isEmpty()) {
            return ResponseEntity.badRequest().body(
                    "Student with Email: " + studentLogin.getEmail() + " not found");
        }

        //معناها هاتلي كل student اللي موجود جوه الـ Optional.
        //عشان اعرف استخدمها في مثلا email or password
        final Student foundStudent = optionalStudent.get();

        if (foundStudent.isLoggedIn()) {
            return ResponseEntity.badRequest().body("Student already logged in");
        }
        final String hashPassword;
        try {
            hashPassword = hashPassword(studentLogin.getPassword());
        } catch (CredentialsExceptions e) {
            return ResponseEntity.badRequest().build();
        }

        if (hashPassword.equals(studentLogin.getPassword())) {
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

    @PostMapping("saveALL")
    public ResponseEntity<String> saveAllStudent(@RequestBody final List<StudentRegister> students) {

        students.forEach(this::registerStudentApi);

        return ResponseEntity.ok("");

    }

    @GetMapping("getAll")
    public ResponseEntity<?> finsAllStudent() {


        final Collection<Student> studentList = getAll();

        if (studentList.isEmpty()) {

            return ResponseEntity.badRequest().body("not found Student");
        }
        final Collection<StudentResponse> studentResponses = studentList.stream().map(
                        StudentController::toStudentResponse)
                .toList();

        return ResponseEntity.ok(studentResponses);

    }

    @GetMapping("findById/{id}")
    public ResponseEntity<?> findByIdApi(@PathVariable final UUID id) {
        final Optional<Student> optionalStudent = findById(id);

        if (optionalStudent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("student not found");
        }

        return ResponseEntity.ok(StudentController.toStudentResponse(optionalStudent.get()));
    }

//    @PutMapping("update/{id}")
//    public ResponseEntity<String> updateStudentApi(
//            @RequestBody final StudentRegister studentRegister) {
//
//
//    }


    private static StudentResponse toStudentResponse(final Student student) {


        return new StudentResponse(
                student.getFullName(), student.getAge(), student.getEmail());

    }
}
