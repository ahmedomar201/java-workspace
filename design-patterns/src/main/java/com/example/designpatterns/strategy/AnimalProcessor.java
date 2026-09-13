package com.example.designpatterns.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//delegator class
public class AnimalProcessor {

    //AnimalProcessor Delegate AnimalService
    //AnimalService Delegate class

    //constructor injection
    private final AnimalService animalService;

    @Autowired
    public AnimalProcessor(AnimalService animalService) {
        this.animalService = animalService;
        log.debug("AnimalProcessor is bean [{}]", animalService.getClass().getSimpleName());
    }

    public void feedAnimal(final String type) {
        animalService.feed();
    }

    public void makeSound(final String type) {
        animalService.makeSound();
    }

}
