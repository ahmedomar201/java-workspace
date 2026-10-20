package com.example.universitytask.utills.validators;

@FunctionalInterface
public interface ValidatorService<T> {

    boolean isValid(T t);
}
