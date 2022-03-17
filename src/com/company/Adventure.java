package com.company;

public class Adventure {
    public static void main(String[] args) {
        Map map = new Map();
        System.out.println(map.room9.getItems());


        GameEngine startGame = new GameEngine();
        startGame.mainMenu();


    }
}
