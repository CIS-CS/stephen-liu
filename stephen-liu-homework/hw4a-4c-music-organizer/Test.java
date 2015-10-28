import java.util.ArrayList;
/**
 * Write a description of class Test here.
 * 
 * @author Stephen Liu 
 * @version 12th January, 2015
 */
public class Test
{
    private static MusicOrganizer organizer;    // Our test music organizer object.
    
    /**
     * Creates a test music organizer, populating it with a number songs
     * and printing the contents of the organizer out.
     * 
     * This is part of the exercise 4a and 4b.
     */
    public static void main(String[] args)
    {
        organizer = new MusicOrganizer();
        populateOrganizer(100);
        organizer.listAllFiles();
        System.out.println();
    }
    
    /**
     * Populates the music organizer with a set amount of songs.
     * 
     * @param numberOfSongs - the number of songs to add.
     * 
     * This is part of the exercise 4a.
     */
    private static void populateOrganizer(int numberOfSongs)
    {
        for (int i = 0; i < numberOfSongs; i++)
        {
            organizer.addFile("song" + i);
        }
    }
    
    /**
     * Tests the search method in the music organizer class.
     * Prints out the results or "No Songs Found" if there are no matches.
     */
    public static void testSearch(String searchString)
    {
        organizer = new MusicOrganizer();
        populateOrganizer(200);
        
        ArrayList<String> results = new ArrayList<String>();
        results = organizer.search2(searchString);
        
        if (results == null)
        {
            System.out.println("No Songs Found");
        }
        else
        {
            for (String song : results)
            {
                System.out.println(song);
            }
        }
    }
}
