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
  private Room up;
  private Room down;
  private ArrayList<Item> items = new ArrayList<>();//Contains the items in the room object
  private boolean doorLocked;
  private boolean creatureLeft;
  private Enemy enemy;
  private boolean enemyPresent;

  //Creating constructor method
  public Room(String name, String description){
    this.name = name;
    this.description = description;
    north = null;
    east = null;
    south = null;
    west = null;
    up = null;
    down = null;
    ArrayList<Item> items = null;
    doorLocked = true;
    creatureLeft = false;
    enemy = null;
    enemyPresent = false;
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

  public void setUp(Room room){
    up = room;
    if (room.getDown() != this) {
      room.setDown(this);
    }
  }

  public void setDown(Room room){
    down = room;
    if (room.getUp() != this) {
      room.setUp(this);
    }
  }

  public boolean isEnemyPresent(){
    if (enemyPresent){
      return true;
    } else{
      return false;
    }
  }

  //Making methods for items
  public void setItems(Item item) {
    items.add(item);
  }

  public void setDoorLocked(boolean doorLocked) {
    this.doorLocked = doorLocked;
  }

  public void setCreatureLeft(boolean creatureLeft) {
    this.creatureLeft = creatureLeft;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public boolean getCreatureLeft() {
    return creatureLeft;
  }

  public boolean getDoorLocked() {
    return doorLocked;
  }

  public ArrayList<Item> getItems() {
    return items;
  }

  public void removeItem(Item item) {
    items.remove(item);
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

  public Room getDown() {
    return down;
  }

  public Room getUp() {
    return up;
  }

  //Making set and get methods for enemy object
  public Enemy getEnemy() {
    return enemy;
  }

  public void setEnemy(Enemy enemy) {
    this.enemy = enemy;
    this.enemyPresent = true;
  }

  //Making a toString - remember that Java uses the toString method, if we sout a room object without specifying what to sout, Java will automatically print what is in the toString method.
   public String toString(){
     String items;
    if (this.items.size() != 0) {
      items = String.valueOf(this.items);
    } else {
      items = " ";
    }
    return name + '\n' + description + '\n' + items + '\n' + enemy;
   }



}
