package com.example.universitytask.models.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class TextEditor {
    private SpellChecker spellChecker;

    // Tightly coupled
    public TextEditor() {
        System.out.println("I am in the empty constructor of TextEditor");
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
        System.out.println("spellChecker.getBeanName() = " + spellChecker.getBeanName());
        System.out.println("I am in the setSpellChecker");
        this.spellChecker = spellChecker;
    }
}
