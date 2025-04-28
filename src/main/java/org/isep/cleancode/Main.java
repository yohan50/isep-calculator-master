package org.isep.cleancode;

import java.util.Scanner;
import org.isep.cleancode.calculator.Calculator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Quelles sont les opérations ?");
        try (Scanner scanner = new Scanner(System.in)) {
            // replaceAll is used to remove spaces
            String expression = scanner.nextLine().replaceAll("\\s+", "");
            double result = Calculator.evaluateMathExpression(expression);
            System.out.println(result);
        }
    }
}