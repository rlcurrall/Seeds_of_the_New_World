import greenfoot.*;

/**
 * Write a description of class Bubble here.
 * 
 * @author Robert Currall
 * @version 17.7.17
 */
public class Bubble extends Actor
{
    /*******************************************************************************************************/
    /* FIELDS */
    /*******************************************************************************************************/
    int count = 400;
    
    /*******************************************************************************************************/
    /* METHODS */
    /*******************************************************************************************************/
    /**
     * Act - object will remove itself after timer runs out. 
     */
    public void act() 
    {
        if ( count == 0 ) {
            getWorld().removeObject(this);
        } else {
            count--;
        } // end else-if block
    } // end act method
} // end Fact class
