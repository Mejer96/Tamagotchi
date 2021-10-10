package com.company;


import java.util.Timer;

public class Main {

    public static void main(String[] args) {
        boolean whileLoop = true;
        Timer myTimer = new Timer();
        int userInputCreator = GameClass.createTamagotchi();
        String userInputName = GameClass.enterName();
        Cat cat = new Cat(userInputName);
        Dog dog = new Dog(userInputName);

        while (whileLoop) {

            if (userInputCreator == 1) {
                int[] arrayNumbers = {1, 2, 3, 4, 5};
                String[] arrayAction = {"feed", "sleep", "pet", "sell", "show stats"};

                if (cat.hunger <= 0) {
                    cat.die();
                    whileLoop = false;
                    cat.cancelTimer();
                    break;
                }

                int gameMenuChoice = GameClass.gameMenu(arrayAction, arrayNumbers);
                // method to start timer and timertask:
                cat.timer();


                // return true if player decides to sell their tamagotchi.
                boolean isSold = cat.runMethods(gameMenuChoice);
                if (isSold) {
                    whileLoop = false;
                    cat.cancelTimer();
                    break;
                }
            } else {
                int[] arrayNumbers = {1, 2, 3, 4, 5, 6};
                String[] arrayAction = {"feed", "sleep", "pet", "sell", "go to park", "show stats"};

                if (dog.hunger <= 0) {
                    dog.die();
                    whileLoop = false;
                    dog.cancelTimer();
                    break;
                }

                int gameMenuChoice = GameClass.gameMenu(arrayAction, arrayNumbers);
                // method to start timer and timertask:
                dog.timer();

                // return true if player decides to sell their tamagotchi.
                boolean isSold = dog.runMethods(gameMenuChoice);
                if (isSold) {
                    whileLoop = false;
                    dog.cancelTimer();
                    break;
                }
            }
        }
        // programmet sluttede ikke efter, at whileLoop'et blev brudt af én eller anden årsag? Derfor system.exit.
        System.exit(0);
    }
}
