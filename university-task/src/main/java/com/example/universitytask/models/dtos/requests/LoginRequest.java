package com.example.universitytask.models.dtos.requests;

import java.util.Objects;

public class LoginRequest {

    private final  String userName;
    private final String password;

    public LoginRequest(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LoginRequest that = (LoginRequest) o;
        return Objects.equals(userName, that.userName) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
