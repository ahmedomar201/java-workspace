package com.example.universitytask.models.dtos.responses;

import java.util.Objects;

public class GenericResponse<T> {

    private final String name;
    private final T body;

    public GenericResponse(String name, T body) {
        this.name = name;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public T getBody() {
        return body;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GenericResponse<?> that)) return false;
        return Objects.equals(name, that.name) && Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, body);
    }

    @Override
    public String toString() {
        return "GenericResponse{" +
                "name='" + name + '\'' +
                ", body=" + body +
                '}';
    }
}
