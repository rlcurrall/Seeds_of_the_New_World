import greenfoot.*;

/**
 * Merchant -   Used to display an actor that the character can interact with, does not handle any of the
 *              values associated with the treasury, merely asthetic.
 * 
 * @author Robert Currall
 * @version 17.7.14
 */
public class Merchant extends Actor
{
    /*******************************************************************************************************/
    /* FIELDS */
    /*******************************************************************************************************/
    public int waitCycle = 0;
    public int waitCounter = 0;
    
    // images used in the animation
    GreenfootImage merchant1 = new GreenfootImage("Merchant.png");
    GreenfootImage merchant2 = new GreenfootImage("Merchant-right.png");
    GreenfootImage merchant3 = new GreenfootImage("Merchant-left.png");
    
    /*******************************************************************************************************/
    /* METHODS */
    /*******************************************************************************************************/
    /**
     * Act - change the image of the actor periodically so it doesn't look static.
     */
    public void act() 
    {
        if ( waitCounter == 100 ) {
            if ( waitCycle == 0 ) {
                setImage( merchant1 );
                waitCycle++;
            } else if ( waitCycle == 1 ) {
                setImage( merchant3 );
                waitCycle++;
            } else if ( waitCycle == 2 ) {
                setImage( merchant1 );
                waitCycle++;
            } else if ( waitCycle == 3 ) {
                setImage( merchant2 );
                waitCycle = 0;
            } // end nested if-else block
            waitCounter = 0;
        } // end if
        else {
            waitCounter++;
        } // end else
    } // end act method
} // end Merchant class
