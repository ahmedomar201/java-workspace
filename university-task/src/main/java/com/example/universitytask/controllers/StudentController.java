package com.example.universitytask.controllers;

import com.example.universitytask.models.dtos.requests.StudentUpdate;
import com.example.universitytask.models.dtos.responses.StudentResponse;
import com.example.universitytask.services.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("getAll")
    public List<StudentResponse> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("findById/{id}")
    public StudentResponse findByIdApi(@PathVariable UUID id) {
        return studentService.findById(id);
    }

    @PutMapping("update/{id}")
    public String updateStudentApi(
            @PathVariable final UUID id, @RequestBody final StudentUpdate studentUpdate) {
        studentService.updateStudent(id, studentUpdate);

        return "Successfully updated  with Email: " + studentUpdate.email();
    }

    @DeleteMapping("delete")
    public String deleteStudent(@RequestParam final UUID id) {

        final StudentResponse studentResponse = studentService.findById(id);

        studentService.deleteStudent(id);

        return "Successfully deleted Student with Email: " + studentResponse.email();
    }

    @DeleteMapping("deleteAll")
    public String deleteAllStudent() {

        studentService.deleteAllStudent();
        return "Successfully deleted All Student with Email: ";
    }

    @GetMapping("getAllSucceedStudent")
    public Collection<StudentResponse> findAllSucceedStudentApi() {
        return studentService.findAllSucceedStudent();
    }
}
