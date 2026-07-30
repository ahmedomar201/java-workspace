package com.example.rest.models.dtos.requests;

import java.util.Objects;

public class StudentRequest {

   private final String name;
   private final String email;
   private final int age;
   private final int id;

    public StudentRequest(String name, String email, int age, int id) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentRequest that = (StudentRequest) o;
        return age == that.age && id == that.id && Objects.equals(name, that.name) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, age, id);
    }


    @Override
    public String toString() {
        return "StudentRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
