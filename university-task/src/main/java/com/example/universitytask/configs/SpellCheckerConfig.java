package com.example.universitytask.configs;

import com.example.universitytask.models.di.PremiumSpellChecker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpellCheckerConfig {

    @Value("${spell.checker.ownerName}")
    private String ownerName;
    @Value("${spell.checker.version}")
    private String version;

    @Bean(name = "basmaSpellChecker")
    public PremiumSpellChecker premiumSpellChecker() {
        System.out.println("Creating Premium Spell Checker bean with bean name: basmaSpellChecker and owner name: "
                + ownerName + ", version: " + version);
        return new PremiumSpellChecker(ownerName, version);
    }
}
