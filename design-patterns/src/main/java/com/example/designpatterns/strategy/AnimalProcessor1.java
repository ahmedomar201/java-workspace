package com.example.designpatterns.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component

//delegator class
public class AnimalProcessor1 {

    //constructor injection
    private final List<AnimalService> animalService;

    @Autowired
    public AnimalProcessor1(List<AnimalService> animalService) {
        this.animalService = animalService;
        log.debug("AnimalProcessor is bean [{}]", animalService.getClass().getSimpleName());
    }

    //AnimalProcessor1 Delegate any animal class (DogStrategy,LionStrategy) to feed or makeSound
    public void feedAnimal(final Animals animals) throws Animals.AnimalException {
        getFirstAnimalService(animalService, animals)
                .ifPresentOrElse(AnimalService::feed, () -> {
                            log.error("AnimalProcessor1.feedAnimal: type [{}] is invalid", animals);
                            throw new Animals.AnimalException(
                                    "AnimalProcessor1.feedAnimal: type [" + animals + "] is invalid");
                        }
                );
    }


    public void makeSound(final Animals animals) throws Animals.AnimalException {
        getFirstAnimalService(animalService, animals)
                .ifPresentOrElse(AnimalService::makeSound, () -> {
                            log.error("AnimalProcessor1.makeSound: type [{}] is invalid", animals);
                            throw new Animals.AnimalException(
                                    "AnimalProcessor1.makeSound: type [" + animals + "] is invalid");
                        }
                );
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
