import greenfoot.*;
import java.awt.*;

/**
 * Write a description of class Gold here.
 * 
 * @author Robert Currall 
 * @version 17.7.16
 */
public class Gold extends Actor
{
    /*******************************************************************************************************/
    /* FIELDS */
    /*******************************************************************************************************/
    int gold;
    
    Color background = new Color(0xffcc66);
    
    /*******************************************************************************************************/
    /* CONSTRUCTOR */
    /*******************************************************************************************************/
    /**
     * Constructor - sets the gold to the inputted value and sets the image to display the amount.
     */
    public Gold(int gold) {
        this.gold = gold;
        setImage( new GreenfootImage("Gold: " + gold + " Reales", 20, Color.black, background) );
    } // end Gold constructor
    
    /*******************************************************************************************************/
    /* METHODS */
    /*******************************************************************************************************/
    /**
     * Act - Sets the gold to the value stored in the SantaElena world and updates the image to display the
     *       value.
     */
    public void act() {
        gold = ((SantaElena) getWorld()).gold;
        setImage( new GreenfootImage("Gold: " + gold + " Reales", 20, Color.black, background) );
    } // end act method
} // end Gold class
