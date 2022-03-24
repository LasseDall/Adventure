package com.company;

import java.util.Scanner;

//This class is our controller
public class GameEngine {
  //Instantiating Scanner class
  Scanner sc = new Scanner(System.in);

  //Instantiating objects
  UserInterface userInterface = new UserInterface();
  Player player = new Player();

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
          System.out.println(player.getCurrentRoom());
        }
        case "go" -> {
          player.roomEntered(player.getCurrentRoom(), secondWord);
          if (player.getRequestedRoom() != null) {
            player.setCurrentRoom(player.getRequestedRoom());
            System.out.println(player.getCurrentRoom());
            if (player.getCurrentRoom().getItems().size() != 0) {
              userInterface.itemPrintoutFromRoom();
              System.out.println(player.getCurrentRoom().getItems());
              System.out.println(" ");
            }
            player.setHealth(player.getHealth()-3);
          } else {
            System.out.println("You cannot go in that direction");
            System.out.println(" ");
            player.setHealth(player.getHealth()-1);
          }
          player.setRequestedRoom(null);
        }
        case "take" -> {
          player.takeItem(secondWord);
          if (player.getItemFound()) {
            System.out.println("You picked up a " + secondWord);
            System.out.println(" ");
            player.setHealth(player.getHealth() - 1);
            } else {
            System.out.println("No item was found");
            System.out.println(" ");
          }
        }
        case "inventory" -> {

          System.out.println(player.getInventory());
          System.out.println(" ");
        }
        case "drop" -> {
          player.dropItem(secondWord);
          if (player.getItemFound()) {
            System.out.println("You dropped a " + secondWord);
            System.out.println(" ");
            if ((secondWord.equals("garlic")) && (!player.map.room5.getCreatureLeft()) && player.getCurrentRoom().equals(player.map.room5)) {
                System.out.println(userInterface.vampireFleet());
                System.out.println("Take af closer 'look' at the room!");
              System.out.println(" ");
                player.map.room5.setCreatureLeft(true);
            }
          } else {
            System.out.println("No item was found");
            System.out.println(" ");
          }
        }
        case "health" -> {
          System.out.println(userInterface.printHealthStatus() + player.getHealth() + ": " + healthStatus(player.getHealth()) + "\n");
        }
        case "eat", "drink" -> {
          Item item = player.findFood(secondWord);
          if (item instanceof Food){
            player.setHealth(player.getHealth() + ((Food) item).getHealthSize());
            System.out.println(((Food) item).getConsequence());
            if (player.isGameOver()){
              programRunning = false;
            }
          } else if (item == null){
            System.out.println("No item was found \n");
          } else {
            System.out.println("You cannot eat " + item);
          }
        }
          default -> System.out.println("Your command did not match any legal commands. Type 'help' for instructions. \n");
      }
      if (!player.map.room5.getDoorLocked() && player.map.room5.getCreatureLeft()) {
        player.map.connectRoom10();
        player.map.room5.setDescription(userInterface.room5OpenGateDescription());
      } else if (player.map.room5.getCreatureLeft() && player.map.room5.getDoorLocked()) {
        player.map.room5.setDescription(userInterface.room5LockedGateDescription());
      } else if (player.map.picture.getItemSeen()) {
        player.map.room5.setDescription(userInterface.room5DraculaDescription());
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
    if (choice.contains(space)) {
      return choice.substring(0, choice.indexOf(space));
    } else {
      return choice;
    }
  }

  public String secondWord(String choice){
    String space = " ";
    if (choice.contains(space)) {
      return choice.substring(choice.indexOf(space) + 1);
    } else {
      return null;
    }
  }

  //Method to calculate health status
  public String healthStatus(int health){
    String healthStatus;
    if (health > 50){
      healthStatus = userInterface.printGoodShape();
    } else if (health < 50 && health > 25){
      healthStatus = userInterface.printBeCautious();
    } else{
      healthStatus = userInterface.printBeCareful();
    }
    return healthStatus;
  }
}