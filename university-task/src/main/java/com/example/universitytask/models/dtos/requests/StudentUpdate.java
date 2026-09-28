package com.example.universitytask.models.dtos.requests;

public record StudentUpdate(
        String firstName,
        String secondName,
        int age,
        String email,
        String password,
        float score
) {

}
