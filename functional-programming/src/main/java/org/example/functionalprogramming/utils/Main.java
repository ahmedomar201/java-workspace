package org.example.functionalprogramming.utils;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Calculator calculator=new Calculator();
final int result =ProcessIntegers(calculator::add);


    }

    private static int ProcessIntegers(FirstFunctional functional) {

        return functional.apply(1, 2);
    }

}
