package com.example.designpatterns.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public AnimalProcessor(@Qualifier("dogStrategy") AnimalService animalService) {
        this.animalService = animalService;
        log.debug("AnimalProcessor is bean [{}]", animalService.getClass().getSimpleName());
    }

    public void feedAnimal() {
        animalService.feed();
    }

    public void makeSound() {
        animalService.makeSound();
    }

}
