package com.example.universitytask.services;

import com.example.universitytask.errors.exceptions.CredentialsExceptions;
import com.example.universitytask.errors.exceptions.RegisterException;
import com.example.universitytask.models.dtos.requests.StudentRegister;
import com.example.universitytask.models.entities.Student;
import com.example.universitytask.repositories.StudentRepository;
import com.example.universitytask.utills.builders.StudentBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.universitytask.utills.CredentialsHelper.hashPassword;
import static com.example.universitytask.utills.NameBuilder.buildFullName;
import static com.example.universitytask.utills.validators.StudentValidator.validateRegisterRequest;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthStudentService {

    private final StudentRepository studentRepository;

    public void signup(final StudentRegister studentRegister) throws RegisterException {
        final String methodName = "signup";
        final List<String> errors =
                validateRegisterRequest(studentRegister);

        if (!errors.isEmpty()) {
            final String logMessage = ("%s Errors");
            throw new RegisterException("signup Exception", logMessage, errors.toArray(String[]::new));
        }

        final Optional<Student> optionalStudent =
                studentRepository.findByEmail(studentRegister.email());

        if (optionalStudent.isPresent()) {
            final String logMessage =
                    String.format("%s, Errors in registration for email [%s], due to account is already registered",
                            methodName, studentRegister.email());
            throw new RegisterException("cannot find email[%s]", logMessage, studentRegister.email());
        }

        final String fullName =
                buildFullName(studentRegister.firstName(), studentRegister.secondName());
        final String hashPassword;
        try {
            hashPassword = hashPassword(studentRegister.password());
        } catch (final CredentialsExceptions e) {
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
}
