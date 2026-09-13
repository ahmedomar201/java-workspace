package com.example.designpatterns.strategy;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CatStrategy implements AnimalService {


    private static final Animals CAT = Animals.Cat;

    @Override
    public boolean isType(final Animals animals) {
        return CAT.hasType(animals);
    }

    public CatStrategy() {
        log.debug("CatStrategy is bean");
    }

    @Override
    public void feed() {
        log.info("🍕🍕🍕🍕🍕🍕🍕🍕🍕🍕🍕🍕");
    }

    @Override
    public void makeSound() {
        log.info("🦮🦮🦮🦮🦮🦮🦮🦮🦮🦮🦮🦮");
    }
}
