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
    int level = 0;
    int cost;
    
    /*******************************************************************************************************/
    /* CONSTRUCTOR */
    /*******************************************************************************************************/
    public Cost(String job) {
        this.job = job;
        calcCost();
        display();
    } // end Cost constructor
    
    /*******************************************************************************************************/
    /* METHODS */
    /*******************************************************************************************************/
        
    /**
     * calcCost - calculate the cost of giving the worker a raise
     */
    private void calcCost() {
        if (job == "Farmer") {
            cost = 200 * (level + 1);
        } else if (job == "Blacksmith") {
            cost = 400 * (level + 1);
        } else if (job == "Merchant") {
            cost = 800 * (level + 1);
        } // end else-if block
    } // end calcCost method
    
    /**
     * display - update the image of the object to show the cost to give the worker a raise
     */
    private void display() {
        Color background = new Color(0xffcc66);
        setImage( new GreenfootImage("Cost: " + cost + " Reals" , 12, Color.black, background));
    } // end display method
    
    /**
     * setLevel -   public function that allows user to set the level, and updates the values.
     */
    public void setLevel(int newLevel) {
        level = newLevel;
        calcCost();
        display();
    } // end setLevel method
} // end Cost class
