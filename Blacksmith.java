import greenfoot.*;

/**
 * Blacksmith - Used to display an actor that the character can interact with, does not handle any of the
 *              values associated with the treasury, merely asthetic.
 * 
 * @author Robert Currall
 * @version 17.7.14
 */
public class Blacksmith extends Actor
{
    /*******************************************************************************************************/
    /* FIELDS */
    /*******************************************************************************************************/
    private int waitCycle = 0;
    private int waitCounter = 0;
    
    // images used in animation
    GreenfootImage blacksmith1 = new GreenfootImage("Blacksmith.png");
    GreenfootImage blacksmith2 = new GreenfootImage("Blacksmith-right.png");
    GreenfootImage blacksmith3 = new GreenfootImage("Blacksmith-left.png");
    
    /*******************************************************************************************************/
    /* METHODS */
    /*******************************************************************************************************/
    /**
     * Act - change the image of the actor periodically so it doesn't look static.
     */
    public void act() 
    {
        if ( waitCounter == 50 ) {
            if ( waitCycle == 0 ) {
                setImage( blacksmith1 );
                waitCycle++;
            } else if ( waitCycle == 1 ) {
                setImage( blacksmith2 );
                waitCycle++;
            } else if ( waitCycle == 2 ) {
                setImage( blacksmith1 );
                waitCycle++;
            } else if ( waitCycle == 3 ) {
                setImage( blacksmith3 );
                waitCycle = 0;
            } // end nested if-else block
            waitCounter = 0;
        } // end if 
        else {
            waitCounter++;
        } // end else
    } // end act method
} // end Blacksmith class
