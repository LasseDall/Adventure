package com.company;

public class Item {
  //Creating attributes
  private String name;
  private String description;
  private int size;
  private boolean carried;

  public Item(String name,String description,int size){
    this.name = name;
    this.description = description;
    this.size = size;
    carried = false;
  }

  public void setCarried(boolean carried) {
    this.carried = carried;
  }

  public boolean getCarried() {
    return carried;
  }

  public String toString() {
    return name + " - " + description;
  }

  public String getName() {
    return name;
  }
}
