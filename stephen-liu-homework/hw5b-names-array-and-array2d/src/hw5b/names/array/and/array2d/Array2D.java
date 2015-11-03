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
public class Array2D
{
    private int[][] numbers;
    
    public static void main(String[] args)
    {
        Array2D ar2d = new Array2D();
        
        ar2d.initArray();
        IBIO.output("Displaying numbers in reverse order...");
        ar2d.displayNumbersReverseOrder();
    }
    
    private void initArray()
    {
        numbers = new int[5][10];
        int currentNum = 1;
        
        for (int row = 0; row < numbers.length; row++)
        {
            for (int col = 0; col < numbers[row].length; col++)
            {
                numbers[row][col] = currentNum;
                currentNum++;
            }
        }
    }
    
    private void displayNumbersReverseOrder()
    {
        for (int row = numbers.length - 1; row >= 0; row--)
        {
            for (int col = numbers[row].length - 1; col >= 0; col--)
            {
                IBIO.output(numbers[row][col]);
            }
        }
    }
}