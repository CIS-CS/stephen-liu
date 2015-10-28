import java.util.Random;
import java.util.ArrayList;
/**
 * Write a description of class Test here.
 * 
 * @author Stephen Liu 
 * @version 12th January, 2015
 */
public class Test
{
    private static MusicOrganizer mo;   // Our test music organizer object.
    private static int totalNumberOfTracks;
    
    /**
     * Creates a test music organizer, populating it with a number tracks
     * and printing the contents of the organizer out.
     * 
     * This is part of the exercise 4d.
     */
    public static void main(String[] args)
    {
        mo = new MusicOrganizer();
        totalNumberOfTracks = 100;
        populate(totalNumberOfTracks);
        mo.listAllTracks();
        System.out.println();
        
        // ex 4f.1
        System.out.println("Printing random track:");
        printRandomTrack();
        System.out.println();
        // 4f.2
        System.out.println("Printing random tracks");
        printRandomTracks(totalNumberOfTracks);
        System.out.println();

        // 4f.3
        System.out.println("Printing all tracks exactly once in random order");
        printAllTracksOnceRandomly();
    }
    
    /**
     * Populates the music organizer with a set amount of tracks.
     * 
     * @param numberOfTracks - the number of songs to add.
     * 
     * This is part of the exercise 4d.
     */
    private static void populate(int numberOfTracks)
    {
        for (int i = 0; i < numberOfTracks; i++)
        {
            mo.addTrack(new Track("song" + i, "artist" + i, "filename" + i, i, i));
        }
    }
    
    /**
     * THE METHODS BELOW ARE PART OF EXERCISE 4f:
     */
    
    /**
     * Prints a random track.
     */
    private static void printRandomTrack()
    {
        Random rnd = new Random();
        mo.listTrack(rnd.nextInt(totalNumberOfTracks));
    }
    
    /**
     * Prints multiple tracks in random order.
     * Doesn't matter if there are any duplicates.
     * 
     * @param number - the number of tracks to print.
     */
    private static void printRandomTracks(int number)
    {
        for (int i = 0; i < number; i ++)
        {
            printRandomTrack();
        }
    }
    
    /**
     * Plays all the tracks exactly once in random order.
     */
    private static void printAllTracksOnceRandomly()
    {
        int total = mo.getTotalNumberOfTracks();
        ArrayList<Integer> trackIndices = new ArrayList<Integer>();
        Random rnd = new Random();
        int removals = 0;
        
        for (int i = 0; i < total; i++)
        {
            trackIndices.add(i);
        }
        
        while (removals != total)
        {
            int nextRandom = rnd.nextInt(trackIndices.size());
            int nextIndex = trackIndices.get(nextRandom);
            
            mo.listTrack(nextIndex);
            trackIndices.remove(nextRandom);
            removals++;
        }
    }
}
