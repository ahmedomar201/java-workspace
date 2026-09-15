package com.example.designpatterns.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
//delegator class
public class AnimalProcessor4 {

    //constructor injection
    private final List<AnimalService> animalServices;


    public AnimalProcessor4(ApplicationContext applicationContext) {
        animalServices = applicationContext
                .getBeansOfType(AnimalService.class)
                .values()
                .stream()
                .toList();
    }

    //AnimalProcessor1 Delegate any animal class (DogStrategy,LionStrategy) to feed or makeSound
    public void feedAnimal(final Animals animals) throws Animals.AnimalException {
        animalServices
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

        animalServices
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
