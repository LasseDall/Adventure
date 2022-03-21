package com.company;

import java.util.ArrayList;
import java.util.Locale;

public class Player {

  Map map = new Map();

  private boolean itemFound;

  private Room requestedRoom;
  private Room currentRoom;
  private ArrayList<Item> inventory = new ArrayList<>();

  public Player() {
    inventory.add(map.flashlight);
    requestedRoom = map.room1;
    currentRoom = map.room1;
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
    if (item!=null) {
      inventory.add(item);
      item.setItemSeen(true);
      currentRoom.removeItem(item);
    }
  }

  /*for (int i = 0; i < room.getItems().size(); i++) {*/
  /*  if (itemName.equals(room.getItems().get(i).getName().toLowerCase(Locale.ROOT))) {*/
  /*    inventory.add(room.getItems().get(i));*/
  /*    room.getItems().get(i).setItemSeen(true);*/
  /*    room.removeItem(room.getItems().get(i));*/
  /*    itemFound = true;*/
  /*    i = room.getItems().size();*/
  /*  }*/
  /*}*/

  public void dropItem(String itemName) {
    itemFound = false;
    Item item = findItem(inventory, itemName);
    if (item!=null) {
      currentRoom.setItems(item);
      item.setItemSeen(true);
      inventory.remove(item);
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

  public void setCurrentRoom(Room currentRoom) {
    this.currentRoom = currentRoom;
  }

  public void setRequestedRoom(Room requestedRoom) {
    this.requestedRoom = requestedRoom;
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
}