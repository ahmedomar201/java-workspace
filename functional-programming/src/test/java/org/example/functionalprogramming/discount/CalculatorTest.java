package org.example.functionalprogramming.discount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CalculatorTest {

    private Calculator calculator;

//    @ParameterizedTest
//    @ValueSource
//    void assertNameNotNull(String name){
//        assertNotNull(name);
//    }

    @ParameterizedTest
    @CsvSource({
            "1, 3, 4",
            "-1, -3, -4",
            "0, 3, 3",
            "3, 0, 3",
            "0, -3, -3",
            "-3, 0, -3",
            "0, 0, 0"
    })
    void testAddNumbers(int num1, int num2, int expectedValue) {
        // Action
        final int actualValue = calculator.add(num1, num2);

        // Assertion
        assertEquals(expectedValue, actualValue);
    }



//    @BeforeEach
//    void init() {
//        calculator = new Calculator();
//    }

    @Test
    void AddTwoPositiveNumbers() {

        final int addValue = calculator.add(1, 2);

        assertEquals(3, addValue);
    }

    @Test
    void AddTwoSubtractNumbers() {

        final int addValue = calculator.subtract(1, 2);

        assertEquals(4, addValue);
    }

    @Test
    void AddTwoMultiplyNumbers() {

        final int addValue = calculator.multiply(1, 2);

        assertEquals(4, addValue);
    }
}
