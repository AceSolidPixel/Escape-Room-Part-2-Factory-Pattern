/** Door that unlocks when the user finds the key for it under the flower pot*/
public class LockedDoor implements Door
{
  /**Location of key to open the door*/
  private int keyLocation;
  /**Location user is checking for the key to open the door*/
  private int keyChoice;
  
  /**
  Constructor - Initializes key location to under the flower pot and initial choice to invalid
                so that way the door always starts locked
  */
  public LockedDoor()
  {
    final int LOWEST_LOCATION = 1;
    final int HIGHEST_LOCATION = 3;
    keyLocation = (int) ((Math.random() * (HIGHEST_LOCATION + 1 - LOWEST_LOCATION)) + LOWEST_LOCATION);
    keyChoice = 0;
  }

  /** 
  * Displays basic description of a door being encountered.
  *
  * @return String of when you first encountered with the 
  * door
  */
  @Override
  public String examine()
  {
    String returnString = "You encounter a locked door.\n" + 
                          "A door that can be opened with a key.\n" + 
                          "Look around to see if you can find it.";
    return returnString;
  }

  /**
  * Displays options of actions user can take to open the locked door 
  *
  * @return String the interaction option with the door. 
  */
  @Override
  public String menu()
  {
    String returnString = "1. Look Under Mat \n2. Look Under Flower Pot"  + 
                          "\n3. Look Under Fake Rock";
    return returnString;
  }

  /**
  * Checks to see if the user chose the flowerpot as the correct key location and informs the user
  * of whether or not they found the key
  *
  * @param option Users choice of where to look for the key
  * @return Message describing interaction between user and search location
  */
  @Override
  public String unlock(int option)
  {
    keyChoice = option;
    return "You search that area...";
  }

  /** 
  * If the user chose to look in the place where the key was hidden the door will open.
  * 
  * @return Whether or not the door is open. 
  */
  @Override
  public boolean open()
  {
    if (keyChoice == keyLocation)
      return true;
    else
      return false;
  }

  /**
  * Returns a message helping player figure out what to do next if the door
  * didn't open.
  * 
  * @return Message giving user advice on opening door.
  */
  @Override
  public String clue()
  {
    return new String("Look somewhere else.");
  }

  /**
  * Displays success message to user of opening locked door.
  *
  * @return Success message for opening the door
  */
  @Override
  public String success()
  {
    return new String("Yay. You grab the key and unlock the door with it\n" +
                      "You step through the door with confidence!");
  } 


}