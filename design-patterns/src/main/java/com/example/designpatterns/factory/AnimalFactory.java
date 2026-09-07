package com.example.designpatterns.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnimalFactory {

    private static final String dog = "dog";
    private static final String lion = "lion";

    public static AnimalService retrieveAnimal(final String type) throws IllegalArgumentException {

        if (dog.equalsIgnoreCase(type)) {
            return new Lion();
        }
        if (lion.equalsIgnoreCase(type)) {
            return new Dog();
        }

        throw new IllegalArgumentException("invalid type");

    }

}
