package com.example.universitytask.models.dtos.requests;

import com.example.universitytask.utills.validators.ValidationItems;
import com.example.universitytask.utills.validators.ValidationRules;
import com.example.universitytask.utills.validators.custominterface.Age;
import jakarta.validation.constraints.*;

import java.util.LinkedHashMap;
import java.util.Map;

public record StudentRegister(
//        @NotBlank(message = "{validation.first-name.blank}")
//        @Size(min = 2, max = 15, message = "{validation.first-name.error.message}")
        String firstName,
//        @NotBlank(message = "{validation.second-name.blank}")
//        @Size(min = 2, max = 15, message = "{validation.second-name.size}")
        String secondName,
//        @Max(message = "{validation.age.max}", value = 25)
//        @Min(message = "{validation.age.min}", value = 18)
//        @Age(min = 18, max = 25)
        int age,
//        @Email(message = "{validation.email.pattern}")
        String email,
//        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9\\s])\\S{9,31}$",
//                message = "{validation.password.pattern}")
        String password
) {

    public void validate() throws ValidationRules.ValidationException {

        final Map<String, String> errors = new LinkedHashMap<>();

        try {
            ValidationRules.validate(ValidationItems.FIRST_NAME, firstName);
        } catch (final ValidationRules.RuleException e) {
            errors.putIfAbsent(e.getMessage(), e.getDescription());
        }
        try {
            ValidationRules.validate(ValidationItems.SECOND_NAME, secondName);
        } catch (final ValidationRules.RuleException e) {
            errors.putIfAbsent(e.getMessage(), e.getDescription());
        }
        try {
            ValidationRules.validate(ValidationItems.AGE, String.valueOf(age));
        } catch (ValidationRules.RuleException e) {
            errors.putIfAbsent(e.getMessage(), e.getDescription());
        }
        try {
            ValidationRules.validate(ValidationItems.EMAIL, email);
        } catch (ValidationRules.RuleException e) {
            errors.putIfAbsent(e.getMessage(), e.getDescription());
        }
        try {
            ValidationRules.validate(ValidationItems.PASSWORD, password);
        } catch (ValidationRules.RuleException e) {
            errors.putIfAbsent(e.getMessage(), e.getDescription());
        }

        if (!errors.isEmpty()) {
            throw new ValidationRules.ValidationException(errors);
        }
    }
}
