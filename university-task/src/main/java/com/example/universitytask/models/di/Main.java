package com.example.universitytask.models.di;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student();
        // Setter Injection
        student1.setName("Mostafa Desouky");
        student1.setAge(24);
        student1.setEmail("mostafa@techpioneershub.com");

        // Constructor Injection
        Student student2 = new Student("Elsayed Feteh", 30, "elsayed@techpioneershu.com");


        SpellChecker spellChecker = new PaidSpellChecker();
//        TextEditor textEditor = new TextEditor(spellChecker);
        TextEditor textEditor = new TextEditor();
        textEditor.setSpellChecker(spellChecker);
    }
}
