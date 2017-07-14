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
    int level;
    int tax;
    Color background = new Color(0xffcc66);
    
    /*******************************************************************************************************/
    /* CONSTRUCTOR */
    /*******************************************************************************************************/
    public Tax(String job) {
        this.job = job;
    } // end Tax constructor
    
    /*******************************************************************************************************/
    /* METHODS */
    /*******************************************************************************************************/
    /**
     * Act - do whatever the Cost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getLevel();
    }
    
    /**
     * getLevel - get the level of the worker from the SantaElena world
     */
    private void getLevel() {
        int oldLevel = level;
        if (job == "Farmer") {
            level = ((SantaElena) getWorld()).getLevelFarmer();
        } else if (job == "Blacksmith") {
            level = ((SantaElena) getWorld()).getLevelBlacksmith();
        } else if (job == "Merchant") {
            level = ((SantaElena) getWorld()).getLevelMerchant();
        } // end else-if block
        
        // update background if the level has changed
        if (level != oldLevel) {
            calcTax();
            display();
        } // end if
    } // end getLevel method
    
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
        setImage( new GreenfootImage("Montly Taxes:\t" + tax + " Reals", 12, Color.black, background));
    } // end display method
} // end Tax class
