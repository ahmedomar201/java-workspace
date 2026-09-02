package com.example.universitytask.models.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class TextEditor {
    private static  final Logger log = LoggerFactory.getLogger(TextEditor.class);
    private SpellChecker spellChecker;

    // Tightly coupled
    public TextEditor() {
        log.info("Creating the DB connector bean!!");
//        this.spellChecker = new FreeSpellChecker();
    }

    // Loosely coupled
    /*@Autowired
    public TextEditor(SpellChecker spellChecker) {
        System.out.println("I am in the parameterized constructor of TextEditor");
        this.spellChecker = spellChecker;
    }*/

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    @Autowired
    @Qualifier(value = "paidSpellChecker")
    public void setSpellChecker(SpellChecker spellChecker) {
        log.info("Setting Spell Checker[{}]",spellChecker.getBeanName());
        log.info("I am in the setSpellChecker");
        this.spellChecker = spellChecker;
    }
}
