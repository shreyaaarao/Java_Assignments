package Assignment3;

import java.util.Scanner;

public class Calculator {

    interface Operation {
        double apply(double operand1, double operand2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        System.out.print("Enter first operand: ");
        double operand1 = scanner.nextDouble();

        System.out.print("Enter second operand: ");
        double operand2 = scanner.nextDouble();

        double result;
        switch (operator) {
            case '+':
                result = performOperation(operand1, operand2, (a, b) -> a + b);
                break;
            case '-':
                result = performOperation(operand1, operand2, (a, b) -> a - b);
                break;
            case '*':
                result = performOperation(operand1, operand2, (a, b) -> a * b);
                break;
            case '/':
                result = performOperation(operand1, operand2, (a, b) -> {
                    if (b == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    return a / b;
                });
                break;
            default:
                System.out.println("Invalid operator");
                return;
        }

        System.out.println("Result: " + result);
    }

    private static double performOperation(double operand1, double operand2, Operation operation) {
        return operation.apply(operand1, operand2);
    }
}

