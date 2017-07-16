import greenfoot.*;

/**
 * Farmer -     Used to display an actor that the character can interact with, does not handle any of the
 *              values associated with the treasury, merely asthetic.
 * 
 * @author Robert Currall 
 * @version 17.7.14
 */
public class Farmer extends Actor
{
    /*******************************************************************************************************/
    /* FIELDS */
    /*******************************************************************************************************/
    public int waitCycle = 0;
    public int waitCounter = 0;
    
    // images to be used in the animation
    GreenfootImage farmer1 = new GreenfootImage("Farmer.png");
    GreenfootImage farmer2 = new GreenfootImage("Farmer-right.png");
    GreenfootImage farmer3 = new GreenfootImage("Farmer-left.png");
    
    /*******************************************************************************************************/
    /* METHODS */
    /*******************************************************************************************************/
    /**
     * Act - change the image of the actor periodically so it doesn't look static.
     */
    public void act() 
    {
        if ( waitCounter == 80 ) {
            if ( waitCycle == 0 ) {
                setImage( farmer1 );
                waitCycle++;
            } else if ( waitCycle == 1 ) {
                setImage( farmer3 );
                waitCycle++;
            } else if ( waitCycle == 2 ) {
                setImage( farmer1 );
                waitCycle++;
            } else if ( waitCycle == 3 ) {
                setImage( farmer2 );
                waitCycle = 0;
            } // end nested if-else block
            waitCounter = 0;
        } // end if 
        else {
            waitCounter++;
        } // end else
    } // end act method
} // end Farmer class
