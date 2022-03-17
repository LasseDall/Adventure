package com.company;

import java.util.ArrayList;
import java.util.Locale;

public class Player {

  Map map = new Map();

  boolean itemFound;

  Room requestedRoom = map.room1;
  Room currentRoom = map.room1;
  ArrayList<Item> items = new ArrayList<>();

  public Player() {
    items.add(map.flashlight);
  }

  public void roomEntered(Room room, String direction){
    switch (direction){
      case "north", "n", "nord" -> requestedRoom = room.getNorth();
      case "east", "e","ø", "øst" -> requestedRoom = room.getEast();
      case "south", "s", "syd" -> requestedRoom = room.getSouth();
      case "west","w", "v","vest" -> requestedRoom = room.getWest();
    }
  }

  public void takeItem(Room room, String item) {
    itemFound = false;
    for (int i = 0; i < room.getItems().size(); i++) {
        if (item.equals(room.getItems().get(i).getName().toLowerCase(Locale.ROOT))) {
          items.add(room.getItems().get(i));
          room.removeItem(room.getItems().get(i));
          itemFound = true;
          i = room.getItems().size();
        }
      }
  }

  public void dropItem(Room room, String item) {
    itemFound = false;
    for (int i = 0; i < items.size(); i++) {
      if (item.equals(items.get(i).getName().toLowerCase(Locale.ROOT))) {
        room.setItems(items.get(i));
        items.remove(items.get(i));
        itemFound = true;
        i = items.size();
      }
    }
  }

  public void setItems(Item item) {
    items.add(item);
  }

  public ArrayList<Item> getItems() {
    return items;
  }
}
