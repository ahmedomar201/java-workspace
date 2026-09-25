package com.example.universitytask.models.entities;

import com.example.universitytask.errors.exceptions.LogoutException;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Student {
    private UUID id;
    private String fullName;
    private int age;
    private String email;
    private String password;
    private boolean isLoggedIn;
    private float score;
    private float finalScore;

    public boolean isPassedExam() {
        return (score / finalScore) > 0.5F;
    }

    public void login() {
        isLoggedIn = true;
    }

    public void logout() {
        if (!isLoggedIn) {
            throw new LogoutException("Student not logged in");
        }

        isLoggedIn = false;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password=**********" +
                ", isLoggedIn=" + isLoggedIn +
                ", score=" + score +
                ", finalScore=" + finalScore +
                '}';
    }
}
