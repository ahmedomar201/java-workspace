package com.example.universitytask.models.dtos.requests;

import com.example.universitytask.models.di.PaidSpellChecker;
import com.example.universitytask.models.di.SpellChecker;
import com.example.universitytask.models.di.Student;
import com.example.universitytask.models.di.TextEditor;

public class Main {
    public static void main(String[] args) {

        Address address =new Address("slam","helwan","Cairo",12345);
        Address2 address2 =new Address2("slam","helwan","Cairo",12345);
//
//        address.setStreet("slam");
//        address.setCity("helwan");
//        address.setState("Cairo");
//        address.setZip(12345);

        System.out.println(address);
        System.out.println("address2.getStreet:"+address2.street());
        System.out.println("address2.getCity:"+address2.city());
        System.out.println("address2.getState:"+address2.state());
        System.out.println("address2.getZip:"+address2.zip());

    }
}
