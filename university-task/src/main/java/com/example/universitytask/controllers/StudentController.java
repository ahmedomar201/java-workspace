package com.example.universitytask.controllers;

import com.example.universitytask.errors.exceptions.CredentialsExceptions;
import com.example.universitytask.models.dtos.requests.StudentRegister;
import com.example.universitytask.models.entities.Student;
import org.jspecify.annotations.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
@RestController
@RequestMapping("student")
public class StudentController {

    //ConcurrentHashMap استخدمتها عشان لو 2 ريكوست جاييين في نفس الوقت thread الاول ميقطعش thread التاني
    private static final Map<UUID, Student> STUDENT_DB = new ConcurrentHashMap<>();

    @PostMapping("register")
    public Map<UUID, Student> registerStudentApi(@RequestBody final StudentRegister studentRegister) {

        final  String fullName = buildFullName(studentRegister);
        final  String hashPassword =hashPassword(studentRegister.getPassword());
        final   Student student =new Student(UUID.randomUUID(),
                fullName
                ,studentRegister.getAge(),
                studentRegister.getEmail(),
                hashPassword,false,
                0.0F, 0.0F);
        saveStudent(student);
        return  STUDENT_DB;
    }



    private static void saveStudent(final Student student) {
        StudentController.STUDENT_DB.put(student.getId(), student);
    }

    private static String buildFullName(final StudentRegister studentRegister) {
        return studentRegister.getFirstName() + " " + studentRegister.getSecondName();
    }
    //عملت hash لل password
    private static String hashPassword(final String password) {
        byte[] hash;
        try {
         final   MessageDigest md = MessageDigest.getInstance("SHA-256");
            hash = md.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new CredentialsExceptions("SHA-256 is not supported");
        }

        return Base64.getEncoder().encodeToString(hash);

    }

}
