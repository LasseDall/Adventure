package com.company;

public class Food extends Item{
  private int healthSize;
  private String consequence;

  public Food(String name, String description, int size, int healthSize, String consequence) {
    super(name, description, size);
    this.healthSize = healthSize;
    this.consequence = consequence;
  }

  public int getHealthSize() {
    return healthSize;
  }

  public void setHealthSize(int healthSize) {
    this.healthSize = healthSize;
  }

  @Override
  public String toString() {
    return getName() + " - " + getDescription();
  }
}
