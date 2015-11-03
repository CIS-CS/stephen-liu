
/**
 * Write a description of class ChessBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChessBoard
{
    private int rows = 8;
    private int columns = 8;
    private String[][] board;
    
    public ChessBoard()
    {
        board = new String[rows][columns];
    }
    
    public void populate()
    {
        for (int row = 0; row < rows; row++)
        {
            for (int column = 0; column < columns; column++)
            {
                board[row][column] = "x";
            }
        }
    }
    
    public void populatePattern()
    {
        String x = "x";
        String o = "o";
        String cell = "";
        
        
    }
    
    public void print()
    {
        for (int row = 0; row < rows; row++)
        {
            for (int column = 0; column < columns; column++)
            {
                System.out.print(board[row][column]);
            }
            System.out.println();
        }
    }
}
