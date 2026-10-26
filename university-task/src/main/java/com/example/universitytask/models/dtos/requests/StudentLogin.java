package com.example.universitytask.models.dtos.requests;

import com.example.universitytask.utills.validators.ValidationItems;
import com.example.universitytask.utills.validators.ValidationRules;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record StudentLogin(
//        @Email(message = "Email must be valid")
        String email,
//        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9\\s])\\S{9,31}$",
//                message = "{validation.password.pattern}")
        String password
) {
    public void validate() throws ValidationRules.RuleException {

        ValidationRules.validate(ValidationItems.EMAIL, email);
        ValidationRules.validate(ValidationItems.PASSWORD, password);
    }
}