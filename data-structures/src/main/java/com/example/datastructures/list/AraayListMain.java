package com.example.datastructures.list;

import java.util.ArrayList;
import java.util.List;

public class AraayListMain {

public static void main(String[] args) {


    List<String> names = new ArrayList<>();
    List<String> surnames = new ArrayList<>();

    names.add("Ahmed");
    names.add("Bob");
    names.add("Mohamed");
    names.add("Jimmy");
    names.set(1,"Ronaldo");
    names.add(2,"Mahmoud");

    surnames.add("Olise");
    surnames.add("ali");
    names.addAll(surnames);

    System.out.println(names);



    }
}
