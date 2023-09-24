package Numbergame;

import java.util.Random;
import java.util.Scanner;

public class Numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerLimit = 1;
        int upperLimit = 20;
        int maxAttempts = 10;
        int roundsWon = 0;
        
        System.out.println("Welcome to the Guessing Game!");

        while (true) {
            int secretNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            int attempts = 0;

            System.out.println("\nNew Round!");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Guess the number between " + lowerLimit + " and " + upperLimit + ": ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number, which is " + secretNumber + ".");
                    roundsWon++;
                    break;
                }
            }

            if (attempts >= maxAttempts) {
                System.out.println("\nYou've run out of attempts. The secret number was " + secretNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("\nGame Over! You won " + roundsWon + " rounds.");
    }
}
