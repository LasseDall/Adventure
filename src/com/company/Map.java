package com.company;

public class Map {
  Room room1 = new Room("Hall\n", "You walk into the big hall where you started.\n");
  Room room2 = new Room("Kitchen\n", "You walk into the kitchen, which has big black and white squares on the floor " +
      "\nIt smells like someone just cooked. Maybe turkey? But the kitchen looks almost too clean. " +
      "\nTheres hot like an oven and the sweat drips from your forehead. " +
      "\nKnifes are hanging on the wall, and theres a fridge and a lot of drawers and cabinets to seek. \n");
  Room room3 = new Room("Office\n", "You walk into the office. A big desk of dark wood is in the middle of the room. " +
      "\nThe desk is full of paper, pencils and an old book that is left open." +
      "\nYou wonder why theres no chair at the desk. Suddenly a strange voice calls your name from a corner. " +
      "\nAs you look to the corner you see a big parrot. How does it know my name?\n");
  Room room4 = new Room("Hallway\n", "You walk into a long hallway. Old black and white portrait pictures fills the walls " +
      "\nUnderneath your feet a red carpet grace all along the hallway floor.\n");
  Room room5 = new Room("Living room\n", "You are in a room, where a person sits in a big armchair with its back towards you " +
      "\nlooking into a fireplace\n");
  Room room6 = new Room("Bedroom\n", "You walk into a bedroom. You freeze as you see a person laying in the double bed. " +
      "\nJust sleeping? A staircase leads to the upper floor\n");
  Room room7 = new Room("Closet\n", "You walk into a big closet. But there is no clothes in the room. The only thing left in there " +
      "\nis a smelly sock.\n");
  Room room8 = new Room("Dining room\n", "You walk into the dining room. An overwhelming smell of turkey hits you. " +
      "\nThere is turkey served for 8 people. One turkey on each plate. An open bottle of wine " +
      "\nis on the table.\n");
  Room room9 = new Room("Library\n", "You are in the library. There are shelves all around you with old books. " +
      "\nAn old radio is playing white noise. The radio is placed next to a map lying on a table. The map is showing a continent " +
      "\nthat you have never seen before.\n");
  Room room10 = new Room("Cellar\n", "You crawl down a long narrow shaft and enter a cold dark cellar with rough stone walls. \n" +
      "The smell of mold is overwhelming and you struggle to keep a calm breath. You dont see much, but as your breath \n" +
      "get calm you hear a deep snoring from the opposite end og the cellar. You begin to see a bit more, and a silhouette \n" +
      "of a strange creature shows up. You are convinced that you have lost your mind when you discover that the creature \n" +
      "seems to have three heads.");

  //Instantiating items
  Item radio = new Item("Radio", "An old radio", 4);
  Item book = new Item("Book", "An old magic book which reads 中国大书 ", 2);
  Item flashlight = new Item("Flashlight", "An old flashlight blinking", 1);
  Item map = new Item("Map", "Old map of a strange continent", 1);
  Item knife = new Item("Knife", "An old rusty knife", 2);
  Item pencil = new Item("Pencil", "Old pencil drawing with ink", 1);
  Item paper = new Item("Paper", "Blank piece of paper", 1);
  Item parrot = new Item("Parrot", "Big parrot that repeats your name", 3);
  Item carpet = new Item("Carpet", "Long red carpet", 4);
  Item picture = new Item("Picture", "Black and white portrait picture of a pale skinny man", 2);
  Item sock = new Item("Sock", "Smelly black sock", 1);
  Item turkey = new Item("Turkey", "Big oven baked turkey with crispy skin", 5);
  Item wine = new Item("Wine", "Old looking bottle of wine", 2);
  Item fork = new Item("Fork", "Silver fork", 1);



  public Map() {
    //Adding directions to rooms
    room1.setEast(room2);
    room1.setSouth(room4);
    room2.setEast(room3);
    room3.setSouth(room6);
    room4.setSouth(room7);
    room5.setSouth(room8);
    room6.setSouth(room9);
    room7.setEast(room8);
    room8.setEast(room9);

    //Adding items to rooms
    room3.setItems(book);
    room9.setItems(radio);
    room2.setItems(knife);
    room9.setItems(map);
    room3.setItems(paper);
    room3.setItems(pencil);
    room4.setItems(picture);
    room4.setItems(carpet);
    room7.setItems(sock);
    room8.setItems(wine);
    room8.setItems(fork);
    room8.setItems(turkey);
    room3.setItems(parrot);
  }

  public void connectRoom10() {
    room5.setDown(room10);
  }
}


