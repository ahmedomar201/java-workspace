package com.example.designpatterns.strategy;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Slf4j
@Primary
@Component
public class LionStrategy implements AnimalService {

    private static final String TYPE = "lion";

    public LionStrategy() {
        log.debug("LionStrategy is bean");
    }

    @Override
    public boolean isType(final String type) {
        return TYPE.equalsIgnoreCase(type);
    }

    @Override
    public void feed() {
        log.info("🍗🍗🍗🍗🍗🍗🍗🍗🍗🍗🍗🍗");
    }

    @Override
    public void makeSound() {
        log.info("🦁🦁🦁🦁🦁🦁🦁🦁🦁🦁🦁🦁");
    }
}
