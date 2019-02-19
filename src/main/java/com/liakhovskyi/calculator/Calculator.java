package com.liakhovskyi.calculator;

import static com.liakhovskyi.calculator.ConvertingToDecimal.convertToDecimal;
import static com.liakhovskyi.calculator.ConvertingToRoman.convertToRoman;

import java.util.Scanner;

public class Calculator {
    private static Scanner scanner = new Scanner(System.in);
    private static double number;
    private static String comparator;


    public static void main(String[] args) {
        Calculator numbers = getValue();
        double firstNumber = numbers.getNumber();
        String typeOfFirstNumber = numbers.getComparator();

        numbers = getValue();
        double secondNumber = numbers.getNumber();
        String typeOfSecondNumber = numbers.getComparator();

        double result;
        String finalResult;

        if (compareNumbersType(typeOfFirstNumber, typeOfSecondNumber)) {
            char operation = getOperation();
            result = calculate(firstNumber, secondNumber, operation);
            finalResult = convertToRoman((int) result);
        } else {
            char operation = getOperation();
            result = calculate(firstNumber, secondNumber, operation);
            finalResult = String.valueOf(result);
        }


        System.out.println("Result: " + finalResult);
        /*System.out.println("Result: " + result);
        System.out.println("Value: " + firstNumber);
        System.out.println("Value: " + secondNumber);
        System.out.println("Type: " + typeOfFirstNumber);
        System.out.println("Type: " + typeOfSecondNumber);*/
    }

    public Calculator() {
    }

    public Calculator(double number, String comparator) {
        this.number = number;
        this.comparator = comparator;
    }

    public static double getNumber() {
        return number;
    }

    public static String getComparator() {
        return comparator;
    }

    private static Calculator getValue() {
        double digit;
        String compare;

        System.out.println("Enter number:");
        if (scanner.hasNextDouble()) {
            digit = scanner.nextDouble();
            compare = "Decimal";
        } else {
            String value = scanner.next();
            if (isRoman(value)) {
                digit = convertToDecimal(value);
                compare = "Roman";
            } else {
                System.out.println("Something goes wrong. Please try again.");
                getValue();
                digit = 0;
                compare = "";
            }
        }
        return new Calculator(digit, compare);
    }

    private static char getOperation() {
        System.out.println("Enter operation:");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Something goes wrong. Please try again.");
            operation = getOperation();
        }
        return operation;
    }

    static double calculate(double firstNumber, double secondNumber, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber == 0) {
                    throw new ArithmeticException("Divide by zero!");
                }
                result = firstNumber / secondNumber;
                break;
            default:
                System.out.println("Operation not recognized. Re-enter operation.");
                result = calculate(firstNumber, secondNumber, getOperation());
        }
        return result;
    }

    /*private static boolean isDecimal(String value) {
        return value.matches("-?\\d+\\.?\\d*");
    }*/

    private static boolean isRoman(String value) {
        return value.matches("[MDCLXVI]+");
    }

    private static boolean compareNumbersType(String firstTypeNumber, String secondTypeNumber) {
        if (!firstTypeNumber.equals(secondTypeNumber)) {
            System.out.println("Error: Different types of numbers!");
            System.exit(0);
            return false;
        }
        if (firstTypeNumber.equals(secondTypeNumber) && firstTypeNumber.equals("Roman")) {
            return true;
        }
        return false;
    }
}