package com.example.universitytask.models.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record StudentLogin(
        @Email(message = "Email must be valid")
        String email,
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9\\s])\\S{9,31}$",
                message = "{validation.password.pattern}")
        String password
) {

}