package conways.game.of.life;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * A custom JPanel where the world is drawn.
 * @author ssyl55
 */
public class Surface extends JPanel implements ActionListener
{    
    // used for animation and graphics.
    private int delay = 50;
    private Timer timer;
    private Color cellColor;
    
    // flags to control the execution of the simulation.
    private boolean isRunning;
    private boolean addCell;
    
    // world data
    private World world;
    private int unit;  // the size of each cell.
    private int width;
    private int height;
    
    private static int generation;
    private static int currentlyAlive;
    private static int total;
    private static double density;
    
    /**
     * Initializes the surface object.
     */
    public Surface()
    {   
        // initialize the world.
        width = 40;
        height = 40;
        unit = 16;
        cellColor = Color.BLACK;
        
        world = new World(width, height);
        world.populateWorld();
        world.randomInitialize();
        
        isRunning = false;
        addCell = true;
        
        generation = 0;
        currentlyAlive = 0;
        total = 0;
        density = 0;
        
        // initialize graphical properties.
        initSurface();
    }
    
    /**
     * Initializes the surface object by setting the properties of the 
     * object and starting the timer for animation.
     */
    private void initSurface()
    {
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        
        timer = new Timer(delay, this);
        timer.start();
    }
    
    /**
     * Custom drawing.
     * @param g the graphics object to draw with.
     */
    private void draw(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(cellColor);
        
        // world drawing.
        int wWidth = world.getWidth();
        int wHeight = world.getHeight();
        Cell[][] grid = world.getState();
        
        for (int row = 1; row < wHeight - 1; row++)
        {
            for (int col = 1; col < wWidth; col++)
            {
                int state = grid[row][col].getState();
                if (state == 1)     // only draw live cells.
                {
                    g2.fillRect(col * unit, row * unit, unit, unit);
                }
                /*else if (state == 0)
                {
                    g2.drawRect(col * unit, row * unit, width, height);
                }*/
            }
        }
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    /**
     * Starts a new simulation instance, randomly populating the world.
     * @param newWidth the new width of the world.
     * @param newHeight the new height of the world.
     */
    public void startNewSimulation(int newWidth, int newHeight)
    {
        width = newWidth;
        height = newHeight;
        world = new World(width, height);
        world.populateWorld();
        world.randomInitialize();
        repaint();
    }
    
    /**
     * Starts a new blank simulation.
     * @param newWidth the new width of the world.
     * @param newHeight the new height of the world. 
     */
    public void startBlankWorld(int newWidth, int newHeight)
    {
        width = newWidth;
        height = newHeight;
        world = new World(width, height);
        world.populateWorld();
        repaint();
    }
    
    /**
     * Starts a new simulation from a loaded world state.
     * @param newWorld the new world to display.
     */
    public void startLoadedWorld(World newWorld)
    {
        width = newWorld.getWidth();
        height= newWorld.getHeight();
        world = newWorld;
        int cellSize = 16;
        
        switch (width)
        {
            case 40:
                cellSize = 16;
                break;
            case 50:
                cellSize = 13;
                break;
            case 100:
                cellSize = 6;
                break;
            case 200:
                cellSize = 3;
                break;
        }
        
        setCellSize(cellSize);
        
        repaint();
    }
    
    /**
     * Turns the cell on or off at the given coordinates.
     * @param x the x coordinate of the screen.
     * @param y the y coordinate of the screen.
     */
    public void toggleCell(double x, double y)
    { 
        Point p = this.getLocationOnScreen();
        double relX = x - p.getX();
        double relY = y - p.getY();
        int col = (int) Math.floor(relX / unit);
        int row = (int) Math.floor(relY / unit);

        if (addCell == true)
        {
            try
            {
                world.getState()[row][col].setState(1);
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
            }
            catch (Exception e)
            {
            }
        }
        else if (addCell == false)
        {
            try
            {
                world.getState()[row][col].setState(0);
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
            }
            catch (Exception e)
            {
            }
        }
        
        repaint();
    }
    
    /**
     * Sets the size of the unit; used when adjusting the size of the world.
     * @param size the new size of the unit.
     */
    public void setCellSize(int size)
    {
        unit = size;
    }
    
    /**
     * Returns the world width.
     * @return the width of the world.
     */
    public int getWorldWidth()
    {
        return width;
    }
    
    /**
     * Returns the world height.
     * @return the height of the world.
     */
    public int getWorldHeight()
    {
        return height;
    }
    
    /**
     * Returns the world.
     * @return the world in the simulation.
     */
    public World getWorld()
    {
        return world;
    }
    
    /**
     * Sets the flag on whether the simulation should keep running;
     * used for pausing and resuming the simulation.
     * @param run the boolean value determining whether the simulation should run.
     */
    public void setRunning(boolean run)
    {
        isRunning = run;
    }
    
    /**
     * Set the color of the cells drawn on the display.
     * @param newCellColor the new color to paint the cells with.
     */
    public void setCellColor(Color newCellColor)
    {
        cellColor = newCellColor;
    }   
    
    /**
     * Iterates the world forward a step.
     */
    public void iterateWorldForwards()
    {
        world.step();
        generation++;
        currentlyAlive = countCurrentlyAlive();
        incrementTotal();
        repaint();
    }
    
    /**
     * Iterates the world backwards a step.
     */
    public void iterateWorldBackwards()
    {
        try
        {
            world.iterateBackwards();
            generation--;
            decrementTotal();
            currentlyAlive = countCurrentlyAlive();
            repaint();
        }
        catch (Exception e)
        {
        }
    }
    
    /**
     * Sets the speed at which the simulation runs.
     * @param speedup
     */
    public void setSimSpeed(double speedup)
    {
        delay = (int) ((int) 50 / speedup);
        timer.setDelay(delay);
    }
    
    /**
     * Sets whether cells should be turned on of off when the user clicks the screen.
     * @param toggle the boolean value determining whether a cell should be turned on or off.
     */
    public void setAddRemoveCell(boolean toggle)
    {
        addCell = toggle;
    }
    
    /**
     * Returns the generation count of the simulation.
     * @return the generation of the simulation.
     */
    public static int getGenerationCount()
    {
        return generation;
    }
    
    /**
     * Returns the amount of cells currently alive.
     * @return the amount of cells currently alive.
     */
    public static int getCurrentlyAlive()
    {
        return currentlyAlive;
    }
    
    /**
     * Counts and returns the amount of cells currently alive in the world.
     * @return the amount of cells currently alive.
     */
    private int countCurrentlyAlive()
    {
        currentlyAlive = 0;
        for (int row = 0; row < world.getHeight(); row++)
        {
            for (int col = 0; col < world.getWidth(); col++)
            {
                currentlyAlive += world.getState()[row][col].getState();
            }
        }
        
        return currentlyAlive;
    }
    
    /**
     * Increments the total number of cells ever alive.
     */
    public void incrementTotal()
    {
        total += currentlyAlive;
    }
    
    /**
     * Decrements the total number of cells ever alive to the value
     * of the previous iteration; used for updating the simulation information
     * when iterating the simulation backwards.
     */
    public void decrementTotal()
    {
        total = total - (currentlyAlive - countCurrentlyAlive());
    }
    
    /**
     * Returns the total number of alive cells that have ever existed in the simulation.
     * @return the total number of alive cells.
     */
    public static int getTotalAlive()
    {
        return total;
    }
    
    /**
     * Calculates the density of the world at its current state.
     */
    public void calculateDensity()
    {
        density = (currentlyAlive / (double) (world.getWidth() * world.getHeight()) * 100);
    }
    
    /**
     * Returns the density of the world at its current state.
     * @return the density of the world.
     */
    public static double getDensity()
    {
        return density;
    }
    
    /**
     * Resets the information on the infoPanel; used when starting new simulations.
     */
    public static void resetInfo()
    {
        generation = 0;
        currentlyAlive = 0;
        total = 0;
        density = 0;
        InfoPanel.updatePreset("None");
    }
    
    /**
     * Overrides the paintComponent() method of the JPanel so that custom
     * drawing can be done.
     * @param g the graphics object with which to do drawing.
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }

    /**
     * Animation code.
     * @param e the event.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {          
        if (isRunning == true)
        {
            world.step();
            generation++;
            currentlyAlive = countCurrentlyAlive();
            incrementTotal();
            calculateDensity();
        }
        else if (isRunning == false)
        {
        }
        
        repaint();
    }
}