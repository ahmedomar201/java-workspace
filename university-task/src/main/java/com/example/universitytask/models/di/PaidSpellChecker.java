package com.example.universitytask.models.di;

import org.springframework.stereotype.Service;

// beanName = "paidSpellChecker"
@Service
public class PaidSpellChecker implements SpellChecker {
    private final String beanName = "paidSpellChecker";

    private final String owner = "Tech Pioneers Hub";

    public PaidSpellChecker() {
        System.out.println("I am in the empty constructor of PaidSpellChecker");
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String getBeanName() {
        return beanName;
    }
}
