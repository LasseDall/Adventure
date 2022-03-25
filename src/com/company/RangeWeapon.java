package com.company;

public class RangeWeapon extends Weapon{
  private int ammunitionAmount;

  public RangeWeapon(String name, String description, int weight, int damage, int hitChance, int ammunitionAmount) {
    super(name, description, weight, damage, hitChance);
    this.ammunitionAmount = ammunitionAmount;
  }
}
