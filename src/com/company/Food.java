package com.company;

public class Food extends Item{
  private int healthSize;

  public Food(String name, String description, int size, int healthSize) {
    super(name, description, size);
    this.healthSize = healthSize;
  }

  public int getHealthSize() {
    return healthSize;
  }

  public void setHealthSize(int healthSize) {
    this.healthSize = healthSize;
  }

  @Override
  public String toString() {
    return "Food{" +
        "healthSize=" + healthSize +
        '}';
  }
}
