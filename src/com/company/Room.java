package com.company;

public class Room {
  //Making attributes
  private String name;
  private String description;
  private Room north;
  private Room east;
  private Room south;
  private Room west;

  //Creating constructor method
  public Room(String name, String description){
    this.name = name;
    this.description = description;
    north = null;
    east = null;
    south = null;
    west = null;
  }

  //Making set methods
  public void setNorth(Room room){
    north = room;
  }

  public void setEast(Room room){
    east = room;
  }

  public void setSouth(Room room){
    south = room;
  }

  public void setWest(Room room){
    west = room;
  }

}
