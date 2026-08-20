package com.example.universitytask.repositories;

import com.example.universitytask.errors.exceptions.RegisterException;
import com.example.universitytask.models.entities.Student;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StudentRepository {

    //ConcurrentHashMap استخدمتها عشان لو 2 ريكوست جاييين في نفس الوقت thread الاول ميقطعش thread التاني

    public static final Map<UUID, Student> STUDENT_DB = new ConcurrentHashMap<>();

    public static Optional<Student> findByEmail(final String email)
            throws RegisterException {
        return STUDENT_DB.values().stream().filter(
                student -> student.getEmail().equals(email)
        ).findFirst();
    }


    public static Optional<Student> findById(final UUID id)
            throws RegisterException {
        return Optional.ofNullable(STUDENT_DB.get(id));
    }


    public static Collection<Student> getAll() {

        return STUDENT_DB.values();

    }


    public static void save(final Student student) {
        STUDENT_DB.put(student.getId(), student);
    }


    public static void delete(final UUID id) {
        STUDENT_DB.remove(id);
    }


    public static void update(final Student student) {
        STUDENT_DB.put(student.getId(), student);
    }



}
