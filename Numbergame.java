package Numbergame;

import java.util.Random;
import java.util.Scanner;

public class Numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerLimit = 15;
        int upperLimit = 50;
        int maxattempts = 7;
        int roundsWon = 0;
        
        System.out.println("ALL THE BEST AND ENJOY YOUR NUMBER GUESSING GAME!");

        while (true) {
            int secretNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            int attempts = 0;

            System.out.println("\nNew Round!");
            System.out.println("You have " + maxattempts + " attempts.");

            while (attempts < maxattempts) {
                System.out.print("Guess the number between " + lowerLimit + " and " + upperLimit + ": ");
                int usernum = scanner.nextInt();
                attempts++;

                if (usernum < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (usernum > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number, which is " + secretNumber + ".");
                    roundsWon++;
                    break;
                }
            }

            if (attempts >= maxattempts) {
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
