package com.example.universitytask.models.dtos.responses;


public record GenericResponse<T>(String name, T body) {}
