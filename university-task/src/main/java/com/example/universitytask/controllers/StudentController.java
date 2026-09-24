package com.example.universitytask.controllers;

import com.example.universitytask.models.dtos.requests.StudentUpdate;
import com.example.universitytask.models.dtos.responses.GenericResponse;
import com.example.universitytask.models.dtos.responses.StudentResponse;
import com.example.universitytask.models.entities.Student;
import com.example.universitytask.utills.mappers.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import static com.example.universitytask.repositories.StudentRepository.*;
import static com.example.universitytask.utills.CredentialsHelper.hashPassword;
import static com.example.universitytask.utills.NameBuilder.buildFullName;

@Slf4j
@RestController
@RequestMapping("student")
public class StudentController {
    @GetMapping("getAll")
    public ResponseEntity<?> finDAllStudent() {

        final Collection<Student> studentList = getAllSortedByAge();

        if (studentList.isEmpty()) {

            return ResponseEntity.badRequest().body("not found Student");
        }
        final Collection<StudentResponse> studentResponses = studentList.stream().map(
                        StudentMapper::toStudentResponse)
                .toList();

        return ResponseEntity.ok(studentResponses);

    }

    @GetMapping("findById/{id}")
    public ResponseEntity<GenericResponse<StudentResponse>> findByIdApi(@PathVariable UUID id) {
        final Optional<Student> optionalFoundStudent = findById(id);

        if (optionalFoundStudent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericResponse<>("Student not found", null));
        }

        final StudentResponse studentResponse = StudentMapper.toStudentResponse(optionalFoundStudent.get());
        return ResponseEntity.ok(new GenericResponse<>("Student found", studentResponse));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateStudentApi(
            @PathVariable final UUID id, @RequestBody final StudentUpdate studentUpdate) {

        final Optional<Student> optionalStudent = findById(id);

        if (optionalStudent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("student not found");
        }

        final Student foundStudent = optionalStudent.get();

        final String newFullName =
                buildFullName(studentUpdate.firstName(), studentUpdate.secondName());

        final String newHashPassword = hashPassword(studentUpdate.password());

        foundStudent.setFullName(newFullName);
        foundStudent.setEmail(studentUpdate.email());
        foundStudent.setAge(studentUpdate.age());
        foundStudent.setPassword(newHashPassword);
        foundStudent.setScore(studentUpdate.score());

        return ResponseEntity.ok(
                "Successfully updated  with Email: " + foundStudent.getEmail());


    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteStudent(@RequestParam final UUID id) {

        final Optional<Student> optionalStudent = findById(id);

        if (optionalStudent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("student not found");
        }
        delete(id);

        return ResponseEntity.ok(
                "Successfully deleted Student with Email: " + optionalStudent.get().getEmail());


    }

    @DeleteMapping("deleteAll")
    public ResponseEntity<?> deleteAllStudent() {
        deleteAll();
        return ResponseEntity.ok(
                "Successfully deleted All Student with Email: ");
    }

    @GetMapping("getAllSucceedStudent")
    public ResponseEntity<?> findAllSucceedStudentApi() {

        final Collection<Student> allSucceedStudent = getAllSucceedStudent();

        if (allSucceedStudent.isEmpty()) {

            return ResponseEntity.badRequest().body("not found Student");
        }
        final Collection<StudentResponse> studentResponses = allSucceedStudent.stream().map(
                        StudentMapper::toStudentResponse)
                .toList();

        return ResponseEntity.ok(studentResponses);

    }
}
