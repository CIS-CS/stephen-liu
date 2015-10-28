package conways.game.of.life;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Provides persistence functionality for the application; can load and save worlds.
 * @author ssyl55
 */
public class Persister
{
    private FileReader freader;
    private FileWriter fwriter;
    private BufferedReader breader;
    private PrintWriter pwriter;
    private String filename;
    
    /**
     * Initializes the persister object with the filename to the file of interest.
     * @param filename the absolute pathname of the file of interest.
     */
    public Persister(String filename)
    {
        this.filename = filename;
        freader = null;
        fwriter = null;
        breader = null;
        pwriter = null;
    }
    
    /**
     * Loads a new world from the file.
     * @return the world loaded from the file.
     */
    public World loadWorld()
    {
        int worldLength = 0;
        String line = "";
        World world = new World(0,0);
        
        try
        {
            // initialize the fileReader and the bufferedReader.
            freader = new FileReader(filename);
            breader = new BufferedReader(freader);
            
            // get the dimension of the world and create a new world with
            // that dimension.
            worldLength = Integer.parseInt(breader.readLine());
            world = new World(worldLength, worldLength);
            Cell[][] grid = new Cell[worldLength][worldLength];  
            
            // read the file line by line
            for (int row = 0; row < worldLength; row++)
            {
                line = breader.readLine();
                for (int col = 0; col < worldLength; col++)
                {
                    grid[row][col] = new Cell(row, col, Character.getNumericValue(line.charAt(col)));
                }
            }
            world.populateWorld(grid);
            //pwriter.close();
        }
        catch (IOException ioe)
        {
            die();
        }
        
        return world;
    }
    
    /**
     * Saves the current world state to a file.
     * @param world the world to save.
     */
    public void saveWorld(World world)
    {
        try
        {
            // initialize the fileWriter and the printWriter.
            fwriter = new FileWriter(filename);
            pwriter = new PrintWriter(fwriter);

            int worldLength = world.getWidth();
            Cell[][] grid = world.getState();

            // print the dimension of the world first.
            pwriter.println(worldLength);

            for (int row = 0; row < worldLength; row++)
            {
                for (int col = 0; col < worldLength; col++)
                {
                    pwriter.print(grid[row][col].getState());
                }
                pwriter.println();
            }

            pwriter.close();
        }
        catch (IOException ioe)
        {
            die();
        }
    }
    
    /**
     * Handles exceptions.
     */
    private void die()
    {
        System.out.println("Agh, I die!");
    }
}