/**
 * Read web server data and analyse
 * hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    
    /**
     * ALL METHODS BELOW ARE PART OF EXERCISE 4g:
     */
    
    /**
     * Return the number of accesses recorded in the log file.
     * 
     * @return The total number of log accesses.
     */
    public int numberOfAccesses()
    {
        int total = 0;
        for (int i = 0; i < hourCounts.length; i++)
        {
            total += hourCounts[i];
        }
        
        return total;
    }
    
    /**
     * Returns the busiest hour of the log file.
     * 
     * @return The busiest hour of the log file.
     */
    public int busiestHour()
    {
        int maxIndex = 0;
        int maxHour = hourCounts[0];
        
        for (int current = 0; current < hourCounts.length; current++)
        {
            if (hourCounts[current] > maxHour)
            {
                maxHour = hourCounts[current];
                maxIndex = current;
            }
        }
        
        return maxIndex;
    }
    
    /**
     * Returns the quietest hour of the log file.
     * 
     * @return The quietest hour of the log file.
     */
    public int quietestHour()
    {
        int minIndex = 0;
        int minHour = hourCounts[0];
        
        for (int current = 0; current < hourCounts.length; current++)
        {
            if (hourCounts[current] < minHour)
            {
                minHour = hourCounts[current];
                minIndex = current;
            }
        }
        
        return minIndex;
    }
    
    /**
     * Returns the busiest two hour period of the log file.
     * 
     * @return The busiest two hour period of the log file.
     */
    public int[] busiestTwoHours()
    {
        int sum1 = hourCounts[0] + hourCounts[1];
        int[] busiestIndex = new int[2];
        
        for (int i = 0; i < hourCounts.length - 1; i++)
        {
            int sum2 = hourCounts[i] + hourCounts[i + 1];
            if (sum2 > sum1)
            {
                sum1 = sum2;
                busiestIndex[0] = i;
                busiestIndex[1] = i + 1;
            }
        }
        
        return busiestIndex;
    }
}
