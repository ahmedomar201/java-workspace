package com.example.designpatterns.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
//delegator class
public class AnimalProcessor3 {

    //constructor injection
    private final ApplicationContext applicationContext;


    //AnimalProcessor1 Delegate any animal class (DogStrategy,LionStrategy) to feed or makeSound
    public void feedAnimal(final Animals animals) throws Animals.AnimalException {
        applicationContext.getBeansOfType(AnimalService.class)
                .values()
                .stream()
                .filter(animalService -> animalService.isType(animals))
                .findFirst()
                .ifPresentOrElse(AnimalService::feed, () -> {
                            throw new Animals.AnimalException(
                                    "AnimalProcessor1.makeSound: type [" + animals + "] is invalid");
                        }
                );

    }


    public void makeSound(final Animals animals) throws Animals.AnimalException {

        applicationContext.getBeansOfType(AnimalService.class)
                .values()
                .stream()
                .filter(animalService -> animalService.isType(animals))
                .findFirst()
                .ifPresentOrElse(AnimalService::makeSound, () -> {
                            throw new Animals.AnimalException(
                                    "AnimalProcessor1.makeSound: type [" + animals + "] is invalid");
                        }
                );

    }

}
