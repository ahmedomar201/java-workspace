package com.example.universitytask.models.entities;

import java.util.Objects;
import java.util.UUID;

public class Student {
    private  UUID id;
    private  String fullName;
    private  String email;
    private  String password;
    private  String age;
    private  boolean isLogin;
    private  float score;
    private  float finalScore;

    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAge() {
        return age;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public float getScore() {
        return score;
    }

    public float getFinalScore() {
        return finalScore;
    }


    public void setId(UUID id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void setFinalScore(float finalScore) {
        this.finalScore = finalScore;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return isLogin == student.isLogin
                && Float.compare(score, student.score) == 0
                && Float.compare(finalScore, student.finalScore) == 0
                && Objects.equals(id, student.id)
                && Objects.equals(fullName, student.fullName)
                && Objects.equals(email, student.email)
                && Objects.equals(password, student.password)
                && Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email, password, age, isLogin, score, finalScore);
    }


    @Override
    public String toString() {
        return "Student{" +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password=********" +
                ", age='" + age + '\'' +
                ", isLogin=" + isLogin +
                ", score=" + score +
                ", finalScore=" + finalScore +
                '}';
    }
}
