package com.example.designpatterns.strategy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("animalControllerStrategy")
@RequestMapping("strategy/animal")
public class AnimalController {

    private AnimalProcessor animalProcessor;

    @GetMapping("feed/{animalName}")
    public String feedApi(@PathVariable String animalName) {

        try {
            animalProcessor.feedAnimal();
        } catch (Animals.AnimalException e) {
            throw new RuntimeException(e);
        }

        return "Successfully feed " + animalName;
    }


    @GetMapping("makeSound/{animalName}")
    public String makeSoundApi(@PathVariable String animalName) {

        try {
            animalProcessor.makeSound();
        } catch (Animals.AnimalException e) {
            throw new RuntimeException(e);
        }

        return "Successfully makeSound " + animalName;
    }
}
