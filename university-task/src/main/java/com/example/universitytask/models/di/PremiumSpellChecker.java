package com.example.universitytask.models.di;

public class PremiumSpellChecker implements SpellChecker {

    private final String ownerName;
    private final String version;

    public PremiumSpellChecker(String ownerName, String version) {
        this.ownerName = ownerName;
        this.version = version;
    }

    @Override
    public String getBeanName() {
        return "";
    }
}
