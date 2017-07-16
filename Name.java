import greenfoot.*;
import java.awt.*;

/**
 * Name -   Displays the name of the Worker that the player is near
 * 
 * @author Robert Currall 
 * @version 17.7.14
 */
public class Name extends Actor
{
    /*******************************************************************************************************/
    /* FIELDS */
    /*******************************************************************************************************/
    String job;
    Color background = new Color(0xffcc66);
    
    /*******************************************************************************************************/
    /* CONSTRUCTOR */
    /*******************************************************************************************************/
    /**
     * Constructor - Sets the job to the inputted value, then updates the image to show the value stored
     * in the job variable.
     */
    public Name(String job) {
        this.job = job;
        setImage( new GreenfootImage("" + job, 20, Color.black, background));
        setImage( new GreenfootImage("" + job + "\t\t", 20, Color.black, background));
    } // end Name constructor  
} // end Name class
