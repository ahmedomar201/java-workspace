package com.example.designpatterns.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
//delegator class
public class AnimalProcessor {

    //AnimalProcessor Delegate AnimalService
    //AnimalService Delegate class

    //constructor injection
    private final List<AnimalService> animalService;

    @Autowired
    public AnimalProcessor(List<AnimalService> animalService) {
        this.animalService = animalService;
        log.debug("AnimalProcessor is bean [{}]", animalService.getClass().getSimpleName());
    }

    public void feedAnimal(final String type) {
        animalService.stream().filter(
                        animalService -> animalService.isType(type))
                .findFirst()
                .ifPresent(AnimalService::feed);
    }

    public void makeSound(final String type) {
        animalService.stream().filter(
                        animalService -> animalService.isType(type))
                .findFirst()
                .ifPresent(AnimalService::makeSound);
    }

}
