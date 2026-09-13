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

    public void feedAnimal(final String type) throws Animals.AnimalException {
        getFirstAnimalService(animalService, type)
                .ifPresentOrElse(AnimalService::feed, () -> {
                            log.error("AnimalProcessor1.feedAnimal: type [{}] is invalid", type);
                            throw new Animals.AnimalException(
                                    "AnimalProcessor1.feedAnimal: type [" + type + "] is invalid");
                        }
                );
    }


    public void makeSound(final String type) throws Animals.AnimalException {
        getFirstAnimalService(animalService, type)
                .ifPresentOrElse(AnimalService::makeSound, () -> {
                            log.error("AnimalProcessor1.makeSound: type [{}] is invalid", type);
                            throw new Animals.AnimalException(
                                    "AnimalProcessor1.makeSound: type [" + type + "] is invalid");
                        }
                );
    }

    private static Optional<AnimalService> getFirstAnimalService(
            final List<AnimalService> animalServiceList,
            final String type
    ) {
        return animalServiceList
                .stream()
                .filter(animalService -> animalService.isType(type))
                .findFirst();
    }

}
