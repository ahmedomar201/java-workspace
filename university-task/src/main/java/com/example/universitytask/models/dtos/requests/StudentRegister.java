package com.example.universitytask.models.dtos.requests;

import jakarta.validation.constraints.*;

public record StudentRegister(
        @NotBlank(message = "first name must be not blank")
        @Size(min = 2, max = 15, message = "First name be between 2 and 3")
        String firstName,
        @NotBlank(message = "second name must be not blank")
        @Size(min = 2, max = 15, message = "second name be between 2 and 3")
        String secondName,
        @Max(message = "Age must be at most 25 years old", value = 25)
        @Min(message = "Age must be at least 18 years old", value = 18)
        int age,
        @Email(message = "Email must be valid")
        String email,
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9\\s])\\S{9,31}$",
                message = "{validation.password.pattern}")
        String password
) {
    
}
