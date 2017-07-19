import greenfoot.*;
import java.awt.*;

/**
 * Tax -    Used to display the monthly income tax for a given worker.
 * 
 * @author Robert Currall 
 * @version 17.7.14
 */
public class Tax extends Actor
{
    /*******************************************************************************************************/
    /* FIELDS */
    /*******************************************************************************************************/
    String job;
    int level = 1;
    int tax;
    Color background = new Color(0xffcc66);
    
    /*******************************************************************************************************/
    /* CONSTRUCTOR */
    /*******************************************************************************************************/
    /**
     * Constructor - Sets the job to the inputted value, calculates the amount of taxes the worker currently
     *               pays monthly and displays the amount to the screen
     */
    public Tax(String job, int tax) {
        this.job = job;
        this.tax = tax;
        display();
    } // end Tax constructor
    
    /*******************************************************************************************************/
    /* METHODS */
    /*******************************************************************************************************/
        
    /**
     * calcTax - calculate the montly income tax collected from worker
     */
    private void calcTax() {
        if (job == "Farmer") {
            tax = 50 * level;
        } else if (job == "Blacksmith") {
            tax = 100 * level;
        } else if (job == "Merchant") {
            tax = 200 * level;
        } // end else-if block
    } // end calcCost method
    
    /**
     * display - update the image of the object to show the tax collected each month
     */
    private void display() {
        setImage( new GreenfootImage("Montly Taxes:     " + tax + " Reals", 14, Color.black, background));
    } // end display method
    
    /**
     * setLevel -   public function that allows user to set the level, and updates the values.
     */
    public void setLevel(int newLevel, int tax) {
        level = newLevel;
        this.tax = tax;
        display();
    } // end setLevel method
} // end Tax class
