package com.company;

public class RangeWeapon extends Weapon {

  public RangeWeapon(String name, String description, int weight, int damage, int precision, int ammunitionAmount) {
    super(name, description, weight, damage, precision, ammunitionAmount);
  }

  public boolean canUse() {
    if (getAmmunitionAmount() < 1) {
      return false;
    } else {
      return true;
    }
  }
}
