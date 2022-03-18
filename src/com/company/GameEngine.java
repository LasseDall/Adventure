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
      userInterface.printChoice();
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
            if (player.currentRoom.getItems().size() != 0) {
              userInterface.itemPrintoutFromRoom();
              System.out.println(player.currentRoom.getItems());
              System.out.println(" ");
            }
          } else {
            System.out.println("You cannot go in that direction");
            System.out.println(" ");
          }
          player.requestedRoom = null;
        }
        case "take" -> {
          player.takeItem(player.currentRoom, secondWord);
          if (player.itemFound == true) {
            System.out.println("You picked up a " + secondWord);
            System.out.println(" ");
          } else {
            System.out.println("No item was found");
            System.out.println(" ");
          }
        }
        case "inventory" -> {
          System.out.println(player.items);
          System.out.println(" ");
        }
        case "drop" -> {
          player.dropItem(player.currentRoom, secondWord);
          if (player.itemFound == true) {
            System.out.println("You dropped a " + secondWord);
            System.out.println(" ");
          } else {
            System.out.println("No item was found");
            System.out.println(" ");
          }

        }
          default -> System.out.println("Your command did not match any legal commands. Type 'help' for instructions. \n");
      }
      if (map.room5.getDoorLocked() == false && map.room5.getCreatureLeft() == true) {
        map.connectRoom10();
        map.room5.setDescription(userInterface.room5OpenGateDescription());
      } else if (map.room5.getCreatureLeft() == true && map.room5.getDoorLocked() == true) {
        map.room5.setDescription(userInterface.room5LockedGateDescription());
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
