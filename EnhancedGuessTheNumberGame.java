/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.enhancedguessthenumbergame;
import java.util.Scanner;
import java.util.Random;

public class EnhancedGuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to the Enhanced Guess the Number Game!");

        while (playAgain) {
            System.out.println("Select a difficulty level:");
            System.out.println("1. Easy (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard (1-200, 5 attempts)");
            System.out.print("Enter your choice (1, 2, or 3): ");
            int difficulty = scanner.nextInt();

            int maxRange = 50, maxAttempts = 10;
            switch (difficulty) {
                case 2:
                    maxRange = 100; maxAttempts = 7; break;
                case 3:
                    maxRange = 200; maxAttempts = 5; break;
                default:
                    System.out.println("Easy mode selected by default.");
            }

            int numberToGuess = random.nextInt(maxRange) + 1;
            int numberOfTries = 0;
            boolean guessedCorrectly = false;

            System.out.println("I'm thinking of a number between 1 and " + maxRange + ". Try to guess it!");

            while (!guessedCorrectly && numberOfTries < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                numberOfTries++;

                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                    if (Math.abs(guess - numberToGuess) <= 10) {
                        System.out.println("Hint: You're getting warmer!");
                    }
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                    if (Math.abs(guess - numberToGuess) <= 10) {
                        System.out.println("Hint: You're getting warmer!");
                    }
                } else {
                    guessedCorrectly = true;
                    System.out.println("Correct! You guessed it in " + numberOfTries + " attempts.");
                    System.out.println("Your score: " + ((maxAttempts - numberOfTries) * 10));
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}

