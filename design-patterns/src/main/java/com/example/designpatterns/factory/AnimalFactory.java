package com.example.designpatterns.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnimalFactory {


    public static AnimalService retrieveAnimal(final Animals animals) {

        if (Animals.Dog.equals(animals)) {
            return new Dog();
        }
        return new Lion();

    }

}
