package com.example.designpatterns.strategy;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DogStrategy implements AnimalService {


    private static final Animals DOG = Animals.Dog;

    @Override
    public boolean isType(final Animals animals) {
        return DOG.hasType(animals);
    }

    public DogStrategy() {
        log.debug("DogStrategy is bean");
    }

    @Override
    public void feed() {
        log.info("🦴🦴🦴🦴🦴🦴🦴🦴🦴🦴🦴🦴");
    }

    @Override
    public void makeSound() {
        log.info("🦮🦮🦮🦮🦮🦮🦮🦮🦮🦮🦮🦮");
    }
}
