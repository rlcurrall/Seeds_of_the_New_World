import greenfoot.*;

/**
 * Priest -     Used to display an actor that the character can interact with, does not handle any of the
 *              values associated with the treasury, merely asthetic.
 * 
 * @author Robert Currall 
 * @version 17.7.14
 */
public class Priest extends Actor
{
    /* FIELDS */
    public int waitCycle = 0;
    public int waitCounter = 0;
    
    // images to be used in the act method for animation
    GreenfootImage priest1 = new GreenfootImage("Priest.png");
    GreenfootImage priest2 = new GreenfootImage("Priest-right.png");
    GreenfootImage priest3 = new GreenfootImage("Priest-left.png");
    
    /**
     * Act - change the image of the actor periodically so
     * it doesn't look static.
     */
    public void act() 
    {
        if ( waitCounter == 140 ) {
            if ( waitCycle == 0 ) {
                setImage( priest1 );
                waitCycle++;
            } else if ( waitCycle == 1 ) {
                setImage( priest2 );
                waitCycle++;
            } else if ( waitCycle == 2 ) {
                setImage( priest1 );
                waitCycle++;
            } else if ( waitCycle == 3 ) {
                setImage( priest3 );
                waitCycle = 0;
            } // end nested if-else block
            waitCounter = 0;
        } // end if
        else {
            waitCounter++;
        } // end else
    }    
}
