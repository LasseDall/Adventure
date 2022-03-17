package com.company;


public class UserInterface {
  public void welcome(){
    System.out.println("Welcome to the Adventure-game");
    preStory();
    System.out.println("Make your choice");
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

}
