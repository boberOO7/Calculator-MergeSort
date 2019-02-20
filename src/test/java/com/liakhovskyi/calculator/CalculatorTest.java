package com.liakhovskyi.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.liakhovskyi.calculator.Calculator.calculate;
import static org.junit.Assert.*;
import static com.liakhovskyi.calculator.ConvertingToDecimal.convertToDecimal;
import static com.liakhovskyi.calculator.ConvertingToRoman.convertToRoman;

@RunWith(JUnit4.class)
public class CalculatorTest {

    @Test
    public void testCalculatorResultOfTwoArabicNumbers() {
        double firstNumber = 10;
        double secondNumber = 10;

        char operation = '+';

        double expectedResult = 20;
        double actualResult = calculate(firstNumber, secondNumber, operation);

        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void testCalculatorResultOfTwoNegativeArabicNumbers() {
        double firstNumber = -1;
        double secondNumber = -1;

        char operation = '-';

        double expectedResult = 0;
        double actualResult = calculate(firstNumber, secondNumber, operation);

        assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testCalculatorThrowExceptionDivideByZero() {
        double firstNumber = 100;
        double secondNumber = 0;

        char operation = '/';

        calculate(firstNumber, secondNumber, operation);
    }

    @Test
    public void testCalculatorResultOfTwoRomanNumbers() {
        String firstNumber = "X";
        String secondNumber = "V";

        char operation = '/';

        double tempNumber1 = convertToDecimal(firstNumber);
        double tempNumber2 = convertToDecimal(secondNumber);

        double tempResult = calculate(tempNumber1, tempNumber2, operation);

        String expectedResult = "II";
        String actualResult = convertToRoman((int)tempResult);

        assertEquals(expectedResult, actualResult);
    }
}
