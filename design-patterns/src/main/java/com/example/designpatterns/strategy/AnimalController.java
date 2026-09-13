package com.example.designpatterns.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("animalControllerStrategy")
@RequestMapping("strategy/animal")
public class AnimalController {

    private final AnimalProcessor1 animalProcessor1;

    @Autowired
    public AnimalController(AnimalProcessor1 animalProcessor1) {
        this.animalProcessor1 = animalProcessor1;
    }

    @GetMapping("feed/{animalType}")
    public String feedApi(@PathVariable String animalType) {

        try {
            final Animals animals = Animals.fromType(animalType);

            animalProcessor1.feedAnimal(animals);
        } catch (Animals.AnimalException e) {
            throw new RuntimeException(e);
        }

        return "Successfully feed " + animalType;
    }


    @GetMapping("makeSound/{animalType}")
    public String makeSoundApi(@PathVariable String animalType) {

        try {
            final Animals animals = Animals.fromType(animalType);

            animalProcessor1.makeSound(animals);
        } catch (Animals.AnimalException e) {
            throw new RuntimeException(e);
        }

        return "Successfully makeSound " + animalType;
    }
}
