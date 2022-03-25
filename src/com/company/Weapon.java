package com.company;

//Making Weapon class abstract, because weapon is an abstraction that is not a specific/concrete class such as the sub classes to weapon.
public abstract class Weapon extends Item{
  private int damage; //1-100
  private int hitChance;//1-10

  public Weapon(String name, String description, int weight, int damage, int hitChance) {
    super(name, description, weight);
    this.damage = damage;
    this.hitChance = hitChance;
  }

  public int getDamage() {
    return damage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  public int getHitChance() {
    return hitChance;
  }

  public void setHitChance(int hitChance) {
    this.hitChance = hitChance;
  }
}
