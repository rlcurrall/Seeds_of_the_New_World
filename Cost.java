import greenfoot.*;
import java.awt.*;

/**
 * Cost -       Used to show the cost of giving a worker a raise to the next level.
 * 
 * @author Robert Currall 
 * @version 17.7.14
 */
public class Cost extends Actor
{
    /*******************************************************************************************************/
    /* FIELDS */
    /*******************************************************************************************************/
    String job;
    int level;
    int cost;
    
    /*******************************************************************************************************/
    /* CONSTRUCTOR */
    /*******************************************************************************************************/
    public Cost(String job) {
        this.job = job;
    } // end Cost constructor
    
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
        calcCost();
        display();
    }
    
    /**
     * getLevel - get the level of the worker from the SantaElena world
     */
    private void getLevel() {
        if (job == "Farmer") {
            level = ((SantaElena) getWorld()).getLevelFarmer();
        } else if (job == "Blacksmith") {
            level = ((SantaElena) getWorld()).getLevelBlacksmith();
        } else if (job == "Merchant") {
            level = ((SantaElena) getWorld()).getLevelMerchant();
        } // end else-if block
    } // end getLevel method
    
    /**
     * calcCost - calculate the cost of giving the worker a raise
     */
    private void calcCost() {
        if (job == "Farmer") {
            cost = 200 * level;
        } else if (job == "Blacksmith") {
            cost = 400 * level;
        } else if (job == "Merchant") {
            cost = 800 * level;
        } // end else-if block
    } // end calcCost method
    
    /**
     * display - update the image of the object to show the cost to give the worker a raise
     */
    private void display() {
        Color background = new Color(0xffcc66);
        setImage( new GreenfootImage("" + cost, 12, Color.black, background));
    } // end display method
} // end Cost class
