
/**
 * Write a description of class TestClock here.
 * 
 * @author Stephen Liu 
 * @version 7/10/14
 */
public class TestClock
{
    private ClockDisplay testClock;
    
    public TestClock()
    {
        testClock = new ClockDisplay(12, 59, 50, true);
        testTimeTick(20);
    }
    
    public void testTimeTick(int tickLimit)
    {
        int ticks = tickLimit;
        int currentTick = 0;
        while (currentTick <= ticks) {
            System.out.println(testClock.getTime());
            testClock.timeTick();
            currentTick++;
        }
    }
}
