package com.company;

import java.util.Scanner;

//This class is our controller
public class GameEngine {
  //Instantiating Scanner class
  Scanner sc = new Scanner(System.in);

  //Instantiating objects
  UserInterface userInterface = new UserInterface();
  Player player = new Player();
  Map map = new Map();

  //Laver mainMenu method
  public void mainMenu() {
    boolean programRunning = true;
    userInterface.welcome();
    while (programRunning) {
      String choice = userInput();
      String firstWord = firstWord(choice);
      String secondWord = secondWord(choice);
      switch (firstWord) {
        case "exit" -> {
          userInterface.exitInstructions();
          programRunning = false;
        }
        case "help" -> {
          userInterface.helpInstructions();
        }
        case "look" -> {
          System.out.println(player.currentRoom);
        }
        case "go" -> {
          player.roomEntered(player.currentRoom, secondWord);
          if (player.requestedRoom != null) {
            player.currentRoom = player.requestedRoom;
            System.out.println(player.currentRoom);
          } else {
            System.out.println("You cannot go in that direction");
          }
          player.requestedRoom = null;
        }
        case "take" -> {
          player.takeItem(player.currentRoom, secondWord);
          if (player.itemFound == true) {
            System.out.println("You picked up a " + secondWord);
          } else {
            System.out.println("No item was found");
          }
        }
        case "inventory" -> {
          System.out.println(player.items);
        }
        case "drop" -> {
          player.dropItem(player.currentRoom, secondWord);
          if (player.itemFound == true) {
            System.out.println("You dropped a " + secondWord);
          } else {
            System.out.println("No item was found");
          }
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
}
