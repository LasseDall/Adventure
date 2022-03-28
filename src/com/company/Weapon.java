package com.company;

//Making Weapon class abstract, because weapon is an abstraction that is not a specific/concrete class such as the sub classes to weapon.
public class Weapon extends Item{
  private int damage = 1; //1-100
  private int precision;//1-10 - low value equals higher precision
  private int ammunitionAmount;

  public Weapon(String name, String description, int weight, int damage, int precision) {
    super(name, description, weight);
    this.damage = damage;
    this.precision = precision;
  }

  public Weapon(String name, String description, int weight, int damage, int precision, int ammunitionAmount) {
    super(name, description, weight);
    this.damage = damage;
    this.precision = precision;
    this.ammunitionAmount = ammunitionAmount;
  }

  public void decreaseAmmunitionAmount(){
    this.ammunitionAmount--;
  }

  public int getDamage() {
    return damage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  public int getPrecision() {
    return precision;
  }

  public void setPrecision(int precision) {
    this.precision = precision;
  }

  public int getAmmunitionAmount() {
    return ammunitionAmount;
  }

  public void setAmmunitionAmount(int ammunitionAmount) {
    this.ammunitionAmount = ammunitionAmount;
  }

  public boolean canUse(int ammunitionAmount){
    return true;
  }
}
