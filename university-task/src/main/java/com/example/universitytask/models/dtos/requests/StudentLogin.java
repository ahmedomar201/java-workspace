package com.example.universitytask.models.dtos.requests;

import java.util.Objects;

public class StudentLogin {

    private final String email;
    private final String password;
    private final boolean isLoggedIn;

    public StudentLogin(String email, String password, boolean isLoggedIn) {
        this.email = email;
        this.password = password;
        this.isLoggedIn = isLoggedIn;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentLogin that = (StudentLogin) o;
        return isLoggedIn == that.isLoggedIn && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, isLoggedIn);
    }

    @Override
    public String toString() {
        return "StudentLogin{" +
                "email='" + email + '\'' +
                ", password=**********" +
                ", isLoggedIn=" + isLoggedIn +
                '}';
    }
}
