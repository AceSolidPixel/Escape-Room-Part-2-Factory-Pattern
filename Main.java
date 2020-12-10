/*Name: Blake Del Rey and Prince Angulo
 Date: 11 - 10 - 2020
 Purpose: The purpose of this lab is to remake Lab 8 - Door Maze using the
          factory design pattern.
*/
import java.util.*;

class Main 
{
  public static void main(String[] args) 
  {
    final int TOTAL_DOORS = 3;
    final int FIRST_DOOR_NUM = 1;
    final int LAST_DOOR_NUM = 5;

    DoorFactory df = new DoorFactory();
    int randomDoorNum;

    System.out.println("Welcome to the Escape Room.");
    System.out.println("You must unlock 3 doors to escape...\n");

    for (int doorMaker = 0; doorMaker < TOTAL_DOORS; ++doorMaker)
    {
      //Equation for random int between [FIRST_DOOR_NUM,LAST_DOOR_NUM]
      randomDoorNum = (int) ((Math.random() * (LAST_DOOR_NUM + 1 - FIRST_DOOR_NUM)) + FIRST_DOOR_NUM);
      
      df.openDoor(randomDoorNum);
      System.out.println("");
      System.out.println("Numbers of doors unlocked: " + (doorMaker + 1));
      System.out.println("");

    }

    System.out.println("Congratulations! You unlocked 3 doors! You escaped...this time.");
  }
}