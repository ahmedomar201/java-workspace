package com.example.designpatterns.strategy;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DogStrategy implements AnimalService {


    private final String type = "dog";

    @Override
    public boolean isType(final String type) {
        return this.type.equalsIgnoreCase(type);
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
