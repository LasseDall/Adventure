package com.company;

import java.util.ArrayList;

public class Room {
  //Making attributes
  private String name;
  private String description;
  private Room north;
  private Room east;
  private Room south;
  private Room west;
  private ArrayList<Item> items = new ArrayList<>();

  //Creating constructor method
  public Room(String name, String description){
    this.name = name;
    this.description = description;
    north = null;
    east = null;
    south = null;
    west = null;
    ArrayList<Item> items = null;
  }

  //Making set methods
  public void setNorth(Room room){
    north = room;
    if (room.getSouth() != this) {
      room.setSouth(this);
    }
  }

  public void setEast(Room room){
    east = room;
    if (room.getWest() != this) {
      room.setWest(this);
    }
  }

  public void setSouth(Room room){
    south = room;
    if (room.getNorth() != this) {
      room.setNorth(this);
    }
  }

  public void setWest(Room room){
    west = room;
    if (room.getEast() != this) {
      room.setEast(this);
    }
  }

  //Making methods for items
  public void setItems(Item item) {
    this.items.add(item);
  }

  public ArrayList<Item> getItems() {
    return items;
  }

  //Making get methods
  public Room getNorth(){
    return north;
  }

  public Room getEast(){
    return east;
  }

  public Room getSouth(){
    return south;
  }

  public Room getWest(){
    return west;
  }

  //Making a toString
   public String toString(){
    return name + '\n' + description;
   }



}
