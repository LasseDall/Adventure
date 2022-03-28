package com.company;


public class UserInterface {
  public void welcome(){
    System.out.println("Welcome to the Adventure-game");
    System.out.println(" ");
    preStory();
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
        "\nIf you get too scared, you can type 'exit' to exit the game" +
        "\n ");
  }

  //Making helpInstructions method
  public void helpInstructions(){
    System.out.printf("You can choose to:" + "\n" +
        "Go north" + "\n" +
        "Go east" + "\n" +
        "Go south" + "\n" +
        "Go west" + "\n" +
        "Go up" + "\n" +
        "Go down" + "\n" +
        "Look (You get to know what room you are in)" + "\n" +
        "Help" + "\n" +
        "Take (followed by the item you wish to take)" + "\n" +
        "Drop (followed by the item you wish to drop)" + "\n" +
        "Eat (followed by the item you wish to eat)" + "\n" +
        "Health (You get to know your health status)" + "\n" +
        "Exit" + "\n" + "\n");
  }

  //Making exit printout
  public void exitInstructions() {
    System.out.println("You are exiting the game");
  }

  //Print items text
  public void itemPrintoutFromRoom(){
    System.out.println("In the room you find the following items:");
  }

  //Print make choice
  public void printChoice(){
    System.out.println("Make your choice");
  }

  public String room5OpenGateDescription() {
    return "Where the man were sitting has know opened a gate, where a ladder leads down into deep darkness.\n";
  }

  public String room5LockedGateDescription() {
    return "Where the man were sitting is a locked gate in the floor. Maybe that is the way out.\n";
  }

  public String room5DraculaDescription() {
    return "You are in a room, where a person sits in a big armchair with its back towards you " +
        "\nlooking into a fireplace. The chair turns against you, and you recognize" +
        "\nthe pale skinny man from the picture in the hallway\n";
  }

  public String vampireFleet() {
    return "As you drop the garlic the man panic and run as fast as he can through the door.\n";
  }

  //Print health status
  public String printHealthStatus(){
    return "Your health status is: \n";
  }

  public String printGoodShape(){
    return "You are in good shape";
  }

  public String printBeCautious(){
    return "Your health status is a bit low. Be cautious of what you eat";
  }

  public String printBeCareful(){
    return "Your health status is low. Be careful of what you eat";
  }

  //Print equipped weapon
  public String printEquippedWeapon(){
    return "You picked up a ";
  }

  //Print no more ammo
  public String printNoMoreAmmunition(){
    return "You have no more ammunition";
  }
}
