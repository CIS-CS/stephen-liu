/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5b.names.array.and.array2d;
/**
 *
 * @author ssyl55
 */
public class FindMinMax
{
    private int[] numbers;
    
    public static void main(String[] args)
    {
        FindMinMax fmm = new FindMinMax();
        
        fmm.initArray();
        IBIO.output("Displaying the smallest element in the array...");
        fmm.findMin();
        IBIO.output("Displaying the largest element in the array...");
        fmm.findMax();
    }
    
    private void initArray()
    {
        numbers = new int[10];
        numbers[0] = 1;
        numbers[1] = 3;
        numbers[2] = 42;
        numbers[3] = 3545;
        numbers[4] = 34;
        numbers[5] = 23;
        numbers[6] = -345;
        numbers[7] = 7;
        numbers[8] = 34;
        numbers[9] = 54;
    }
    
    public int findMin()
    {
        int smallest = numbers[0];
        
        for (int current = 0; current < numbers.length; current++)
        {
            if (numbers[current] < smallest)
            {
                smallest = numbers[current];
            }
        }
        
        return smallest;
    }
    
    public int findMax()
    {
        int largest = numbers[0];
        
        for (int current = 0; current < numbers.length; current++)
        {
            if (numbers[current] > largest)
            {
                largest = numbers[current];
            }
        }
        
        return largest;
    }
}