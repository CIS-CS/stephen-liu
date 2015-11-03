
/**
 * A class to manage screen objects.
 * 
 * @author Stephen Liu
 * @version 2014/09/29
 */
public class ScreenManager
{
   Screen testScreen;
   
   /**
    * Constructor for the ScreenManager class. It creates a new screen with
    * the resolution that the user passes in.
    * 
    * @param xRes the horizontal resolution of the screen.
    * @param yRes the vertical resolution of the screen.
    */
   public ScreenManager(int xRes, int yRes)
   {
       testScreen = new Screen(xRes, yRes);
    }
   
   /**
    * Clears the screen if the number of pixels on the screen is greater
    * than 2 million. Otherwise, print out an error message.
    */
   public void clearScreen()
   {     
       if (testScreen.getPixelCount() > 2000000)
       {
           testScreen.clearScreen();
       } 
       else
       {
           System.out.println("Screen pixel count is less than 2 million");
       }
   }
}
