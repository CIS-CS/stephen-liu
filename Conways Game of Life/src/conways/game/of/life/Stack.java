package conways.game.of.life;

/**
 * The stack onto which the simulation pushes and pops world iterations.
 * @author ssyl55
 */
public class Stack
{
    // the stack pionter.
    private StackNode sp = null;
    
    /**
     * Initializes the stack.
     */
    public Stack()
    {
    }
    
    /**
     * Pushes a new world state onto the stack.
     * @param worldState the world state to be pushed onto the stack.
     */
    public void push(Cell[][] worldState)
    {
        StackNode node = new StackNode(worldState);
        node.setPrev(sp);
        sp = node;
    }
    
    /**
     * Pops a world state off of the stack.
     * @return the world state at the top of the stack.
     * @throws Exception when the stack is empty.
     */
    public Cell[][] pop() throws Exception
    {
        Cell[][] data;
        
        if (sp != null)
        {
            data = sp.getData();
            sp = sp.getPrev();
        }
        else
        {
            throw new Exception("Cannot pop: Stack is empty!");
        }
        
        return data;
    }
}