package conways.game.of.life;

/**
 * A node in the stack.
 * @author ssyl55
 */
public class StackNode
{
    private Cell[][] data;
    private StackNode prev;
    
    /**
     * Initializes the stack node with world state data.
     * @param data world state data
     */
    public StackNode(Cell[][] data)
    {
        this.data = data;
    }
    
    /**
     * Sets the stack node's data to the world state.
     * @param data world state data
     */
    public void setData(Cell[][] data)
    {
        this.data = data;
    }
    
    /**
     * Returns the data from the stack node.
     * @return the data from the stack node.
     */
    public Cell[][] getData()
    {
        return data;
    }
    
    /**
     * Sets the previous node.
     * @param prev the previous node.
     */
    public void setPrev(StackNode prev)
    {
        this.prev = prev;
    }
    
    /**
     * Returns the previous node.
     * @return the previous node.
     */
    public StackNode getPrev()
    {
        return prev;
    }
}