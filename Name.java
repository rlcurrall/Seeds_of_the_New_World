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
    public Name(String job) {
        this.job = job;
        setImage( new GreenfootImage("" + job, 14, Color.black, background));
    } // end Name constructor  
} // end Name class
