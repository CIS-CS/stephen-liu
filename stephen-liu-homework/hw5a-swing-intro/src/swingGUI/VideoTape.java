package swingGUI;

/*
 * VideoTape.java
 *
 * Created on October 21, 2006, 6:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
public class VideoTape
{
    //------------------------------------------------------- instance var's
    private String  title;      // title of the video
    private int     length;     // in minutes
    private boolean lent;       // is it lent to someone
    
    //------------------------------------------------------- constructors
    
    /**
     * No argument constructor
     */
    public VideoTape()
    {
        // initialise instance variables
        this.title  = null;
        this.length = 0;
        this.lent   = false;
    }
    /**
     * 3-arg constructor
     */
    public VideoTape(String title, int length, boolean lent)
    {
      setTitle(title);
      setLength(length);
      setLent(lent);
    }
    
    //------------------------------------------------------- Mutator methods 
    
    /**
     * set the title     
     * @param  title the video title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * set the length     
     * @param  length   The video length in minutes
     */
    public void setLength(int length)
    {
        this.length = length;
    }

    /**
     * set the status of lent     
     * @param  lent true if the video is on loan
     */
    public void setLent(boolean lent)
    {
        this.lent = lent;
    }
    
    //------------------------------------------------- Accessor methods 
    
    /**
     * Return the title     
     * @return String the video title
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * get the length
     * @return int the video length in minutes
     */
    public int getLength()
    {
        return length;
    }

    /**
     * get the status of lent
     * @return boolean lent true if the video is on loan
     */
    public boolean isLent()
    {
        return lent;
    }
    
    //-------------------------------------------------------- toString()
    
    /**
     * All Classes should override this method (derived from Object)
     *
     * @return String the VideoTape object as a String
     */
    public String toString()
    {
        return (getTitle().trim() + " - " + getLength() + " - " + isLent());
    }
}

