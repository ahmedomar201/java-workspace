package com.example.universitytask.services;

import com.example.universitytask.errors.exceptions.CredentialsExceptions;
import com.example.universitytask.errors.exceptions.RegisterException;
import com.example.universitytask.models.dtos.requests.StudentRegister;
import com.example.universitytask.models.entities.Student;
import com.example.universitytask.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.example.universitytask.utills.CredentialsHelper.hashPassword;
import static com.example.universitytask.utills.NameBuilder.buildFullName;
import static com.example.universitytask.utills.validators.StudentValidator.validateRegisterRequest;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthStudentService {

    private final StudentRepository studentRepository;

    public void signup(final StudentRegister studentRegister){
        final String methodName = "signup";
        final List<String> errors =
                validateRegisterRequest(studentRegister);


        if (!errors.isEmpty()) {
            log.error("[{}]errors in register student api[{}]", methodName, errors);
           throw new RegisterException(errors);
        }

        final Optional<Student> optionalStudent = findByEmail(studentRegister.email());

        if (optionalStudent.isPresent()) {
            return ResponseEntity.badRequest().body(
                    List.of("already Registered " + studentRegister.email())
            );
        }

        final String fullName =
                buildFullName(studentRegister.firstName(), studentRegister.secondName());
        final String hashPassword;
        try {
            hashPassword = hashPassword(studentRegister.password());
        } catch (CredentialsExceptions e) {
            log.error("can't hash pass");
            return ResponseEntity.badRequest().build();
        }
        final Student student = new Student(UUID.randomUUID(),
                fullName
                , studentRegister.age(),
                studentRegister.email(),
                hashPassword, false,
                0.0F, 0.0F);
        save(student);
        return ResponseEntity.ok(List.of(
                "Successfully registered student with Email: " + studentRegister.email()));

    }

}
