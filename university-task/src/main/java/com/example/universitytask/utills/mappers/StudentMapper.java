package com.example.universitytask.utills.mappers;

import com.example.universitytask.models.dtos.responses.StudentResponse;
import com.example.universitytask.models.entities.Student;

public final class StudentMapper {

    private StudentMapper() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static StudentResponse toStudentResponse(final Student student) {
        return new StudentResponse(
                student.getFullName(), student.getAge(), student.getEmail(), student.getId());

    }
}
