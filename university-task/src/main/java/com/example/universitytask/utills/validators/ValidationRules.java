package com.example.universitytask.utills.validators;

import java.util.HashMap;
import java.util.Map;

import static com.example.universitytask.utills.StringUtils.isNullOrBlank;

public final class ValidationRules {
    private static final Map<String, ValidatorService<String>> STRING_VALIDATOR_Rules = new HashMap<>();

    static {
        STRING_VALIDATOR_Rules.putIfAbsent("firstName", ValidationRules::isFirstName);
        STRING_VALIDATOR_Rules.putIfAbsent("secondName", ValidationRules::isSecondName);
        STRING_VALIDATOR_Rules.putIfAbsent("age", ValidationRules::isAgeValid);
        STRING_VALIDATOR_Rules.putIfAbsent("email", ValidationRules::isEmailValid);
        STRING_VALIDATOR_Rules.putIfAbsent("password", ValidationRules::isPasswordValid);
    }

    public static boolean validate(final String rule) {

        final ValidatorService<String> validatorService = STRING_VALIDATOR_Rules.get(rule);

        if (validatorService == null) {
            return false;
        }
        return validatorService.isValid(rule);
    }

    private ValidationRules() {

        throw new AssertionError("Utility class");
    }

    private static boolean isFirstName(final String firstName) {

        return !isNullOrBlank(firstName) && firstName.length() >= 2 && firstName.length() <= 15;
    }

    private static boolean isSecondName(final String secondName) {

        return !isNullOrBlank(secondName) && secondName.length() >= 2 && secondName.length() <= 15;
    }

    private static boolean isAgeValid(final String age) {

        final int intAge = Integer.parseInt(age);

        return intAge >= 18 && intAge <= 25;
    }

    private static boolean isEmailValid(final String email) {

        return !isNullOrBlank(email) && email.contains("@") && email.contains(".");
    }

    private static boolean isPasswordValid(final String password) {

        return !isNullOrBlank(password) && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9\\s])\\S{9,31}$");
    }

}
