package com.example.universitytask.controllers;

import com.example.universitytask.models.dtos.requests.StudentUpdate;
import com.example.universitytask.models.dtos.responses.GenericResponse;
import com.example.universitytask.models.dtos.responses.StudentResponse;
import com.example.universitytask.services.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("getAll")
    public ResponseEntity<?> getAllStudent() {

        final Collection<StudentResponse> studentResponses;

        try {
            studentResponses = studentService.getAllStudent();
        } catch (final NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResponses);
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<GenericResponse<StudentResponse>> findByIdApi(@PathVariable UUID id) {

        final StudentResponse studentResponse;
        try {
            studentResponse = studentService.findById(id);
        } catch (final NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new GenericResponse<>("Student not found", null));
        }

        return ResponseEntity.ok(new GenericResponse<>("Student found", studentResponse));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateStudentApi(
            @PathVariable final UUID id, @RequestBody final StudentUpdate studentUpdate) {

        try {
            studentService.updateStudent(id, studentUpdate);
        } catch (final NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("student not found");
        }

        return ResponseEntity.ok("Successfully updated  with Email: " + studentUpdate.email());
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteStudent(@RequestParam final UUID id) {

        final StudentResponse studentResponse;

        try {
            studentResponse = studentService.findById(id);
            studentService.deleteStudent(id);
        } catch (final NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("student not found");
        }

        return ResponseEntity.ok(
                "Successfully deleted Student with Email: " + studentResponse.email());
    }

    @DeleteMapping("deleteAll")
    public ResponseEntity<?> deleteAllStudent() {
    studentService.deleteAllStudent();
        return ResponseEntity.ok(
                "Successfully deleted All Student with Email: ");
    }

    @GetMapping("getAllSucceedStudent")
    public ResponseEntity<?> findAllSucceedStudentApi() {

        final Collection<StudentResponse> studentResponses;
        try {
            studentResponses = studentService.findAllSucceedStudent();
        } catch (final NoSuchElementException e) {
            return ResponseEntity.badRequest().body("not found Student");
        }

        return ResponseEntity.ok(studentResponses);

    }
}
