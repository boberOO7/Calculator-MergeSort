package com.liakhovskyi.calculator;

public class ConvertingToRoman {

    private enum RomanNumbers {
        I(1),
        IV(4),
        V(5),
        IX(9),
        X(10),
        XL(40),
        L(50),
        XC(90),
        C(100),
        CD(400),
        D(500),
        CM(900),
        M(1000);

        private int value;

        RomanNumbers(int value) {
            this.value = value;
        }
    }

    public static String convertToRoman(int number) {
        StringBuilder builder = new StringBuilder();

        final RomanNumbers[] values = RomanNumbers.values();
        for (int i = values.length - 1; i >= 0; i--) {
            while (number >= values[i].value) {
                builder.append(values[i]);
                number -= values[i].value;
            }
        }
        return builder.toString();
    }
}
