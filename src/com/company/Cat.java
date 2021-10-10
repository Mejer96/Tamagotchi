package com.company;

public class Cat extends Tamagotchi {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("Meoow!");
    }

    @Override
    public void pet() {
        sound();
        System.out.println(name + " Looks very pleased and is purring");
        mood += 25;
        showMood();
    }

    @Override
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
            showStats();
        }
        return isSold;
    }
}
