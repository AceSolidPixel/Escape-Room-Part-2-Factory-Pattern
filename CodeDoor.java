/** Door that opens when the correct code has been input by the user */
public class CodeDoor implements Door
{
  /** Characters in the key of the code for the door */
  private char[] keys;
  /** The code showing on the door for the user that the user needs to alter */
  private char[] code;

  /**
  * Constructor - Initializes key to be XOX, and initial guess to be OOO so the user has to
  *               make at least 2 inputs
  */
  public CodeDoor()
  {
    final int KEY_SIZE = 3;
    keys = new char[KEY_SIZE];
    code = new char[]{'O', 'O', 'O'};
    for (int keyLooper = 0; keyLooper < KEY_SIZE; keyLooper++)
    {
      if (Math.random() < .5)
      {
        keys[keyLooper] = 'X';
      }
      else
      {
        keys[keyLooper] = 'O';
      }
    }
  }
  
  /** 
  * Returns a description of the door being encountered.
  *
  * @return Description of door being encountered
  */
  @Override
  public String examine()
  {
    String returnString = "You encounter a code door.\n" + 
                          "A door with a coded keypad with three characters.\n"
                          + "Each key toggles a value with \nX or O";
    return returnString;
  }

  /**
  * Returns options of ways user can interact with the door.
  *
  * @return Options of ways user can interact with the door
  */
  @Override
  public String menu()
  {
    String returnString = "1. Press Key 1 \n2. Press Key 2 \n3. Press Key 3";
    return returnString;
  }

  /**
  * Returns String describing interaction between user and door after user has chosen what * to do with it.
  * 
  * @param Option user chose for interacting with the door
  * @return Interaction between user and door description
  */
  @Override
  public String unlock(int option)
  {
    if (option > code.length || option < 0)
    {
      return new String("Invalid Option!");
    }
    if (code[option - 1] == 'X')
    {
      code[option - 1] = 'O';
      return new String("You press the X and it changes into an O.");
    }
    else
    {
      code[option - 1] = 'X';
      return new String("You press the O and it changes into an X.");
    }
    
  }

  /**
  * Returns true if the user has input the correct code
  *
  * @return True if the code the user has input is correct 
  */
  @Override
  public boolean open()
  {
    for (int keyLooper = 0; keyLooper < keys.length; ++keyLooper)
    {
      if (keys[keyLooper] != code[keyLooper])
      {
        return false;
      }
    } 
    return true;
  }

  /**
  * Returns hint for user. Informs of how many characters in code are correect
  *
  * @return Hint for user
  */
  @Override
  public String clue()
  {
    int numCorrect = 0;
    for (int keyLooper = 0; keyLooper < keys.length; ++keyLooper)
    {
      if (keys[keyLooper] == code[keyLooper])
      {
        ++numCorrect;
      }
    } 
    return new String("Display on the door tells you " + numCorrect + " characters are correct.");
  }

  /**
  * Returns success message for user when they get through the door.
  * 
  * @return Success message to user
  */
  @Override
  public String success()
  {
    return new String("You hear a cheerful beep. And the door swings open!");
  }
}