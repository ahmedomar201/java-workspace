package com.example.universitytask.models.dtos.responses;

import java.util.Objects;
import java.util.UUID;

public class StudentResponse {

    private final String fullName;
    private final int age;
    private final String email;
    private final UUID id;

    public StudentResponse(String fullName, int age, String email, UUID id) {
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentResponse that = (StudentResponse) o;
        return age == that.age &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, age, email, id);
    }

    @Override
    public String toString() {
        return "StudentResponse{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
//                ", id=" + id +
                '}';
    }
}
