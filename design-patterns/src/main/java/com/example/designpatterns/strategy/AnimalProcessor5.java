package com.example.designpatterns.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AnimalProcessor5 {

    //constructor injection
    private final ObjectProvider<AnimalService> animalServiceProvider;

    @Autowired
    public AnimalProcessor5(@Qualifier("dogStrategy") ObjectProvider<AnimalService> animalServiceProvider) {
        this.animalServiceProvider = animalServiceProvider;
    }

    public void feedAnimal(final Animals animal) throws Animals.AnimalException {
        animalServiceProvider.getObject().feed();

        log.debug("Object UUID: [{}]", ((DogStrategy) animalServiceProvider.getObject()).currentUUID());
    }

    public void makeSound(final Animals animal) throws Animals.AnimalException {
        animalServiceProvider.getObject().makeSound();
    }
}