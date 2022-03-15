package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Adventure {
    //Opretter en scanner
    Scanner sc = new Scanner(System.in);

    //Created all 9 rooms
    Room room1 = new Room("Room 1", "You are in a big hall with a big staircase in front of you");
    Room room2 = new Room("Room 2", "You are in the kitchen, which has big black and white squares");
    Room room3 = new Room("Room 3", "You are in the office. There is a pig parrot in the corner that calls out your name");
    Room room4 = new Room("Room 4", "You are on the first floor in a long hallway");
    Room room5 = new Room("Room 5", "You are in a room, where a person sits with its back towards you in front of a fire");
    Room room6 = new Room("Room 6", "You are in a bedroom. There is a person in the bed. A staircase leads to the upper floor");
    Room room7 = new Room("Room 7", "You are in a big closet. There is no closet in the room");
    Room room8 = new Room("Room 8", "You are in the dining room. There is served for 8 people");
    Room room9 = new Room("Library", "You are in the library. There are shelves all around you with old books. " +
        "An old radio is playing white noise. The radio is placed next to a map lying on a table. The map is showing a continent" +
        "that you have never seen before.");

    //Creating connections in all rooms
    public void createConnections(){
        room1.setEast(room2);
        room1.setSouth(room4);

        room2.setWest(room1);
        room2.setEast(room3);

        room3.setWest(room2);
        room3.setSouth(room6);

        room4.setNorth(room1);
        room4.setSouth(room7);

        room5.setSouth(room8);
        room6.setNorth(room3);
        room6.setSouth(room9);

        room7.setNorth(room4);
        room7.setEast(room8);

        room8.setWest(room7);
        room8.setNorth(room5);
        room8.setEast(room9);

        room9.setNorth(room6);
        room9.setWest(room8);
    }

    //Opretter requestedMethod og currentMethod
    Room requestedRoom = room1;
    Room currentRoom = room1;

    //Opretter roomEntered
    public void roomEntered(Room room, String direction){
        switch (direction){
            case "north" -> requestedRoom = room.getNorth();
            case "east" -> requestedRoom = room.getEast();
            case "south" -> requestedRoom = room.getSouth();
            case "west" -> requestedRoom = room.getWest();
        }
    }

    //Laver mainMenu method
    public void mainMenu() {
        boolean programRunning = true;
        System.out.println("Welcome to the Adventure-game");
        preStory();
        createConnections();
        helpInstructions();
        System.out.println(room1);
        while (programRunning) {
            System.out.println("Make your choice");
            String choice = userInput();
            String choice1 = firstWord(choice);
            String choice2 = secondWord(choice);
            switch (choice1) {
                case "exit":
                    System.out.println("You are exiting the game");
                    programRunning = false;
                    break;
                case "help":
                    helpInstructions();
                    break;
                case "look":
                    System.out.println(currentRoom);
                    break;
                case "go":
                    roomEntered(currentRoom,choice2);
                    if (requestedRoom!=null){
                        currentRoom=requestedRoom;
                        System.out.println(currentRoom);
                    } else {
                        System.out.println("You cannot go in that direction");
                    }
                    requestedRoom = null;
            }
        }
    }

    //Userinput method
    public String userInput(){
        String choice = sc.nextLine();
        choice = choice.toLowerCase();
        return choice;
    }

    //Methods to divide words
    public String firstWord(String choice){
        String space = " ";
        if (-1 != choice.indexOf(space)) {
            String word = choice.substring(0, choice.indexOf(space));
            return word;
        } else {
            return choice;
        }
    }

    public String secondWord(String choice){
        String space = " ";
        if (-1 != choice.indexOf(space)) {
            String word = choice.substring(choice.indexOf(space) + 1);
            return word;
        } else {
            return null;
        }
    }

    //Making helpInstructions method
    public void helpInstructions(){
        System.out.printf("You can choose to:" + "\n" +
            "Go north" + "\n" +
            "Go east" + "\n" +
            "Go south" + "\n" +
            "Go west" + "\n" +
            "Look (You get to know what room you are in)" + "\n" +
            "Help" + "\n" +
            "Exit" + "\n" + "\n");
    }

    //Making pre-story method
    public void preStory(){
        System.out.println("You are on a holiday in the state of Georgia. You are driving on the country-side in the " +
            "\ndark night. Suddenly, you hear the engine starts to make sounds. You have no more throttle and " +
            "\nyour speed decreases. Your car stops at the side of the road and the your lights shut down. " +
            "\nThere is total darkness. There is a gravel road to your right side. At the end of the road, " +
            "\nthere is an old abandoned house, with a light pole blinking at the front door. You walk down the road and " +
            "\nsee the house, which has no light from the window inside it. The house looks decayed and the outer walls" +
            "\nare demolished. You walk to the frontdoor and knocks three times."+
            "\nThe door squeaks and opens a bit, as you knock. You can hear a gramophone, which is stuck in a " +
            "\ngroove playing the song which, your mum sang to you, when you had to fall asleep, when you were a " +
            "\nkid. You enter the house, it is totally dark and suddenly you hear a loud BAAANG. The door shuts " +
            "\nbehind you, and the lights turn on at the same time. You look behind you, but there is no door " +
            "\nbehind you anymore! You look around and find yourself in a big hallway with marble floor. The " +
            "\nwalls are extremely elegant with beautiful wallpaper with red and gold stripes. On the wall to your" +
            "\nright there is a mirror. You cannot see yourself in the mirror! You look down, there is compass " +
            "\ndrawn on the floor at your feet. To your east there is a door and to the south there is a staircase" +
            "\nleading up to the upper floor. " +
            "\nYou can choose to go in any direction 'Go north', 'go east', 'go south', 'go west'." +
            "\nYou can ask for help by typing 'help'." +
            "\nYou can get a description of which room you are in by typing 'look'"+
            "\nIf you get too scared, you can type 'exit' to exit the game"
        );
    }

    public static void main(String[] args) {
        Adventure obj = new Adventure();
        obj.mainMenu();
    }
}
