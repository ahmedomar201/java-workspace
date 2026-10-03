package com.example.universitytask.services;

import com.example.universitytask.models.dtos.requests.StudentUpdate;
import com.example.universitytask.models.dtos.responses.StudentResponse;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    List<StudentResponse> getAllStudent();

    StudentResponse findById(UUID id);

    List<StudentResponse> findAllSucceedStudent();

    void updateStudent(UUID id, StudentUpdate studentUpdate);

    void deleteStudent(UUID id);

    void deleteAllStudent();
}
