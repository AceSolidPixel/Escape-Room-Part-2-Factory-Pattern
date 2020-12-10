/**
* Factory for creating doors using the factory design pattern
*/
public class DoorFactory
{
  /**
  * Creates a random door based on the number passed into the function
  *
  * @param type Type of door to be created
  * @return Door of specified type
  */
  public Door createDoor(int type)
  {
    Door door;
    switch(type)
    {
      case 1:
        door = new BasicDoor();
        break;
      
      case 2:
        door = new LockedDoor();
        break;
      
      case 3:
        door = new DeadboltDoor();
        break;
      
      case 4:
        door = new ComboDoor();
        break;

      case 5:
        door = new CodeDoor();
        break;

      default:
        door = new CodeDoor();
        break;
    }
    return door;
  }

  /**
  * Generates a door using the createDoor function and allows user to solve
  * the puzzle of opening the generated door.
  *
  * @param type Type of door to be created
  */
  public void openDoor (int type)
  {
    Door d = createDoor(type);
    System.out.println(d.examine());

    while(!d.open())
    {
      System.out.println(d.menu());
      int userChoice = CheckInput.getPositiveInt();

      System.out.println(d.unlock(userChoice));

      if(d.open())
      {
        System.out.println(d.success());
      }
      else
      {
        System.out.println(d.clue());
      }
    }
    
  }
}