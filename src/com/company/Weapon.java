package com.company;

//Making Weapon class abstract, because weapon is an abstraction that is not a specific/concrete class such as the sub classes to weapon.
public abstract class Weapon extends Item{
  private int damage; //1-100 - should we say from 1 to 100? todo: Figure range
  private int hitChance;//1-10 todo: figure range

  public Weapon(String name, String description, int weight, int damage, int hitChance) {
    super(name, description, weight);
    this.damage = damage;
    this.hitChance = hitChance;
  }
}
