package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Adventure {
    //Opretter en scanner
    Scanner sc = new Scanner(System.in);

    //Laver mainMenu method
    public void mainMenu() {
        System.out.println("Welcome to the Adventure-game");
        boolean programRunning = true;
        while (programRunning) {
            System.out.println("Make your choice");
            String choice = userInput();
            String choice1 = firstWord(choice);
            String choice2 = secondWord(choice);
            switch (choice1) {
                case "exit":
                    System.out.println("Du lukker spillet");
                    programRunning = false;
                    break;
                case "help":
                    System.out.println("Du får hjælp");
                    break;
                case "look":
                    System.out.println("Du er i rummet XXX. Det ser sådan her ud...");
                    break;
                case "go":
                    switch (choice2) {
                        case "north" -> System.out.println("You are going north");
                        case "east" -> System.out.println("You are going east");
                        case "south" -> System.out.println("You are going south");
                        case "west" -> System.out.println("You are going west");
                    }
            }
        }
    }

    //Userinput method
    public String userInput(){
        String choice = sc.nextLine();
        choice = choice.toLowerCase();
        return choice;
    }

    //Methods to divide words
    public String firstWord(String choice){
        String space = " ";
        if (-1 != choice.indexOf(space)) {
            String word = choice.substring(0, choice.indexOf(space));
            return word;
        } else {
            return choice;
        }
    }

    public String secondWord(String choice){
        String space = " ";
        if (-1 != choice.indexOf(space)) {
            String word = choice.substring(choice.indexOf(space) + 1);
            return word;
        } else {
            return null;
        }
    }



    public static void main(String[] args) {
        Adventure obj = new Adventure();
        obj.mainMenu();
    }
}
