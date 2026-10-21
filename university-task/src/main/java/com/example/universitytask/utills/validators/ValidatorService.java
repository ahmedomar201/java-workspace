package com.example.universitytask.utills.validators;

@FunctionalInterface
public interface ValidatorService<T> {

    void validate(T t);
}
