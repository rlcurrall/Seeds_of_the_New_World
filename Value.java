import greenfoot.*;
import java.awt.*;

/**
 * Value -      Used to display the of a worker's business if it were liquidated, used primarily with the 
 *              closeBusiness function.
 * 
 * @author Robert Currall 
 * @version 17.7.14
 */
public class Value extends Actor
{
    /*******************************************************************************************************/
    /* FIELDS */
    /*******************************************************************************************************/
    String job;
    int level;
    int value;
    Color background = new Color(0xffcc66);
    
    /*******************************************************************************************************/
    /* CONSTRUCTOR */
    /*******************************************************************************************************/
    public Value(String job) {
        this.job = job;
    } // end Value constructor
    
    /*******************************************************************************************************/
    /* METHODS */
    /*******************************************************************************************************/
    /**
     * Act - do whatever the Value wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getLevel();
        calcValue();
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
     * calcValue - calculate the value of a business at its current level
     */
    private void calcValue() {
        if (job == "Farmer") {
            value = 100 + 10 * level;
        } else if (job == "Blacksmith") {
            value = 200 + 20 * level;
        } else if (job == "Merchant") {
            value = 400 + 40 * level;
        } // end else-if block
    } // end calcValue method
    
    /**
     * display - update the image of the object to show the value of the business in the case the user
     *           sells the business.
     */
    private void display() {
        setImage( new GreenfootImage("Business Value: " + value + " Reals", 12, Color.black, background));
    } // end display method    
} // end Value class
