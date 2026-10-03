package com.example.universitytask.services;

import com.example.universitytask.errors.exceptions.*;
import com.example.universitytask.models.dtos.requests.StudentLogin;
import com.example.universitytask.models.dtos.requests.StudentRegister;
import com.example.universitytask.models.dtos.responses.GenericResponse;
import com.example.universitytask.models.dtos.responses.StudentResponse;
import com.example.universitytask.models.entities.Student;
import com.example.universitytask.repositories.StudentRepository;
import com.example.universitytask.utills.builders.StudentBuilder;
import com.example.universitytask.utills.mappers.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.universitytask.utills.CredentialsHelper.hashPassword;
import static com.example.universitytask.utills.NameBuilder.buildFullName;
import static com.example.universitytask.utills.validators.StudentValidator.validateRegisterRequest;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthStudentServiceImp implements AuthStudentService {

    private final StudentRepository studentRepository;

    @Override
    public void signup(final StudentRegister studentRegister) throws RegisterException, ValidationException {
        final String methodName = "signup";
        final List<String> errors =
                validateRegisterRequest(studentRegister);

        if (!errors.isEmpty()) {
            final String logMessage = ("%s Errors");
            throw new ValidationException("signup Exception", logMessage, errors);
        }

        final Optional<Student> optionalStudent =
                studentRepository.findByEmail(studentRegister.email());

        if (optionalStudent.isPresent()) {
            final String logMessage =
                    String.format("%s, Errors in registration for email [%s], due to account is already registered",
                            methodName, studentRegister.email());
            throw new RegisterException("cannot find email[%s]", logMessage);
        }

        final String fullName =
                buildFullName(studentRegister.firstName(), studentRegister.secondName());
        final String hashPassword;
        try {
            hashPassword = hashPassword(studentRegister.password());
        } catch (final CredentialsException e) {
            final String logMessage =
                    String.format("%s, Cannot hash the [%s] user password due to: [%s]",
                            methodName, studentRegister.email(), e.getMessage());
            throw new RegisterException(e.getMessage(), logMessage);
        }
        final Student student = StudentBuilder.buildRegisterStudent(
                studentRegister.email(),
                studentRegister.age(),
                fullName, hashPassword
        );

        studentRepository.save(student);

        log.debug("{}, Successfully registered student with email [{}]", methodName, student.getEmail());

    }

    @Override
    public void login(final StudentLogin studentLogin) throws LoginException, CredentialsException {

        final Student foundStudent = studentRepository
                .findByEmail(studentLogin.email())
                .orElseThrow(() -> new LoginException(
                        "Student with Email: " + studentLogin.email() + " not found"));

        if (foundStudent.isLoggedIn()) {
            throw new LoginException("Student with Email: " + studentLogin.email() + " is already logged in");
        }

        final String hashPassword = hashPassword(studentLogin.password());

        if (hashPassword.equals(studentLogin.password())) {
            throw new LoginException("passwords don't match");
        }
        foundStudent.login();

    }

    @Override
    public void logout(final String email) throws LogoutException {

        final Student foundStudent = studentRepository
                .findByEmail(email)
                .orElseThrow(() -> new LogoutException(
                        "Student with email: " + email + " not registered"));

        foundStudent.logout();
    }

    @Override
    public GenericResponse<?> saveAll(final List<StudentRegister> students)
            throws RegisterException, ValidationException {

        final List<Student> registerStudent = new ArrayList<>();
        students.forEach(student -> {
                    Optional<Student> optionalStudent =
                            studentRepository.findByEmail(student.email());
                    if (optionalStudent.isPresent()) {
                        registerStudent.add(optionalStudent.get());
                        return;
                    }
                    signup(student);
                }
        );
        if (registerStudent.isEmpty()) {

            return new GenericResponse<>("Save all student Successfully", Optional.empty());
        }
        final List<StudentResponse> rejectedStudentsList = registerStudent.stream().map(
                StudentMapper::toStudentResponse
        ).toList();

        return new GenericResponse<>(
                "those list are rejected to be inserted",
                rejectedStudentsList);
    }

}
