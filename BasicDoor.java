import java.util.Random;
/** Door that open if you push or pull it */
public class BasicDoor implements Door
{
  /** Indicates whether or not the door was pushed */
  private boolean push;
  /** Indicates whether or not the user input to either push or pull the door */
  private boolean input;
  /** Object that will be used for the randomization of where the key is */
  Random rand = new Random();

  /**
  * Constructor - Initializes both data members to false as the user has not made
  *               an input or decided to push the door.
  */
  public BasicDoor()
  {
    push = rand.nextBoolean();
    input = false;
  }
  
  /** 
  * Displays brief description of door being encountered.
  *
  * @return String of when you first encountered with the 
  * door
  */
  @Override
  public String examine()
  {
    String returnString = "You encounter a basic door.\n" + 
                          "A door that can be pushed or pulled.";
    return returnString;
  }

  /**
  * Displays options to interact with the door. 
  * 
  * @return String the interaction option with the door. 
  */
  @Override
  public String menu()
  {
    String returnString = "1. Push \n2. Pull";
    return returnString;
  }

  /**  
  * Carries out users interaction with the door and notifies user of their interaction
  *
  * @param Option user chose for interacting with the door
  * @return String describing interaction with the door 
  */
  @Override
  public String unlock(int option)
  {
    if(option == 1)
    {
      input = push;
      return "You try to push the door";
    }
    else
    {
      input = !push;
      return "You try to pull the door";
    }
  }

  /**
  * Returns true if user either pushes or pulls the door
  *
  * @return Whether or not the user input something valid 
  */
  @Override
  public boolean open()
  {
    if(input)
      return true;
    else
      return false;
  }

  /**
  * Returns hint for user if they can't choose a valid option then they should try another door.
  *
  * @return Hint for user
  */
  @Override
  public String clue()
  {
    return new String("Try the other way.");
  }

  /**
  * Returns success message for user when they get through the door.
  * 
  * @return Success message to user
  */
  @Override
  public String success()
  {
    return new String("Congratulations, you opened the door.");
  }
}