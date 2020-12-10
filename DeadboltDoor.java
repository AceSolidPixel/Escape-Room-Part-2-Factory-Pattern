import java.util.Random;

/**Deadbolt class that implements from Door interface*/
public class DeadboltDoor implements Door
{
  /**Tells whethere the deadbolts are unlocked or locked*/
  private boolean bolt1;
  private boolean bolt2;

  /** Constructor - both bolts are set to false since the bolts haven't been interacted with*/
  public DeadboltDoor()
  {
    Random rand = new Random();
    bolt1 = rand.nextBoolean();
    bolt2 = rand.nextBoolean();
    if (bolt1 && bolt2)
    {
      if (Math.random() < .5)
      {
        bolt1 = false;
      }
      else
      {
        bolt2 = false;
      }
    }
  }

  /* String examine method passed through the Door to    
   * display the message encountering the door with two
   * deadbolts.
   * @return String of when you first encountered with the 
   * door
   */
  @Override
  public String examine()
  {
    String returnString = "A door with two deadbolts." + "\nBoth need to be unlocked for the door to open,\nbut you can't tell if they are locked or unlocked";
    return returnString;
  }

  /* String menu method passed through the Door to display 
   * option for that particular door Toggle bolt 1 or Toggle 
   * bolt 2. 
   * @return String the interaction options with the door. 
   */
  @Override
  public String menu()
  {
    String returnString = "1. Toggle Bolt 1 \n2. Toggle Bolt 2";
    return returnString;
  }

  /* String unlock method passed through the Door to 
   * then check with the user option to get whether they 
   * have succesfully unbolted the two bolts.  
   *
   * @param option Option user picked for interacting with the door 
   * @return String the user choosen option interacting   
   * with the door. 
   */
  @Override
  public String unlock(int option)
  {
    final int TOGGLE_BOLT1 = 1;
    final int TOGGLE_BOLT2 = 2;

    if (option == TOGGLE_BOLT1)
    {
      bolt1 = !bolt1;
      return new String("You toggle the first bolt. \n");
    }
    else if (option == TOGGLE_BOLT2)
    {
      bolt2 = !bolt2;
      return new String("You toggle the second bolt. \n");
    }
    else
    {
      return new String("Invalid input!");
    }
  }

  /* Boolean method open passed through to the door and   
   * will return if user input was valid
   * @return bolt1 and bolt2 when both are true 
   */
  @Override
  public boolean open()
  {
    //If the user enters a valid input then the door will open
    return bolt1 && bolt2; 
  }

  /* String method clue passed to door and display the status of the bolt
   * @return String the current status of the two bolts
   */
  @Override
  public String clue()
  {
    if (bolt1 || bolt2)
    {
      return new String("One of the bolts is in the correct position.");
    }
    else
    {
      return new String("No bolts are in the correct position.");
    }
    
  }

  /* String method success passed to door and display
   * to the user if the door was succesfully opened
   * @return String Opened door
   */
  @Override
  public String success()
  {
    return new String("The door slides open and you are able to galavantly skip through!");
  }
}