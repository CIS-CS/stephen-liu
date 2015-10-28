
/**
 * A class representing a computer screen.
 * 
 * @author Stephen Liu 
 * @version 2014/09/29
 */
public class Screen
{
    private int xRes;
    private int yRes;
    
    /**
     * Constructor for the screen object. Sets the screen resolution with
     * values passed into the constructor.
     * 
     * @param xRes the x resolution of the screen.
     * @param yRes the y resolution of the screen.
     */
    public Screen(int xRes, int yRes)
    {
        this.xRes = xRes;
        this.yRes = yRes;
    }
    
    /**
     * Returns the number of pixels on the screen.
     * 
     * @return x resolution of the screen * y resolution of the screen.
     */
    public int getPixelCount()
    {
        return xRes * yRes;
    }
    
    /**
     * Clears the screen. At this point it only prints out a string
     * indicating the screen was cleared.
     */
    public void clearScreen()
    {
        System.out.println("Screen has been cleared.");
    }
}
