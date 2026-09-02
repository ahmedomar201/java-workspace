package com.example.universitytask.models.di;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

// beanName = "paidSpellChecker"
@Service
@Slf4j
public class PaidSpellChecker implements SpellChecker {
    private final String beanName = "paidSpellChecker";

    private final String owner = "Tech Pioneers Hub";

    public PaidSpellChecker() {
        log.info("I am in the empty constructor of PaidSpellChecker");
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String getBeanName() {
        return beanName;
    }
}
