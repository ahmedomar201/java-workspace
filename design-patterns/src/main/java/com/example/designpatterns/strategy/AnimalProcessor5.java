package com.example.designpatterns.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
//delegator class
public class AnimalProcessor5 {

    //constructor injection
    private final ObjectProvider<AnimalService> animalServicesProvider;

    @Autowired
    public AnimalProcessor5(ObjectProvider<AnimalService> animalServicesProvider) {
        this.animalServicesProvider = animalServicesProvider;
    }

    public void feedAnimal(final Animals animals) throws Animals.AnimalException {
        animalServicesProvider.getObject().feed();
    }

    public void makeSound(final Animals animals) throws Animals.AnimalException {
        animalServicesProvider.getObject().makeSound();
    }
}