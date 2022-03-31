package com.company;

import java.util.Scanner;

//This class is our controller
public class GameEngine {
  //Instantiating Scanner class
  Scanner sc = new Scanner(System.in);

  //Instantiating objects
  UserInterface userInterface = new UserInterface();
  Player player = new Player();

  //mainMenu method
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
            player.setHealth(player.getHealth() - 3);
          } else {
            System.out.println(userInterface.defaultDirection());
            player.setHealth(player.getHealth() - 1);
          }
          player.setRequestedRoom(null);
        }
        case "take" -> {
          player.takeItem(secondWord);
          if (player.getItemFound()) {
            System.out.println(userInterface.pickUp(secondWord));
            player.setHealth(player.getHealth() - 1);
          } else {
            System.out.println(userInterface.defaultItem());
          }
        }
        case "inventory" -> {
          System.out.println(player.getInventory() + "\n");
        }
        case "drop" -> {
          player.dropItem(secondWord);
          if (player.getItemFound()) {
            System.out.println(userInterface.drop(secondWord));
            if ((secondWord.equals("garlic")) && (!player.map.room5.getCreatureLeft()) && player.getCurrentRoom().equals(player.map.room5)) {
              System.out.println(userInterface.vampireFleet());
              player.map.room5.setCreatureLeft(true);
            }
          } else {
            System.out.println(userInterface.defaultItem());
          }
        }
        case "health" -> {
          System.out.println(userInterface.healthStatus(player.getHealth()));
        }
        case "eat", "drink" -> {
          Item item = player.findFood(secondWord);
          if (item instanceof Food) {
            player.setHealth(player.getHealth() + ((Food) item).getHealthSize());
            System.out.println(((Food) item).getConsequence());
            if (player.isGameOver()) {
              programRunning = false;
            }
          } else if (item == null) {
            System.out.println(userInterface.defaultItem());
          } else {
            System.out.println(userInterface.notFood(secondWord));
          }
        }
        case "equip" -> {
          Item item = player.findItem(player.getInventory(), secondWord);
          if (item instanceof Weapon) {
            player.equip((Weapon) item);
            System.out.println(userInterface.printEquippedWeapon() + item.getName());
          } else if (item == null) {//This covers also instances where user makes typing error such as pisol instead of pistol.
            System.out.println(userInterface.defaultItem());
          } else {
            System.out.println(userInterface.notWeapon(secondWord));
          }
        }
        case "attack" -> {
          if (player.getCurrentRoom().getEnemy() == null) {
            System.out.println(userInterface.printNoEnemyPresent());}
          else if(player.isEnemyIsPresent() == true) {
              if (player.getEquippedWeapon() != null) {//Checks if user carries a weapon
                int damage = player.attack();
                System.out.println(userInterface.printAttack(damage));
                player.getCurrentRoom().getEnemy().setEnemyHealth(damage);
                int enemyHealth;
                enemyHealth = player.getCurrentRoom().getEnemy().getEnemyHealth();
                if (enemyHealth <= 0) {
                  System.out.println("Enemy is dead");
                  player.getCurrentRoom().setItems(player.getCurrentRoom().getEnemy().getWeapon());
                  player.getCurrentRoom().setEnemy(null);
                } else {
                  System.out.println(userInterface.printEnemyHealth(enemyHealth));
                }
              }
              if (player.getCurrentRoom().getEnemy() != null) {
                if (player.getCurrentRoom().getEnemy().getEnemyHealth() > 0) {
                  int enemyDamage = player.enemyAttack();
                  player.decreaseHealth(enemyDamage);
                  int tmp2;
                  tmp2 = player.getHealth();
                  if (player.getHealth() <= 0) {
                    userInterface.gameOver();
                    programRunning = false;
                  }
                  System.out.println(userInterface.printPlayerHealth(tmp2));
                }
              }
              if (player.getHealth() <= 0) {
                System.out.println(userInterface.gameOver());
                programRunning = false;
              }
            }
          }
          default -> System.out.println(userInterface.defaultCommand());
        }
        checkRoom5();
      }
    }


  //Userinput method
  public String userInput() {
    String choice = sc.nextLine();
    choice = choice.toLowerCase();
    return choice;
  }

  //Methods to divide words
  public String firstWord(String choice) {
    String space = " ";
    if (choice.contains(space)) {
      return choice.substring(0, choice.indexOf(space));
    } else {
      return choice;
    }
  }

  public String secondWord(String choice) {
    String space = " ";
    if (choice.contains(space)) {
      return choice.substring(choice.indexOf(space) + 1);
    } else {
      return null;
    }
  }

  public void checkRoom5() {
    if (!player.map.room5.getDoorLocked() && player.map.room5.getCreatureLeft()) {
      player.map.connectRoom10();
      player.map.room5.setDescription(userInterface.room5OpenGateDescription());
    } else if (player.map.room5.getCreatureLeft() && player.map.room5.getDoorLocked()) {
      player.map.room5.setDescription(userInterface.room5LockedGateDescription());
    } else if (player.map.picture.getItemSeen()) {
      player.map.room5.setDescription(userInterface.room5DraculaDescription());
    }
  }

  //Method to calculate health status
  public String healthStatus(int health) {
    String currentHealt;
    if (health > 50) {
      currentHealt = userInterface.printGoodShape();
    } else if (health < 50 && health > 25) {
      currentHealt = userInterface.printBeCautious();
    } else {
      currentHealt = userInterface.printBeCareful();
    }
    return userInterface.healthStatus(player.getHealth()) + ": " + currentHealt + '\n';
  }
}