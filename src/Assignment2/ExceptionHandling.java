package Assignment2;

import java.util.Scanner;

public class ExceptionHandling {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";

    public static boolean isValidEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter an email address: ");
            String email = scanner.nextLine();
            if (email.length() <= 0) {
                throw new IllegalArgumentException("Email cannot be empty");
            }
            if (!isValidEmail(email)) {
                throw new IllegalArgumentException("Email is not valid");
            }
            System.out.println("Email is valid");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            scanner.close();
        }
    }
}
