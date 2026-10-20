package com.example.universitytask.utills.validators;

import com.example.universitytask.utills.times.TimeHelper;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.sql.Timestamp;
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

    private ValidationRules() {

        throw new AssertionError("Utility class");
    }

    public static void validate(final String rule) throws ValidationException {

        if (isNullOrBlank(rule)) {
            throw new ValidationException("Rule is null or blank");
        }



        if (isNullOrBlank(rule)) {
            return false;
        }


        return STRING_VALIDATOR_Rules.get(rule).isValid(rule);
    }

    private static ValidatorService<String> containRule(final String rule) {

        final ValidatorService<String> validatorService = STRING_VALIDATOR_Rules.get(rule);

        return validatorService != null;

    }

    private static boolean isFirstName(final String firstName) {

        return firstName.length() >= 2 && firstName.length() <= 15;
    }

    private static boolean isSecondName(final String secondName) {

        return secondName.length() >= 2 && secondName.length() <= 15;
    }

    private static boolean isAgeValid(final String age) {

        final int intAge = Integer.parseInt(age);

        return intAge >= 18 && intAge <= 25;
    }

    private static boolean isEmailValid(final String email) {

        return email.contains("@") && email.contains(".");
    }

    private static boolean isPasswordValid(final String password) {

        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9\\s])\\S{9,31}$");
    }

    @Getter
    @EqualsAndHashCode(callSuper = false)
    public static class ValidationException extends RuntimeException {

        private final String description;
        private final Timestamp currentTimestamp = TimeHelper.currentTimestamp();

        public static final int CODE = 2000;
        public static final String MESSAGE = "studentError";

        public ValidationException(String description) {
            super(description);

            this.description = description;
        }
    }

}
