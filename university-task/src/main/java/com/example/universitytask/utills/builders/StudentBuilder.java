package com.example.universitytask.utills.builders;

import com.example.universitytask.models.entities.Student;

import static com.example.universitytask.utills.IdHelper.randomId;

public final class StudentBuilder {
    private StudentBuilder() {
        throw new AssertionError("Utility class");
    }

    public static Student buildRegisterStudent(
            final String email,
            final int age,
            final String fullName,
            final String hashPassword
    ) {

        return Student
                .builder()
                .id(randomId())
                .fullName(fullName)
                .age(age)
                .email(email)
                .password(hashPassword)
                .build();

    }
}
