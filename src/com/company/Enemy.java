package com.company;

public class Enemy {
  private int enemyHealth;
  private String name;
  private String description;
  private Weapon weapon;

  public Enemy(int enemyHealth, String name, String description, Weapon weapon){
    this.enemyHealth = enemyHealth;
    this.name = name;
    this.description = description;
    this.weapon = weapon;
  }

  public int getEnemyHealth() {
    return enemyHealth;
  }

  public void setEnemyHealth(int enemyHealth) {
    this.enemyHealth = enemyHealth;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Weapon getWeapon() {
    return weapon;
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  @Override
  public String toString() {
    return enemyHealth +"\n" + name + '\n' + description + "\n" + weapon;
  }
}
