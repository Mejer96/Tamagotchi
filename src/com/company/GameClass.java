package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameClass {

    public static int createTamagotchi() {
        // returns 1 if user wants to create a cat.
        // return 2 if user wants to create a dog.
        Scanner scanner = new Scanner(System.in);
        boolean whileLoop = true;
        int userInput = 0;

        System.out.println("What animal would you like to create?\n Press 1 for cat and 2 for dog.");

        while (whileLoop) {

            System.out.print(">");

            try {
                userInput = scanner.nextInt();
            } catch (InputMismatchException e) {
                // catches situations where the user does not input an integer.
                System.out.println("Invalid value. Try again. Type '1' for cat and '2' for dog.");
                continue;
            }

            if (userInput == 1 || userInput == 2) {
                whileLoop = false;
            } else {
                System.out.println("Invalid value. Try again. Type '1' for cat and '2' for dog");
            }
        }
        return userInput;
    }

    public static int gameMenu(String[] arrayActions, int[] arrayNumbers) {
        // takes two arrays consisting of numbers and strings and creates the game menu using the elements.
        // index for arrayActions and arrayNumbers has to correlate to get expected outcome.
        boolean whileLoop = true;
        int userInput = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("What would u like to do?");

        while (whileLoop) {
            for (int i = 0; i < arrayActions.length; i++) {
                System.out.println("Press " + arrayNumbers[i] + " to " + arrayActions[i] + ".");
            }
            System.out.print(">");
            try {
            userInput = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid value. Try again.");
                continue;

            }
            for (int i = 0; i <= arrayActions.length ; i++) {
                if (userInput == arrayNumbers[i]) {
                    whileLoop = false;
                    break;
                }
            }
            if (whileLoop) {
                System.out.println("Invalid value. Try again.");
            }
        }
        return userInput;
    }

    public static String enterName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a name for your tamagotchi:");
        System.out.print(">");
        String userInput = scanner.nextLine();

        return userInput;
    }

}
