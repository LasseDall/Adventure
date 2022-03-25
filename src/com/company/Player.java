package com.company;

import java.util.ArrayList;
import java.util.Locale;

public class Player {

  Map map = new Map();

  private boolean itemFound;
  private boolean gameOver = false;
  private int carriedItems;

  private Room requestedRoom;
  private Room currentRoom;
  private ArrayList<Item> inventory = new ArrayList<>();

  private int health;

  public Player() {
    inventory.add(map.flashlight);
    requestedRoom = map.room1;
    currentRoom = map.room1;
    health = 100;
  }

  public void roomEntered(Room room, String direction) {
    if (direction != null) {
      switch (direction) {
        case "north", "n", "nord" -> requestedRoom = room.getNorth();
        case "east", "e", "ø", "øst" -> requestedRoom = room.getEast();
        case "south", "s", "syd" -> requestedRoom = room.getSouth();
        case "west", "w", "v", "vest" -> requestedRoom = room.getWest();
        case "up" -> requestedRoom = room.getUp();
        case "down" -> requestedRoom = room.getDown();
      }
    }
  }

  public void takeItem(String itemName) {
    itemFound = false;
    Item item = findItem(currentRoom.getItems(), itemName);
    if (item != null) {
      itemFound = true;
      if (carriedItems + item.getWeight() <= 10) {
        inventory.add(item);
        item.setItemSeen(true);
        currentRoom.removeItem(item);
        setCarriedItems(carriedItems + item.getWeight());
      } else {
        System.out.println("You carrie too much weight to pick that up.");
      }
    }
  }

  public void dropItem(String itemName) {
    itemFound = false;
    Item item = findItem(inventory, itemName);
    if (item != null) {
      currentRoom.setItems(item);
      item.setItemSeen(true);
      inventory.remove(item);
      itemFound = true;
      setCarriedItems(carriedItems - item.getWeight());
    }
  }

  public void addInventory(Item item) {
    inventory.add(item);
  }

  public ArrayList<Item> getInventory() {
    return inventory;
  }

  public Room getCurrentRoom() {
    return currentRoom;
  }

  public Room getRequestedRoom() {
    return requestedRoom;
  }

  public boolean getItemFound() {
    return itemFound;
  }

  public boolean isGameOver() {
    return gameOver;
  }

  public void setCurrentRoom(Room currentRoom) {
    this.currentRoom = currentRoom;
  }

  public void setRequestedRoom(Room requestedRoom) {
    this.requestedRoom = requestedRoom;
  }

  public void setHealth(int health) {
    this.health = health;
    if (health > 100){
      this.health = 100;
    } else if (health <= 0){
      gameOver = true;
    }
  }

  public void setCarriedItems(int carriedItems) {
    if (carriedItems <= 10) {
      this.carriedItems = carriedItems;
    }
  }

  public int getCarriedItems() {
    return carriedItems;
  }

  public int getHealth() {
    return health;
  }

  public Item findItem(ArrayList<Item> items, String itemName) {
    Item tmp = null;
    if (itemName != null) {
      for (Item item : items) {
        if (item.getName().toLowerCase(Locale.ROOT).equals(itemName)) {
          tmp = item;
          break;
        }
      }
    }
    return tmp;
  }

  public Item findFood(String foodName) {
    Item tmp = null;
    tmp = findItem(inventory, foodName);
    if (tmp == null) {
      tmp = findItem(currentRoom.getItems(), foodName);
    }
    return tmp;
    }
  }