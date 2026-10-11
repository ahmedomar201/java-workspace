package com.example.universitytask.utills.validators.custominterface;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {AgeValidator.class})
public @interface Age {
    byte min() default 0;
    byte max() default Byte.MAX_VALUE;

    String message() default "{Age is incompatible}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
