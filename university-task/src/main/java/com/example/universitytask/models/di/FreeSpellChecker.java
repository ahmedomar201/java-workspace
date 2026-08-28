package com.example.universitytask.models.di;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

// beanName = "freeSpellChecker"
@Primary
@Service
public class FreeSpellChecker implements SpellChecker {
    private final String beanName = "freeSpellChecker";

    @Override
    public String getBeanName() {
        return beanName;
    }
}
