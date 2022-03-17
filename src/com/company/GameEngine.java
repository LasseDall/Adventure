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
        case "exit":
          userInterface.exitInstructions();
          programRunning = false;
          break;
        case "help":
          userInterface.helpInstructions();
          break;
        case "look":
          System.out.println(player.currentRoom);
          break;
        case "go":
          player.roomEntered(player.currentRoom,secondWord);
          if (player.requestedRoom!=null){
            player.currentRoom=player.requestedRoom;
            System.out.println(player.currentRoom);
            if (player.currentRoom.getItems().size() != 0) {
              userInterface.itemPrintoutFromRoom();
              System.out.println(player.currentRoom.getItems());
            }
          } else {
            System.out.println("You cannot go in that direction");
          }
          player.requestedRoom = null;
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
