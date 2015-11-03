
/**
 * A class that generates prime numbers.
 * 
 * @author Stephen Liu 
 * @version 4/12/14
 */
public class PrimeTester
{
    /**
     * Tests whether a given number is prime.
     * 
     * @param number the number that is being tested.
     * 
     * @return whether the number is prime.
     */
    public boolean isPrime(int number)
    {
        boolean isPrime = true;
        if (number <= 1) {
            isPrime = false;
        }
        else {
            int first = 2;
            int last = number - 1;
        
            int divisor = first;
            while (divisor <= last) {
                if ((number % divisor) == 0) {
                    isPrime = false;
                    break;
                } else {
                    divisor++;
                }
            }
        }
        
        return isPrime;
    }
    
    /**
     * Prints the prime numbers up to a given number.
     * 
     * @param lastNumber the number of primes to print.
     */
    public void printPrimes(int lastNumber) {
        int counter = 0;
        for (int i = 1; i <= lastNumber; i++) {
            if (isPrime(i) == true) {
                System.out.println(i);
                counter++;
            }
        }
        System.out.println("There are " + counter + 
                            " primes between 0 and " + lastNumber);
    }
}
