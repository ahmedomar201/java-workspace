package com.example.universitytask.utills.validators;

import com.example.universitytask.models.dtos.requests.StudentRegister;
import com.example.universitytask.models.entities.Student;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static com.example.universitytask.utills.StringUtills.isNullOrBlank;

public class StudentValidator {


    public static Optional<ResponseEntity<Map<UUID, Student>>> validateRegisterRequest(
            final StudentRegister studentRegister) {
        if(isNullOrBlank(studentRegister.getFirstName())){

            return Optional.of(ResponseEntity.badRequest().build());
        }

        if(isNullOrBlank(studentRegister.getSecondName())){

            return  Optional.of(ResponseEntity.badRequest().build());
        }

        if(isEmailInvalid(studentRegister.getEmail())){

            return  Optional.of(ResponseEntity.badRequest().build());
        }

        if(isAgeMisAligned(studentRegister.getAge())){

            return  Optional.of(ResponseEntity.badRequest().build());
        }

        if(isPasswordInvalid(studentRegister.getPassword()))
        {
            return  Optional.of(ResponseEntity.badRequest().build());
        }
        return Optional.empty();
    }


    private static boolean isPasswordInvalid(final String password){
        return isNullOrBlank(password)|| password.length()<8||
                password.length()>32;
    }


    private static boolean isEmailInvalid(final String email){
        return isNullOrBlank(email)
                || !email.contains("@");
    }

    private static boolean isAgeMisAligned(final int age){
        return  age < 18 || age > 25;
    }


}
