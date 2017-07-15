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
    int level = 1;
    int value;
    Color background = new Color(0xffcc66);
    
    /*******************************************************************************************************/
    /* CONSTRUCTOR */
    /*******************************************************************************************************/
    public Value(String job) {
        this.job = job;
        calcValue();
        display();
    } // end Value constructor
    
    /*******************************************************************************************************/
    /* METHODS */
    /*******************************************************************************************************/
        
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
    
    /**
     * setLevel -   public function that allows user to set the level, and updates the values.
     */
    public void setLevel(int newLevel) {
        level = newLevel;
        calcValue();
        display();
    } // end setLevel method
} // end Value class
