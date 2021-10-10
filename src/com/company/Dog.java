package com.company;

public class Dog extends Tamagotchi {

    public Dog(String name) {
        super(name);
    }

    public void goToPark() {
        mood += 50;

    }

    @Override
    public void sound() {
        System.out.println("Vuf! Vuf! Vuf!");
    }

    @Override
    public void pet() {
        sound();
        System.out.println(name + " Looks so happy right now!");
        mood += 25;
        showMood();
    }

    public boolean runMethods(int userInput) {
        boolean isSold = false;

        if (userInput == 1) {
            feed();
        } else if (userInput == 2) {
            sleep();
        } else if (userInput == 3) {
            pet();
        } else if (userInput == 4) {
            isSold = sell();
        } else if (userInput == 5) {
            goToPark();
        } else if (userInput == 6) {
            showStats();
        }
        return isSold;
    }

}
