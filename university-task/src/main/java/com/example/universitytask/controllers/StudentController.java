package com.example.universitytask.controllers;

import com.example.universitytask.models.dtos.requests.StudentRegister;
import com.example.universitytask.models.entities.Student;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class StudentController {
    private static final Map<UUID, Student> STUDENT_DB = new ConcurrentHashMap<>();



    @PostMapping("student")
    public void registerStudentApi(StudentRegister studentRegister) {

        String fullName = studentRegister.getFirstName() + " " + studentRegister.getSecondName();
        Student student = new Student();
        student.setId(UUID.randomUUID());
        student.setFullName(fullName);
        student.setEmail(studentRegister.getEmail());
        student.setPassword(studentRegister.getPassword());
        student.setAge(studentRegister.getAge());
    }


    private static String hashPassword(final String password) {
        byte[] hash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }


        return Base64.getEncoder().encodeToString(hash);


    }


//    @PostMapping("student")
//    public void register(StudentRegister studentRegister) {
//
//
//    }
//
//    @GetMapping("student")
//    public List<StudentResponse> finalAllStudentsAPI() {
//
//
//    }
//
//    @GetMapping("student/{id}")
//    public StudentResponse finalStudentByIdAPI(@PathVariable UUID id) {
//
//
//    }
//
//
//    @DeleteMapping("student/{id}")
//    public void  DeleteStudentByIdAPI(@PathVariable UUID id) {
//
//
//    }
//
//
//    @DeleteMapping("student")
//    public void DeleteAllStudentAPI() {
//
//
//    }


}
