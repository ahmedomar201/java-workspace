package com.example.universitytask.utills.validators;

import com.example.universitytask.utills.times.TimeHelper;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

import static com.example.universitytask.utills.StringUtils.isNullOrBlank;

public final class ValidationRules {
    private static final Map<ValidationItems, ValidatorService<String>> Rules =
            new EnumMap<>(ValidationItems.class);

    static {
        Rules.putIfAbsent(ValidationItems.FIRST_NAME, ValidationRules::isFirstName);
        Rules.putIfAbsent(ValidationItems.SECOND_NAME, ValidationRules::isSecondName);
        Rules.putIfAbsent(ValidationItems.AGE, ValidationRules::isAgeValid);
        Rules.putIfAbsent(ValidationItems.EMAIL, ValidationRules::isEmailValid);
        Rules.putIfAbsent(ValidationItems.PASSWORD, ValidationRules::isPasswordValid);
        Rules.putIfAbsent(ValidationItems.SCORE, ValidationRules::ValidateScore);
    }


    private ValidationRules() {

        throw new AssertionError("Utility class");
    }

    public static void validate(final ValidationItems rule, final String ruleValue) throws RuleException {

        if (isNullOrBlank(ruleValue)) {
            throw new RuleException(rule.name(),"Rule is null or blank");
        }

        final ValidatorService<String> validatorService = findRule(rule).orElseThrow(() ->
                new RuleException(rule.name(),"Rule is null or blank"));

        validatorService.validate(ruleValue);
    }

    private static Optional<ValidatorService<String>> findRule(final ValidationItems rule) {

        return Optional.ofNullable(Rules.get(rule));
    }

    private static void isFirstName(final String firstName) throws RuleException {

        if (firstName.length() < 2 || firstName.length() > 15) {
            throw new RuleException("firstName", "First Name must be between 2 and 15");
        }
    }

    private static void isSecondName(final String secondName) throws RuleException {

        if (secondName.length() < 2 || secondName.length() > 15) {
            throw new RuleException("secondName", "Second Name must be between 2 and 15");
        }
    }

    private static void isAgeValid(final String age) throws RuleException {

        final int intAge = Integer.parseInt(age);
        if (intAge < 18 || intAge > 25) {
            throw new RuleException("age", "Age is incompatible");
        }
    }

    private static void isEmailValid(final String email) throws RuleException {

        if (!email.contains("@") || !email.contains(".")) {
            throw new RuleException("email","Email must be valid");
        }
    }

    private static void isPasswordValid(final String password) throws RuleException {

        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9\\s])\\S{9,31}$")) {
            throw new RuleException("password", "Password doesn't meet the criteria");
        }
    }

    private static void ValidateScore(String score) {
        final float floatScore = Float.parseFloat(score);
        if (floatScore < 50 || floatScore > 100) {
            throw new RuleException("score","Score is not valid");
        }
    }

    @Getter
    @EqualsAndHashCode(callSuper = false)
    public static class RuleException extends RuntimeException {

        private final String message;
        private final String description;

        public RuleException(final String message, final String description) {
            super(description);

            this.message = message;
            this.description = description;
        }
    }

    @Getter
    @EqualsAndHashCode(callSuper = false)
    public static class ValidationException extends RuntimeException {

        private final Map<String, String> errors;

        private final Timestamp currentTimestamp = TimeHelper.currentTimestamp();

        public static final int CODE = 9001;

        public ValidationException(Map<String, String> errors) {
            this.errors = errors;
        }
    }

}
