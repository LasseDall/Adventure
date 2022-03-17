package com.company;

public class Player {
  Map map = new Map();

  Room requestedRoom = map.room1;
  Room currentRoom = map.room1;

  public void roomEntered(Room room, String direction){
    switch (direction){
      case "north", "n", "nord" -> requestedRoom = room.getNorth();
      case "east", "e","ø", "øst" -> requestedRoom = room.getEast();
      case "south", "s", "syd" -> requestedRoom = room.getSouth();
      case "west","w", "v","vest" -> requestedRoom = room.getWest();
    }
  }
}
