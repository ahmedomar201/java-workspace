package com.example.designpatterns.factory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("animal")
public class AnimalController {


    @GetMapping("feed/{animalName}")
    public String feedApi(@PathVariable String animalName) {


        try {
            final Animals animals = Animals.fromType(animalName);
            final AnimalService animalService = AnimalFactory.retrieveAnimal(animals);
            animalService.feed();
        } catch (Animals.AnimalException e) {
            throw new RuntimeException(e);
        }

        return "Successfully feed " + animalName;
    }


    @GetMapping("makeSound/{animalName}")
    public String makeSoundApi(@PathVariable String animalName) {
        try {
            final Animals animals = Animals.fromType(animalName);
            final AnimalService animalService = AnimalFactory.retrieveAnimal(animals);
            animalService.makeSound();
        } catch (Animals.AnimalException e) {
            throw new RuntimeException(e);
        }

        return "Successfully makeSound " + animalName;
    }
}
