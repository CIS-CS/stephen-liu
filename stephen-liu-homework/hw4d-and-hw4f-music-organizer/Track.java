/**
 * Store the details of a music track,
 * such as the artist, title, and file name.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Track
{
    private String artist;      // The artist.
    private String title;       // The track's title.
    private String filename;    // Where the track is stored.
    
    // ADDITIONS FOR EXERCISE 4d:
    private int length;         // The length of the song. -1 for unknown length.
    private int year;           // The year the song was written. -1 for unknown year.
        
    /**
     * Constructor for objects of class Track.
     * It is assumed that the file name cannot be
     * decoded to extract artist and title details.
     * @param filename The track file. 
     */
    public Track(String filename)
    {
        this("unknown", "unknown", filename, -1, -1);
    }
    
    /**
     * Constructor for objects of class Track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param filename The track file. 
     * 
     * FOR EXERCISE 4d:
     * @param length The track length.
     * @param year The year the track was written.
     */
    public Track(String artist, String title, String filename, int length, int year)
    {
        this.artist = artist;
        this.title = title;
        this.filename = filename;
        this.length = length;
        this.year = year;
    }

    /**
     * Return the artist.
     * @return The artist.
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * Return the title.
     * @return The title.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Return the file name.
     * @return The file name.
     */
    public String getFilename()
    {
        return filename;
    }
    
    /**
    * Return details of the track: artist, title and file name.
    * @return The track's details.
    */
    public String getDetails()
    {
        return artist + ": " + title + " file: " + filename + ", length: " + 
                        length + ", Year: " + year ;
    }
    
    public String toString()
    {
        return artist + ": " + title + " file: " + filename + ", length: " + 
                        length + ", Year: " + year ;
    } 
    
    /**
     * THE METHODS BELOW ARE ADDED FOR EXERCISE 4d:
     */
    
    /**
     * Return the length of the song.
     * @return The length of the song.
     */
    public int getLength()
    {
        return length;
    }
    
    /**
     * Return the year the song was written.
     * @return The year the song was written.
     */
    public int getYear()
    {
        return year;
    }
}
