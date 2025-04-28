package org.isep.cleancode.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static String expression;
    private static List<Double> numbers = new ArrayList<>();
    private static List<Character> operators = new ArrayList<>();

    public static double evaluateMathExpression(String expressionStr) {
        expression = expressionStr;
        convertExpressionIntoSequences();

        System.out.println(numbers);
        System.out.println(operators);

        calculatePriorities();
        calculateAll();

        return numbers.get(0);
    }

    static void convertExpressionIntoSequences() {
        double currentNumber = 0;

        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);

            if (Character.isDigit(character)) {
                currentNumber = parseNumber(character, currentNumber);

            } else {
                numbers.add(currentNumber);
                currentNumber = 0;
                operators.add(character);
            }
        }

        // Add the last number to the list
        if (Character.isDigit(expression.charAt(expression.length() - 1))) {
            numbers.add(currentNumber);
        }
    }

    static double parseNumber(char character, double currentNumber) {
        return currentNumber * 10 + Character.getNumericValue(character);
    }

    static void calculatePriorities() {
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == '*' || operators.get(i) == '/') {
                calcul(i);
                i--;
            }
        }
    }

    static void calculateAll() {
        while (!operators.isEmpty()) {
            calcul(0);
        }
    }

    static void calcul(int i) {
        double result = i;
        double a = numbers.get(i);
        double b = numbers.get(i + 1);

        switch (operators.get(i)) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            default:
                break;
        }

        numbers.set(i, result);
        numbers.remove(i + 1);
        operators.remove(i);

        System.out.println(numbers);
        System.out.println(operators);
    }
}
