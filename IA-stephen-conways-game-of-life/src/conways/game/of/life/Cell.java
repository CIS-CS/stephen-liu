package conways.game.of.life;

/**
 * A cell in the simulation.
 * @author ssyl55
 */
public class Cell
{
    private int row;
    private int col;
    private int state;
        
    /**
     * Initializes the cell object with position and default off state.
     * @param row the row position of the cell.
     * @param col the column position of the cell.
     * @param state the initial state of the cell.
     */
    public Cell(int row, int col, int state)
    {
        this.row = row;
        this.col = col;
        this.state = state;
    }
    
    /**
     * Evolves the cell according to the rules of Conway's Game of Life.
     * @param writeToGrid the grid which the cell will write its state to.
     * @param temporaryWorld the world from which the cell gets its data.
     */
    public void evolve(World temporaryWorld, Cell[][] writeToGrid)
    {        
        int nextState = state;
        int numberOfAliveNeighbors = getNumberOfAliveNeighbors(temporaryWorld.getState());
        
        // decide what the next state is.
        if (state == 1)
        {
            if (numberOfAliveNeighbors == 2 || numberOfAliveNeighbors == 3)
            {
                nextState = 1;
            }
            else if (numberOfAliveNeighbors < 2)
            {
                nextState = 0;
            }
            else if (numberOfAliveNeighbors > 3)
            {
                nextState = 0;
            }
        }
        else if (state == 0)
        {
            if (numberOfAliveNeighbors == 3)
            {
                nextState = 1;
            }
        }

        // write to the write grid.
        try
        {
            writeToGrid[row][col].setState(nextState);
        }
        catch (Exception e)
        {
        }
    }
    
    /**
     * Returns the state of the cell, either on (1) or off (0).
     * @return the state of the cell.
     */
    public int getState()
    {
        return state;
    }

    /**
     * Sets the state of the cell.
     * @param state the new state of the cell.
     * @throws Exception: if the value given is not 0 or 1.
     */
    public void setState(int state) throws Exception
    {
        if ((state < 0) || (state > 1))
        {
            throw new Exception("State must be either 0 (off) or 1 (on)");
        }
        else
        {
            this.state = state;
        }
    }
    
    /**
     * Returns the number of alive cells neighboring the cell.
     * @param grid the grid from which the cell will gets its information.
     * @return the number of alive neighbors.
     */
    private int getNumberOfAliveNeighbors(Cell[][] grid)
    {  
        int numberOfAliveNeighbors = 0;
        
        int topLeft = grid[row - 1][col - 1].getState();
        int top = grid[row - 1][col].getState();
        int topRight = grid[row - 1][col + 1].getState();
        int left = grid[row][col - 1].getState();
        int right = grid[row][col + 1].getState();
        int botLeft = grid[row + 1][col - 1].getState();
        int bottom = grid[row + 1][col].getState();
        int botRight = grid[row + 1][col + 1].getState();
        
        if (topLeft == 1)
        {
            numberOfAliveNeighbors++;
        }
        if (top == 1)
        {
            numberOfAliveNeighbors++;
        }
        if (topRight == 1)
        {
            numberOfAliveNeighbors++;
        }
        if (left == 1)
        {
            numberOfAliveNeighbors++;
        }
        if (right == 1)
        {
            numberOfAliveNeighbors++;
        }
        if (botLeft == 1)
        {
            numberOfAliveNeighbors++;
        }
        if (bottom == 1)
        {
            numberOfAliveNeighbors++;

        }
        if (botRight == 1)
        {
            numberOfAliveNeighbors++;
        }
        
        return numberOfAliveNeighbors;
    }
}