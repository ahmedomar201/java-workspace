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
            final AnimalService animalService = AnimalFactory.retrieveAnimal(animalName);
            animalService.feed();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        return "Successfully feed " + animalName;
    }


    @GetMapping("makeSound/{animalName}")
    public String makeSoundApi(@PathVariable String animalName) {
        try {
            final AnimalService animalService = AnimalFactory.retrieveAnimal(animalName);
            animalService.makeSound();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        return "Successfully makeSound " + animalName;
    }
}
