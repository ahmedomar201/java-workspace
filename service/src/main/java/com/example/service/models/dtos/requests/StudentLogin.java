package com.example.service.models.dtos.requests;

public record StudentLogin(String email, String password) {

    @Override
    public String toString() {
        return "StudentLogin{" +
                "email='" + email + '\'' +
                ", password=**********" +
                '}';
    }
}