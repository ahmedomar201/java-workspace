package com.example.universitytask.models.dtos.requests;

import com.example.universitytask.models.di.PaidSpellChecker;
import com.example.universitytask.models.di.SpellChecker;
import com.example.universitytask.models.di.Student;
import com.example.universitytask.models.di.TextEditor;

public class Main {
    public static void main(String[] args) {

        Address address =new Address();

        address.setStreet("slam");
        address.setCity("helwan");
        address.setState("Cairo");
        address.setZip(12345);

        System.out.println(address);

    }
}
