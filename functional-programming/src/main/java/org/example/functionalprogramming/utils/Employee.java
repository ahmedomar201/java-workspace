package org.example.functionalprogramming.utils;

public record Employee(

        String firstName,
        String secondName,
        int age,
        String email
) {

    public  String buildFullName() {
        return firstName + " " + secondName;
    }
}
