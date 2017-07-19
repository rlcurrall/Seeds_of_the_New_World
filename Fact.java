import greenfoot.*;
import java.awt.*;

/**
 * Write a description of class Fact here.
 * 
 * @author Robert Currall
 * @version 17.7.16
 */
public class Fact extends Actor
{
    /*******************************************************************************************************/
    /* FIELDS */
    /*******************************************************************************************************/
    private int count = 600;
    
    /*******************************************************************************************************/
    /* CONSTRUCTOR */
    /*******************************************************************************************************/
    /**
     * Constructor - set the image to the text inputed by the user.
     */
    public Fact(String text) {
        setImage( new GreenfootImage( text, 14, Color.black, Color.white ) );
    } // end Fact constructor   
    
    /*******************************************************************************************************/
    /* METHODS */
    /*******************************************************************************************************/
    /**
     * Act - object will remove itself after timer runs out.
     */
    public void act() {
        if ( count == 0 ) {
            getWorld().removeObject(this);
        } else {
            count--;
        } // end else-if block
    } // end act method
    
    /**
     * getCount - return the value stored in count
     */
    public int getCount() {
        return count;
    } // end getCount method
} // end Fact class
