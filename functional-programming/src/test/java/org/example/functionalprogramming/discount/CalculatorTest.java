package org.example.functionalprogramming.discount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void AddTwoPositiveNumbers() {

        final int addValue = Calculator.add(1, 2);

        assertEquals(3, addValue);
    }
//    @Test
//    void AddTwoSubtractNumbers() {
//
//        final int addValue = Calculator.subtract(1, 2);
//
//        assertEquals(4, addValue);
//    }
//    @Test
//    void AddTwoMultiplyNumbers() {
//
//        final int addValue = Calculator.multiply(1, 2);
//
//        assertEquals(4, addValue);
//    }
}
