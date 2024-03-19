package Assignment1;

import java.util.Scanner;

public class EmailValidationApplication {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";

    public static boolean isValidEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an email address: ");
        String email = scanner.nextLine();
        scanner.close();

        if (isValidEmail(email)) {
            System.out.println("Email is valid");
        } else {
            System.out.println("Email is not valid");
        }
    }
}
