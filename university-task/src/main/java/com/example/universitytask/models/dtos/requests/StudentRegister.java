package com.example.universitytask.models.dtos.requests;

import com.example.universitytask.utills.validators.custominterface.Age;
import jakarta.validation.constraints.*;

public record StudentRegister(
        @NotBlank(message = "{validation.first-name.blank}")
        @Size(min = 2, max = 15, message = "{validation.first-name.error.message}")
        String firstName,
        @NotBlank(message = "{validation.second-name.blank}")
        @Size(min = 2, max = 15, message = "{validation.second-name.size}")
        String secondName,
//        @Max(message = "{validation.age.max}", value = 25)
//        @Min(message = "{validation.age.min}", value = 18)
        @Age
        int age,
        @Email(message = "{validation.email.pattern}")
        String email,
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9\\s])\\S{9,31}$",
                message = "{validation.password.pattern}")
        String password
) {

}
