
/**
 * A class representing a household heater.
 * 
 * @author Stephen Liu 
 * @version 2014/09/17
 */
public class Heater
{
    private int temperature;
    private int min;
    private int max;
    private int increment;
    
    /**
     * Sets the heater with a maximum and a minimum temperature.
     * 
     * @param max the maximum temperature allowed for the heater to go up to.
     * @param min the minimum temperature allowed for the heater to go down to.
     */
    public Heater(int max, int min)
    {
        temperature = 15;
        this.max = max;
        this.min = min;
        increment = 5;
    }
    
    /**
     * Gets the current temperature.
     * 
     * @return the current temperature.
     */
    public int getTemperature()
    {
        return temperature;
    }
    
    /**
     * Sets the increment for each time the temperature is changed.
     * 
     * @param tIncrement the incrementing value for each temperature change.
     */
    public void setIncrement(int tIncrement)
    {
        if (tIncrement <= 0) {
            return;
        }
        else {
            increment = tIncrement;
        }
    }
    
    /**
     * Tells the heater to make the temperature warmer by the set increment.
     * Checks if the temperature is already at the maximum temperature,
     * if so, then nothing happens.
     */
    public void warmer()
    {
        if (temperature >= max) {
            return;
        }
        else {
            temperature += increment;
        }
    }
    
    /**
     * Tells the heater to make the temperature cooler by the set increment.
     * Checks if the temperature is already at the minimum temperature,
     * if so, then nothing happens.
     */
    public void cooler()
    {
        if (temperature <= min) {
            return;
        }
        else {
            temperature -= increment;
        }
    }
}
