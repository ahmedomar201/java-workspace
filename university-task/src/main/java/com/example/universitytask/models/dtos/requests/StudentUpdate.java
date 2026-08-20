package com.example.universitytask.models.dtos.requests;

import java.util.Objects;

public class StudentUpdate {

    private final String firstName;
    private final String secondName;
    private final int age;
    private final String email;
    private final String password;

    public StudentUpdate(String firstName,
                         String secondName,
                         int age,
                         String email,
                         String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentUpdate that = (StudentUpdate) o;
        return age == that.age && Objects.equals(firstName, that.firstName)
                && Objects.equals(secondName, that.secondName)
                && Objects.equals(email, that.email)
                && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, age, email, password);
    }

    @Override
    public String toString() {
        return "StudentUpdate{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password=**********" +
                '}';
    }
}
