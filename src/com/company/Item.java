package com.company;

public class Item {
  //Creating attributes
  private String name;
  private String description;
  private int size;
  private boolean itemSeen;

  public Item(String name,String description,int size){
    this.name = name;
    this.description = description;
    this.size = size;
    itemSeen = false;
  }

  public String toString() {
    return name + " - " + description;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public void setItemSeen(boolean itemSeen) {
    this.itemSeen = itemSeen;
  }

  public boolean getItemSeen() {
    return itemSeen;
  }

  public int getSize() {
    return size;
  }
}
