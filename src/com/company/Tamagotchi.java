package com.company;

import java.util.Timer;


public abstract class Tamagotchi {
   public String name;
   public int mood;
   public int hunger;
   public int sleepiness;
   Timer newTimer = new Timer();
   NewTimerTask myTimertask = new NewTimerTask() {
       @Override
       public void run() {
           System.out.println("An hour has passed");
           hunger -= 15;
           mood -= 15;
           sleepiness -= 15;
       }
   };

    public Tamagotchi(String name) {
        this.name = name;
        this.mood = 100;
        this.hunger = 100;
        this.sleepiness = 100;
    }

    public abstract void sound();

    public abstract void pet();

    public void showStats() {
        showHunger();
        showMood();
        showSleepiness();
    }

    public void sleep() {
        System.out.println(name + " is now sleeping.");
        sleepiness -= 100;
        showSleepiness();
    }

    public void feed() {
        System.out.println(name + "has been fed!");
        hunger += 50;
        showHunger();

    }

    public boolean sell() {
        System.out.println("Congratulations you managed to find a buyer for " + name + ".");
        System.out.println("Time to order some pizza and buy some beers!");
        return true;
    }

    public boolean die() {
        System.out.println("GAME OVER!");
        System.out.println("Oh no. You have neglected your responsibility and your tamagotchi is now dead. Rest in piece, " + name);
        return true;
    }

    public void showHunger() {

        if (hunger > 100) {
            hunger = 100;
        } else if (hunger <= 0) {
            System.out.println("Oh no. Your tamagotchi is now dead. GAME OVER.");
        }

        System.out.println(hunger);

        if (hunger >= 75 && hunger <= 100) {
            System.out.println(name + " is not hungry");
        }
        if (hunger < 75 && hunger >= 50) {
            System.out.println(name + " is a little hungry rn");
        }
        if (hunger < 50 && hunger >= 25) {
            System.out.println(name + " is hungry.");
        }
        if (hunger < 25 && hunger > 0) {
            System.out.println(name + " is starving. You need to feed it ASAP!");
        }
    }

    public void showSleepiness() {
        if (sleepiness > 100) {
            sleepiness = 100;
        }
        if (sleepiness >= 25 && sleepiness <= 100) {
            System.out.println(name + " is well rested.");
        } else {
            System.out.println(name + " is getting sleepy");
        }
    }

    public void showMood() {
        if (mood > 100) {
            mood = 100;
        }
        if (mood < 0) {
            mood = 0;
        }
        if (mood >= 75 && mood <= 100) {
            System.out.println(name + " is sooooo happy right now!");
        }
        if (mood >= 50 && mood < 75) {
            System.out.println(name + " is happy.");
        }
        if (mood >= 25 && mood < 50) {
            System.out.println(name + " looks a little sad");
        }
        if (mood >= 0 && mood < 25) {
            System.out.println(name + " looks depressed. Go and play!");
        }
    }
    public abstract boolean runMethods(int userInput);

    public void timer() {
        try {
            // myTimerTask.run() gets executed every 20 seconds
        int second = 1000;
        newTimer.schedule(myTimertask, 20*second, 20*second);
        } catch (IllegalStateException e) {

        }

    }
     public void cancelTimer() {
        newTimer.cancel();
     }

}
