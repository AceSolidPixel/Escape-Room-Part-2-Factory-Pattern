/** Interface that holds function headers for functions all doors should have
*/
public interface Door
{
  /**Gives description of door
  *
  * @return Description of the door being inspected
  */
  public String examine();

  /**Provides menu of options for user to choose from to interact with door
  *
  * @return Menu that the user can interact with to open door 
  */
  public String menu();

  /**
  * Carries out interaction between user and door that is described in string
  * 
  * @param option Option user picked for interacting with the door
  * @return String describing interaction between thge user and door 
  */
  public String unlock(int option);

  /**Checks whether the door can be opened
  *
  * @return True if the door can be opened, else false
  */
  public boolean open();

  /**Gives clue of how to open the door
  *
  * @return String describing hint of how to open the door
  */
  public String clue();

  /**
  * Gives congratulatory message to user if they manage to open the door
  * 
  * @return Congratulatory message for opening the door
  */ 
  public String success();
}