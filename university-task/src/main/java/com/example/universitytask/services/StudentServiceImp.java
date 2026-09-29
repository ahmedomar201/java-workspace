package com.example.universitytask.services;

import com.example.universitytask.models.dtos.requests.StudentUpdate;
import com.example.universitytask.models.dtos.responses.GenericResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

import com.example.universitytask.models.dtos.responses.StudentResponse;
import com.example.universitytask.models.entities.Student;
import com.example.universitytask.repositories.StudentRepository;
import com.example.universitytask.utills.mappers.StudentMapper;

import static com.example.universitytask.utills.CredentialsHelper.hashPassword;
import static com.example.universitytask.utills.NameBuilder.buildFullName;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentResponse> getAllStudent()throws NoSuchElementException {
        final String methodName = "findAllSortedByAge";
        final Collection<Student> studentList = studentRepository.findAllSortedByAge();

        log.debug("{}, Successfully fetched all students sorted by age", methodName);

        if (studentList.isEmpty()) {
            log.error("{}, No students found in the DB!", methodName);
            throw new NoSuchElementException("Student not found");
        }

        return studentList.stream().map(
                        StudentMapper::toStudentResponse)
                .toList();
    }

    @Override
    public GenericResponse<StudentResponse> findById(final UUID id)throws NoSuchElementException {
        final Optional<Student> optionalFoundStudent = studentRepository.findById(id);

        if (optionalFoundStudent.isEmpty()) {
            throw new NoSuchElementException("student not found");
        }

        final StudentResponse studentResponse = StudentMapper.toStudentResponse(optionalFoundStudent.get());
        return new GenericResponse<>("Student found", studentResponse);
    }

    @Override
    public List<StudentResponse> findAllSucceedStudent()throws NoSuchElementException {

        final Collection<Student> allSucceedStudent = studentRepository.findAllSucceeded();

        if (allSucceedStudent.isEmpty()) {
            throw new NoSuchElementException("student not found");
        }

        return allSucceedStudent.stream().map(
                        StudentMapper::toStudentResponse)
                .toList();

    }

    @Override
    public void updateStudent(
            final UUID id, final StudentUpdate studentUpdate)throws NoSuchElementException {

        final Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isEmpty()) {
            throw new NoSuchElementException("student not found");
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


    }

    @Override
    public void deleteStudent(final UUID id) {

        final Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isEmpty()) {
            throw new NoSuchElementException("student not found");
        }

        studentRepository.delete(id);
    }

    @Override
    public void deleteAllStudent(){

       studentRepository.deleteAll();
    }

}
