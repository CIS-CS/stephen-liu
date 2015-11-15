package conways.game.of.life;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * A Custom JPanel to continuously update labels that display simulation information.
 * @author ssyl55
 */
public class InfoPanel extends JPanel implements ActionListener
{
    // animation
    private Timer timer;
    private int delay;
    
    // information
    private JLabel simInfo;
    private JLabel generation;
    private JLabel currentlyAlive;
    private JLabel totalAlive;
    private JLabel density;
    private static JLabel preset;
    
    /**
     * Initializes the infoPanel object.
     */
    public InfoPanel()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        simInfo = new JLabel("Simulation Information:");
        generation = new JLabel("Generation: ");
        preset = new JLabel("Preset: None");
        currentlyAlive = new JLabel("Currently Alive: ");
        totalAlive = new JLabel("Total Cells Created: ");
        density = new JLabel("Density: ");
        
        add(simInfo);
        this.add(Box.createVerticalGlue());
        add(generation);
        this.add(Box.createVerticalGlue());
        add(preset);
        this.add(Box.createVerticalGlue());
        add(currentlyAlive);
        this.add(Box.createVerticalGlue());
        add(totalAlive);
        this.add(Box.createVerticalGlue());
        add(density);
        
        // configure and start the timer.
        delay = 25;
        timer = new Timer(delay, this);
        timer.start();
    }
    
    /**
     * Formats integers to be displayed so commas are included at each thousand.
     * @param num the number to format.
     * @return a formatted string of the integer.
     */
    private String format(int num)
    {
        return NumberFormat.getIntegerInstance().format(num);
    }
    
    /**
     * Updates the generation number displayed on the panel.
     * @param generation the generation number.
     */
    public void updateGeneration(int generation)
    {
        this.generation.setText("Generation: " + format(generation));
        repaint();
    }
    
    /**
     * Updates the display showing the count of the cells currently alive.
     * @param currentlyAlive the number of currently alive cells.
     */
    public void updateCurrentAlive(int currentlyAlive)
    {
        this.currentlyAlive.setText("Current Alive: " + format(currentlyAlive));
    }
    
    /**
     * Updates the label displaying the preset of the world on the panel.
     * @param presetText the text to display for the preset label.
     */
    public static void updatePreset(String presetText)
    {
        preset.setText("Preset: " + presetText);
    }
    
    /**
     * Updates the label displaying the total number of cells that have ever been alive.
     * @param totalAlive the total number of alive cells.
     */
    public void updateTotal(int totalAlive)
    {
        this.totalAlive.setText("Total Cells Created: " + format(totalAlive));
    }
    
    /**
     * Updates the label displaying the current density of the world.
     * @param newDensity the density of the world.
     */
    public void updateDensity(double newDensity)
    {
        newDensity = Math.floor(newDensity * 100) / 100;
        density.setText("Density: " + newDensity + "%");
    }
    
    /**
     * Custom drawing.
     * @param g the graphics object with which to do drawing.
     */
    private void draw(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * Overrides the paintComponent() method of the JPanel so that custom
     * drawing can be done.
     * @param g the graphics object with which to do drawing.
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }
    
    /**
     * Animation code
     * @param e the event.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        updateGeneration(Surface.getGenerationCount());
        updateCurrentAlive(Surface.getCurrentlyAlive());
        updateTotal(Surface.getTotalAlive());
        updateDensity(Surface.getDensity());
        repaint();
    }
}
