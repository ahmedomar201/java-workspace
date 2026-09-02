package com.example.universitytask.configs;

import com.example.universitytask.models.di.PremiumSpellChecker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Slf4j
@Configuration
public class SpellCheckerConfig {

    @Value("${spell.checker.ownerName}")
    private String ownerName;
    @Value("${spell.checker.version}")
    private String version;

    @Bean(name = "basmaSpellChecker")
    public PremiumSpellChecker premiumSpellChecker() {
        log.info("Creating Premium Spell Checker bean with bean name: basmaSpellChecker and owner name: [{}] ,version: [{}] ", ownerName, version);;
        return new PremiumSpellChecker(ownerName, version);
    }
}
