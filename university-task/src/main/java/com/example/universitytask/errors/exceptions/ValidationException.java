package com.example.universitytask.errors.exceptions;

import com.example.universitytask.utills.times.TimeHelper;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.util.Collection;

@Slf4j
@Getter
@EqualsAndHashCode(callSuper = false)
public class ValidationException extends RuntimeException {
    private  final Collection<String> errors;
    private final String description;

    private final Timestamp currentTimestamp = TimeHelper.currentTimestamp();

    public static final int CODE =1000;
    public static final String MESSAGE="ValidationError";
    public ValidationException(String description, String LogMessage, Collection<String>errors) {
        super(description);

        this.description=description;
        this.errors= errors;

        log.error(LogMessage);
    }
}
