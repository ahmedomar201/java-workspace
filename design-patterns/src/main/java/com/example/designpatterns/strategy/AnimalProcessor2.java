package com.example.designpatterns.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
//delegator class
public class AnimalProcessor2 {

    //constructor injection
    private final Map<Animals, AnimalService> animalService;

    @Autowired
    public AnimalProcessor2(List<AnimalService> animalServices) {
        this.animalService = Arrays.stream(Animals.values())
                .collect(Collectors.toUnmodifiableMap(
                        animal -> animal,
                        animal -> getFirstAnimalService(animalServices, animal)
                                .orElseThrow(() -> new IllegalStateException(
                                        "No AnimalService found for animal type: " + animal
                                ))
                ));
    }

    //AnimalProcessor1 Delegate any animal class (DogStrategy,LionStrategy) to feed or makeSound
    public void feedAnimal(final Animals animals) throws Animals.AnimalException {
        getAnimalService(animalService, animals)
                .ifPresentOrElse(AnimalService::feed, () -> {
                            log.error("AnimalProcessor1.feedAnimal: type [{}] is invalid", animals);
                            throw new Animals.AnimalException(
                                    String.format("[%s]: type [%s] is invalid", animals.getType())
                            );
                        }
                );
    }


    public void makeSound(final Animals animals) throws Animals.AnimalException {
        getAnimalService(animalService, animals)
                .ifPresentOrElse(AnimalService::makeSound, () -> {
                            log.error("AnimalProcessor1.makeSound: type [{}] is invalid", animals);
                            throw new Animals.AnimalException(
                                    String.format("[%s]: type [%s] is invalid", animals.getType())
                            );
                        }
                );
    }

    private static Optional<AnimalService> getAnimalService(
            final Map<Animals, AnimalService> animalServices,
            final Animals animal
    ) {
        return Optional.ofNullable(animalServices.get(animal));
    }

    private static Optional<AnimalService> getFirstAnimalService(
            final List<AnimalService> animalServiceList,
            final Animals animals
    ) {
        return animalServiceList
                .stream()
                .filter(animalService -> animalService.isType(animals))
                .findFirst();
    }

}
