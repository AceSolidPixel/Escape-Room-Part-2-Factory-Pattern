/** Door that opens when a correct combination is guessed by the user between 1 and 10 */
public class ComboDoor implements Door
{
  /** Combination value that the user has to guess */
  private int comboValue;
  /** Users guess of what the combination is that opens the door */
  private int guess;

  /**
  *Constructor - Initializes comboValue to 7 because its my favorite number and guess to 0
  *              so the initialized guess is definitely incorrect.
  */
  public ComboDoor()
  {
    final int LOWEST = 1;
    final int HIGHEST = 10;
    comboValue = (int) ((Math.random() * (HIGHEST + 1 - LOWEST)) + LOWEST);
    guess = 0;
  }
  
  /** 
  * Returns a description of the door being encountered.
  *
  * @return Description of door being encountered
  */
  @Override
  public String examine()
  {
    String returnString = "You encounter a combination door.\n" + 
                          "A door wiht a combination lock.\n" + 
                          "You can spin the dial to a number 1-10.";
    return returnString;
  }

  /**
  * Returns string prompting the user to enter a number 1-10 for combo guess.
  *
  * @return String prompting combination guess
  */
  @Override
  public String menu()
  {
    String returnString = "Enter #1-10: ";
    return returnString;
  }

  /**
  * Returns a string informing the user their guess was input.
  *
  * @param option User's guess of combination
  * @return Input confirmation for user.
  */
  @Override
  public String unlock(int option)
  {
    final int HIGHEST_NUMBER = 10;
    if (option > HIGHEST_NUMBER)
    {
      return new String("Invalid Guess!");
    }
    guess = option;
    return new String("You turn the dial...");
  }

  /** 
  * Returns true if the user input the correct combo value, thus unlocking the door
  *
  * @return Whether or not the door was unlocked 
  */
  @Override
  public boolean open()
  {
    return guess == comboValue;
  }

  /**
  * Returns hint of if the combo value is higher or lower than the users guess
  * 
  * @return Hint for user
  */
  @Override
  public String clue()
  {
    if (guess < comboValue)
    {
      return new String("You feel the lock losing resistance as you turn the dial, it must be higher");
    }
    else
    {
      return new String("You feel the lock gaining resistance as you turn the dial, it must be lower");
    }
  }

  /**
  * Returns a string informing the user they successfully made it through the door.
  * 
  * @return Success message
  */
  @Override
  public String success()
  {
    return new String("Congratulations, you opened a door.");
  }
}