/**
* A test class to test the functionality of the music organizer.
* 
* @author Stephen Liu 
* @version 4/12/14
*/
public class Tester
{
    private static MusicOrganizer testMO;

    /**
     * The main method of the test class. Creates a new music organizer to test.
     * Runs all the tests.
     * 
     * @param args any commandline arguments.
     */
    public static void main(String args[])
    {
        testMO = new MusicOrganizer();
        
        if (args.length > 0)
        {
            populateMO(Integer.parseInt(args[0]));
        }
        else
        {
            populateMO(10);
        }
        
        displaySongsReverse();
    }
    
    /**
     * Populates the music organizer with a given number of tracks.
     * 
     * @param numberOfItems the number of music tracks to fill the music organizer with.
     */
    public static void populateMO(int numberOfItems)
    {
        for (int i = 0; i < numberOfItems; i++)
        {
            testMO.addFile("song" + i);
        }
    }
    
    /**
     * Display all the songs in the music organizer in reverse.
     */
    public static void displaySongsReverse()
    {
        for (int i = testMO.getNumberOfFiles() - 1; i >= 0; i--)
        {
            System.out.println(testMO.getFile(i));
        }
    }
}
