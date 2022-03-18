package com.company;

import java.util.ArrayList;
import java.util.Locale;

public class Player {

  Map map = new Map();

  private boolean itemFound;

  private Room requestedRoom;
  private Room currentRoom;
  private ArrayList<Item> items = new ArrayList<>();

  public Player() {
    items.add(map.flashlight);
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

  public void takeItem(Room room, String item) {
    itemFound = false;
    if (item != null) {
      for (int i = 0; i < room.getItems().size(); i++) {
        if (item.equals(room.getItems().get(i).getName().toLowerCase(Locale.ROOT))) {
          items.add(room.getItems().get(i));
          room.getItems().get(i).setItemSeen(true);
          room.removeItem(room.getItems().get(i));
          itemFound = true;
          i = room.getItems().size();
        }
      }
    }
  }

  public void dropItem(Room room, String item) {
    itemFound = false;
    if (item != null) {
      for (int i = 0; i < items.size(); i++) {
        if (item.equals(items.get(i).getName().toLowerCase(Locale.ROOT))) {
          room.setItems(items.get(i));
          items.remove(items.get(i));
          itemFound = true;
          i = items.size();
        }
      }
    }
  }

  public void setItems(Item item) {
    items.add(item);
  }

  public ArrayList<Item> getItems() {
    return items;
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
}
