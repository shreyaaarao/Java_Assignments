package Assignment1;


import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the type of interest calculation:");
        System.out.println("1. Simple Interest");
        System.out.println("2. Compound Interest");
        System.out.print("Enter your choice (1 or 2): ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                calculateSimpleInterest(scanner);
                break;
            case 2:
                calculateCompoundInterest(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please enter 1 or 2.");
        }

        scanner.close();
    }

    private static void calculateSimpleInterest(Scanner scanner) {
        System.out.println("Enter principal amount:");
        double principal = scanner.nextDouble();

        System.out.println("Enter rate of interest:");
        double rate = scanner.nextDouble();

        System.out.println("Enter time period (in years):");
        int time = scanner.nextInt();

        double simpleInterest = (principal * rate * time) / 100;
        System.out.println("Simple Interest: " + simpleInterest);
    }

    private static void calculateCompoundInterest(Scanner scanner) {
        System.out.println("Enter principal amount:");
        double principal = scanner.nextDouble();

        System.out.println("Enter rate of interest:");
        double rate = scanner.nextDouble();

        System.out.println("Enter time period (in years):");
        int time = scanner.nextInt();

        double compoundInterest = principal * (Math.pow(1 + (rate / 100), time)) - principal;
        System.out.println("Compound Interest: " + compoundInterest);
    }
}
