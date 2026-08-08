package com.example.universitytask.repositories;

import com.example.universitytask.controllers.StudentController;
import com.example.universitytask.errors.exceptions.RegisterException;
import com.example.universitytask.models.dtos.requests.StudentRegister;
import com.example.universitytask.models.entities.Student;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class StudentRepository {

    //ConcurrentHashMap استخدمتها عشان لو 2 ريكوست جاييين في نفس الوقت thread الاول ميقطعش thread التاني

    public static final Map<UUID, Student> STUDENT_DB = new ConcurrentHashMap<>();

    public static void findRegisterStudent(StudentRegister studentRegister)throws RegisterException {
        STUDENT_DB.values().stream().filter(
                student ->  student.getEmail().equals(studentRegister.getEmail())
        ).findFirst().ifPresent(student->{ throw new  RegisterException(" already  Registered");
        });
    }


    public static void saveStudent(final Student student) {
        STUDENT_DB.put(student.getId(), student);
    }


}
