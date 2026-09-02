package com.example.universitytask.models.dtos.requests;


public record StudentUpdate(String firstName, String secondName, int age, String email, String password, float score) {


    @Override
    public String toString() {
        return "StudentUpdate{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password=**********" +
                ", score=" + score +
                '}';
    }
}
