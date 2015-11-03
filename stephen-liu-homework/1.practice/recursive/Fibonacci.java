/**
 * Write a description of class Fibonacci here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fibonacci
{
    public int recursiveFibonacci(int n)
    {
        int result = 0;
        if (n <= 2)
        {
            result = 1;            
        }  
        else
        {
            result = (recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2));
        }
        
        return result;
    }
    
    public int iterativeFibonacci(int n)
    {
        int result = 0;
        if (n <= 2)
        {
            result = 1;
        }
        else
        {
            int previous = 1;
            int prevPrevious = 0;
            for (int i = 2; i <= n; i++)
            {
                result = previous + prevPrevious;
                prevPrevious = previous;
                previous = result;
            }
        }
        
        return result;
    }
}
