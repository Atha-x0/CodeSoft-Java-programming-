import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 1;
        int max = 100;
        int targetNumber = generateRandomNumber(min, max);
        int attemptsLimit = 10;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've selected a number between " + min + " and " + max + ". Try to guess it!");

        for (int attempts = 1; attempts <= attemptsLimit; attempts++) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number (" + targetNumber + ")!");
                break;
            } else if (userGuess < targetNumber) {
                System.out.println("Too low! Try a higher number.");
            } else {
                System.out.println("Too high! Try a lower number.");
            }

            if (attempts == attemptsLimit) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + targetNumber + ".");
            }
        }

        scanner.close();
        System.out.println("Thanks for playing! Have a great day!");
    }

    private static int generateRandomNumber(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }
}
