package com.example.designpatterns.strategy;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DogStrategy implements AnimalService {


    private static final Animals DOG = Animals.Dog;
    private final UUID currentUUID = UUID.randomUUID();

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

    public UUID currentUUID() {
        return currentUUID;
    }
}
