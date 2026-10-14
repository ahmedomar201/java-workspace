package org.example.functionalprogramming.streams;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {

        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        final int evenNumbers = numbers
                .stream()
                .filter(Main::isEven)
                .reduce(1,Main::multiPly);

        System.out.println("numbers = "+evenNumbers);

    }

    public static int sum(final int num1,final int num2) {

        return num1+num2;

    }

    public static int multiPly(final int num1,final int num2) {

        return num1*num2;

    }


    public static boolean isEven(final int number) {

        return number % 2 == 0;

    }

    public static boolean isOdd(final int number) {

        return number % 2 != 0;

    }
}
