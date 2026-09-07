package com.example.designpatterns.factory;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Lion implements AnimalService {

    @Override
    public void feed() {
        log.info("🍗🍗🍗🍗🍗🍗🍗🍗🍗🍗🍗🍗");
    }

    @Override
    public void makeSound() {
        log.info("🦁🦁🦁🦁🦁🦁🦁🦁🦁🦁🦁🦁");
    }
}
