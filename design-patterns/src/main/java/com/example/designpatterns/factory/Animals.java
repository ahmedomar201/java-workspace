package com.example.designpatterns.factory;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Array;
import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Animals {

    Lion("lion"),
    Dog("dog");
    private final String type;


    public static Animals fromType(final String type) throws IllegalArgumentException {

        Arrays.stream(Animals.values()).filter(animals -> type.equalsIgnoreCase(animals.getType()))
        for (Animals animals : Animals.values()) {
            if (type.equalsIgnoreCase(animals.getType())) {
                return animals;
            }
        }

        throw new IllegalArgumentException("No such animals with type " + type);
    }
}
