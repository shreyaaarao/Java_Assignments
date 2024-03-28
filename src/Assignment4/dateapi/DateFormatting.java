package Assignment4.dateapi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatting {
    public static void main(String[] args) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Define the desired date pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        // Format the current date
        String formattedDate = currentDate.format(formatter);

        // Print the formatted date
        System.out.println("Formatted Date: " + formattedDate);
    }
}

