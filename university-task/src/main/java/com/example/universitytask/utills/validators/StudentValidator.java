package com.example.universitytask.utills.validators;

import com.example.universitytask.models.dtos.requests.StudentRegister;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static com.example.universitytask.utills.StringUtills.isNullOrBlank;

public class StudentValidator {


    public static ResponseEntity<List<String>>validateRegisterRequest(
            final StudentRegister studentRegister) {

        final List<String> errors = new LinkedList<>();
        if (isNullOrBlank(studentRegister.firstName())) {

            errors.add("First name is required");


        }

        if (isNullOrBlank(studentRegister.secondName())) {

            errors.add("Second name is required");

        }

        if (isEmailInvalid(studentRegister.email())) {

            errors.add("Email is required");

        }

        if (isAgeMisAligned(studentRegister.age())) {

            errors.add("Age is required");


        }

        if (isPasswordInvalid(studentRegister.password())) {

            errors.add("Password is required");

        }
        return ResponseEntity.badRequest().body(errors);
    }


    private static boolean isPasswordInvalid(final String password) {
        return isNullOrBlank(password) || password.length() < 8 ||
                password.length() > 32;
    }


    private static boolean isEmailInvalid(final String email) {
        return isNullOrBlank(email)
                || !email.contains("@");
    }

    private static boolean isAgeMisAligned(final int age) {
        return age < 18 || age > 25;
    }
}
