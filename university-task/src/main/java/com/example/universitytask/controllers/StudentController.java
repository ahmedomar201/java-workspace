package com.example.universitytask.controllers;

import com.example.universitytask.errors.exceptions.CredentialsExceptions;
import com.example.universitytask.errors.exceptions.RegisterException;
import com.example.universitytask.models.dtos.requests.StudentRegister;
import com.example.universitytask.models.entities.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static com.example.universitytask.repositories.StudentRepository.*;
import static com.example.universitytask.utills.CredentialsHelper.hashPassword;
import static com.example.universitytask.utills.NameBuilder.buildFullName;
import static com.example.universitytask.utills.validators.StudentValidator.validateRegisterRequest;

@RestController
@RequestMapping("student")
public class StudentController {


    @PostMapping("register")
    public ResponseEntity <Map<UUID, Student>> registerStudentApi(@RequestBody final StudentRegister studentRegister) {


        Optional < ResponseEntity<Map<UUID, Student>>> optional= validateRegisterRequest(studentRegister);

        if (optional.isPresent()) {
            return optional.get();
        }

        try {
            findRegisterStudent(studentRegister);
        } catch (RegisterException e) {
           return ResponseEntity.badRequest().build();
        }


        final  String fullName = buildFullName(studentRegister.getFirstName(),studentRegister.getSecondName());
        final  String hashPassword;
        try {
            hashPassword = hashPassword(studentRegister.getPassword());
        } catch (CredentialsExceptions e) {
            return ResponseEntity.badRequest().build();
        }
        final   Student student =new Student(UUID.randomUUID(),
                fullName
                ,studentRegister.getAge(),
                studentRegister.getEmail(),
                hashPassword,false,
                0.0F, 0.0F);
        saveStudent(student);
        return ResponseEntity.ok(STUDENT_DB)  ;
    }


}
//http://localhost:8080/welcome/student/mohamed
