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
  Item book = new Item("Book", "An old magic book which reads 中国大书 ", 3);
  Item flashlight = new Item("Flashlight", "An old flashlight blinking", 1);
  Item map = new Item("Map", "Old map of a strange continent", 3);
  Item knife = new Item("Knife", "An old rusty knife", 2);
  Item pencil = new Item("Pencil", "Old pencil drawing with ink", 1);
  Item paper = new Item("Paper", "Blank piece of paper", 1);
  Item parrot = new Item("Parrot", "Big parrot that repeats your name", 3);
  Item carpet = new Item("Carpet", "Long red carpet", 4);
  Item picture = new Item("Picture", "Black and white portrait picture of a pale skinny man reminding you of dracula", 3);
  Item sock = new Item("Sock", "Smelly black sock", 1);
  Item fork = new Item("Fork", "Silver fork", 1);
  Item garlic = new Item("Garlic", "Very smelly dried garlic", 1);

  //Instantiating food items
  Food apple = new Food("Apple","A big red shiny apple. Do you dare to eat it?",1,-10,"Ouch, apples are usually a good idea to eat,\n" +
      " but not if they are rotten. Did you know that you should eat about 600 grams of fruits and vegetables. However, when fruits are too old, you shouldn't eat them!");
  Food carrot = new Food("Carrot","A delicious orange carrot",2,100,"It's greeeaat! Tony the Tiger likes to each frosties. \n" +
      "However, you just ate a carrot, which was pretty damn healthy. A normal sized carrot weighs about 66 grams. So if you eat 9 carrots a day, you would almost reach \n" +
      "the recommended amount each day.");
  Food turkey = new Food("Turkey","A big juicy turkey",5,30,"Velbekomme. That is the Danish word you say after you have eaten\n" +
      "a lot of food. Did you know that Denmark produces 1.6 million turkeys each year. That is a lot of health points you would get, if you ate all of them, huh!");
  Food coffee = new Food("Coffee", "A dark smelly cup of coffee",1,20, "Ooow, you get POOOOWER! Coffee contains caffeine, \n" +
      "which energizes your nerve system. Did you know that a cup of coffee contains about 125 mg of caffeine.");
  Food water = new Food("Water","A bottle of water",2,10, "The water feels nice in your dry mouth.\nDid you know that 60% of the human body weight is water?");
  Food shot = new Food("Shot", "A small glas of brown whiskey",2,-10, "The whiskey taste bitter and you get a bit confused.\nDid you know that 3 million people die every year because of drinking alcohol?");
  Food scone = new Food("Scone","A delicious scone with chocolate topping",2,-20, "The scone taste very good, but your stomach begins to rumble.\nDid you know that at least 2.8 million people die every year as a result of being overweight.");
  Food wine = new Food("Wine", "Old looking bottle of wine", 3,-100, "You should have known better than to drink a bottle of wine!\nDid you know that an average adult in Denmark drink 9 units of alcohol every week?");

  //Instantiating melee weapons
  MeleeWeapon sword = new MeleeWeapon("Sword","A long silver bladed sword",4,10,5);
  MeleeWeapon axe = new MeleeWeapon("Axe","A sharp bladed axe",5,20,3);

  //Instantiating range weapons
  RangeWeapon pistol = new RangeWeapon("Pistol","A glock gun", 3,30,8,10);
  RangeWeapon AK47 = new RangeWeapon("AK47","An AK47 machine gun",6,50,9,50);
  RangeWeapon bazooka = new RangeWeapon("Bazooka", "A large and heavy bazooka",10,100,7,1);
  RangeWeapon molotovCocktail = new RangeWeapon("Molotov cocktail","A bottle of gasoline",2,20,3,1);


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
    room2.setItems(garlic);
    room9.setItems(map);
    room3.setItems(paper);
    room3.setItems(pencil);
    room4.setItems(picture);
    room4.setItems(carpet);
    room7.setItems(sock);
    room8.setItems(fork);
    room3.setItems(parrot);

    //Adding food to rooms
    room8.setItems(turkey);
    room8.setItems(wine);
    room9.setItems(apple);
    room3.setItems(shot);
    room2.setItems(water);
    room7.setItems(scone);
    room10.setItems(carrot);
    room2.setItems(carrot);
    room6.setItems(coffee);
    room4.setItems(coffee);
    room1.setItems(apple);
    room1.setItems(apple);
  }

  public void connectRoom10() {
    room5.setDown(room10);
  }
}




