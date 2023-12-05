import java.util.Scanner;

public class lyricInput {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter your geniuslyrics URL");

        // Read user input
        String userInput = scanner.nextLine();

        // Display the user input
        System.out.println("You entered: " + userInput);

        // Close the scanner to avoid resource leaks
        scanner.close();
    }
}