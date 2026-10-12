package com.example.universitytask.errors.models;

import java.sql.Timestamp;
import java.util.Optional;

public record GenericResponse<T>(
        int code,
        Timestamp timestamp,
        T body
) {

}
