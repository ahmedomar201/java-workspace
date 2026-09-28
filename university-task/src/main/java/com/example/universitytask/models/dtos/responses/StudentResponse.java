package com.example.universitytask.models.dtos.responses;

import java.util.UUID;

public record StudentResponse(
        String fullName,
        int age,
        String email,
        UUID id
) {


}
