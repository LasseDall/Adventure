package com.company;

public class Map {
  Room room1 = new Room("Hall", "You walk into the big hall where you started.");
  Room room2 = new Room("Kitchen", "You walk into the kitchen, which has big black and white squares on the floor " +
      "\nIt smells like someone just cooked. Maybe turkey? But the kitchen looks almost too clean. " +
      "\nTheres hot like an oven and the sweat drips from your forehead. " +
      "\nKnifes are hanging on the wall, and theres a fridge and a lot of drawers and cabinets to seek. ");
  Room room3 = new Room("Office", "You walk into the office. A big desk of dark wood is in the middle of the room. " +
      "\nThe desk is full of paper, pencils and an old book that is left open." +
      "\nYou wonder why theres no chair at the desk. Suddenly a strange voice calls your name from a corner. " +
      "\nAs you look to the corner you see a big parrot. How does it know my name?");
  Room room4 = new Room("Hallway", "You walk into a long hallway. Old black and white portrait pictures fills the walls " +
      "\nUnderneath your feet a red carpet grace all along the hallway floor.");
  Room room5 = new Room("Living room", "You are in a room, where a person sits in a big armchair with its back towards you " +
      "\n looking into a fireplace");
  Room room6 = new Room("Bedroom", "You walk into a bedroom. You freeze as you see a person laying in the double bed. " +
      "\nJust sleeping? A staircase leads to the upper floor");
  Room room7 = new Room("Closet", "You walk into a big closet. But there is no clothes in the room. The only thing left in there " +
      "\nis a smelly sock.");
  Room room8 = new Room("Dining room", "You walk into the dining room. An overwhelming smell of turkey hits you. " +
      "\nThere is turkey served for 8 people. One turkey on each plate. An open bottle of wine " +
      "\nis on the table.");
  Room room9 = new Room("Library", "You are in the library. There are shelves all around you with old books. " +
      "\nAn old radio is playing white noise. The radio is placed next to a map lying on a table. The map is showing a continent " +
      "\nthat you have never seen before.");




  //Instantiating items
  Item radio = new Item("Radio","An old radio",4);
  Item book = new Item("Book","An old magic book which reads XXX", 2);
  Item flashlight = new Item("Flashlight", "An old flashlight blinking",1);
  Item map = new Item("Map", "Old map of America", 1);


  public Map(){
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
    room9.setItems(map);
  }
}


