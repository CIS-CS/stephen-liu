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
public class NamesArray
{
    private static String[] names;
    
    public static void main(String[] args)
    {
        int numberOfNames = IBIO.inputInt("How many names do you want to enter?: ");
        
        names = new String[numberOfNames];
        
        for (int i = 0; i < numberOfNames; i++)
        {
            names[i] = IBIO.input("Enter a name: ");
        }
        
        IBIO.output("Displaying all names...");
        displayAllNames();
    }
    
    private static void displayAllNames()
    {
        for (int i = 0; i < names.length; i++)
        {
            IBIO.output("Name " + i + ": " + names[i]);
        }
    }
}