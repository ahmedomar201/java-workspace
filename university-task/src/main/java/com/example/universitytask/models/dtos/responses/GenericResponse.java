package com.example.universitytask.models.dtos.responses;

import java.util.Objects;

public record GenericResponse<T>(String name, T body) {}
