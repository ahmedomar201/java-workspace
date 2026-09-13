package com.example.designpatterns.strategy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Animals {

    Lion("lion"),
    Dog("dog"),
    Cat("cat");
    private final String type;


    public static Animals fromType(final String type) throws AnimalException {

        return Arrays.stream(Animals.values())
                .filter(animals -> animals.hasType(type))
                .findFirst().orElseThrow(() ->
                        new AnimalException(type + " is not listed in our system"));
    }

    private boolean hasType(final String type) {
        return this.getType().equalsIgnoreCase(type);
    }

    public boolean hasType(final Animals animals) {
        return this.getType().equalsIgnoreCase(animals.getType());
    }

    public static class AnimalException extends RuntimeException {
        public AnimalException(String message) {
            super(message);
        }
    }

}

