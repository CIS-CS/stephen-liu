package conways.game.of.life;

import java.util.Random;

/**
 * The world that holds the cells of the simulation.
 * @author ssyl55
 */
public class World
{   
    private int width;
    private int height;
    private Cell[][] grid;
    
    // utility imports
    private Random random;
    private Stack stack;
    
    /**
     * Initializes the world state.
     * @param width the width of the world.
     * @param height the height of the world.
     */
    public World(int width, int height)
    {
        this.width = width;
        this.height = height;
        grid = new Cell[width][height];
        
        random = new Random();
        stack = new Stack();
    }
    
    /**
     * Populates the world by adding a cell object that is in the "off" state 
     * at each position on the world grid.
     */
    public void populateWorld()
    {
        for (int row = 0; row < height; row++)
        {
            for (int col = 0; col < width; col++)
            {
                grid[row][col] = new Cell(row, col, 0);
            }
        }
    }
    
    /**
     * Populates the world with an initial state that is passed into the method.
     * Used to initialize the world to certain presets.
     * @param initialState the initial state of the world.
     */
    public void populateWorld(Cell[][] initialState)
    {
        grid = initialState;
    }
    
    /**
     * Randomly initializes the state of the world.
     */
    public void randomInitialize()
    {
        int numberOfTimes = random.nextInt(((width - 2) * (height - 2)) / 2) + 1;
        //System.out.println(numberOfTimes);
        
        String positions = ""; // attempt to control overlapping.
            
        for (int i = 0; i < numberOfTimes; i++)
        {
            int row = random.nextInt(height - 2) + 1;
            int col = random.nextInt(width - 2) + 1;
            
            String pos = Integer.toString(row) + Integer.toString(col) + ";";
            
            if (positions.contains(pos))
            {
                row = random.nextInt(height - 2) + 1;
                col = random.nextInt(width - 2) + 1;
            }
            
            positions = positions + pos;
            
            try
            {
                grid[row][col].setState(1);
            }
            catch (Exception e)
            {
            }
        }
    }
    
    /**
     * Steps to the next iteration of the simulation by calling the evolve method
     * on every cell in the grid.
     */
    public void step()
    {
        // create a copy of the world for all the cells to read from.
        World tempWorld = new World(width, height);
        tempWorld.populateWorld(this.getState());
        
        // create and initialize a grid to write to so that the cells
        // don't change the world itself, affecting the evolution of other cells.
        Cell[][] writeGrid = new Cell[width][height];
        for (int gRow = 0; gRow < height; gRow++)
        {
            for (int gCol = 0; gCol < width; gCol++)
            {
                writeGrid[gRow][gCol] = new Cell(gRow, gCol, 0);          
            }
        }
        
        for (int row = 1; row < height - 1; row++)
        {
            for (int col = 1; col < width - 1; col++)
            {
                grid[row][col].evolve(tempWorld, writeGrid);
            }
        }
        
        // reset the grid.
        grid = writeGrid;
        
        // push new grid onto the stack.
        stack.push(grid);
    }
    
    /**
     * Iterates the world back a step.
     * @throws Exception if there are no more previous states of the world.
     */
    public void iterateBackwards() throws Exception
    {
        try
        {
            grid = stack.pop();
        }
        catch (Exception e)
        {
            throw new Exception();
        }
    }
    
    /**
     * Returns the width of the world.
     * @return the width of the world.
     */
    public int getWidth()
    {
        return width;
    }
    
    /**
     * Returns the height of the world.
     * @return the height of the world.
     */
    public int getHeight()
    {
        return height;
    }
    
    /**
     * Sets a new world width.
     * @param width the new width of the world.
     */
    public void setWidth(int width)
    {
        this.width = width;
    }
    
    /**
     * Sets a new world height.
     * @param height the new height of the world.
     */
    public void setHeight(int height)
    {
        this.height = height;
    }
    
    /**
     * Returns the world grid.
     * @return the world grid.
     */
    public Cell[][] getState()
    {
        return grid;
    }
}