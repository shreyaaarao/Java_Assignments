package Assignment4.dateapi;

import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input date from the user
        System.out.print("Enter a date (YYYY-MM-DD): ");
        String inputDateStr = scanner.nextLine();

        // Parse the input date
        LocalDate inputDate = LocalDate.parse(inputDateStr);

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Compare the dates
        if (inputDate.isEqual(currentDate)) {
            System.out.println("Given date is equal to the current date.");
        } else if (inputDate.isBefore(currentDate)) {
            System.out.println("Given date is before the current date.");
        } else {
            System.out.println("Given date is after the current date.");
        }

        scanner.close();
    }
}

