import greenfoot.*;
import java.awt.*;

/**
 * Write a description of class ButtonText here.
 * 
 * @author Robert Currall 
 * @version 17.7.17
 */
public class ButtonText extends Actor
{
    /*******************************************************************************************************/
    /* FIELDS */
    /*******************************************************************************************************/
    Color background = new Color(0xffcc66);
    
    /*******************************************************************************************************/
    /* CONSTRUCTOR */
    /*******************************************************************************************************/
    public ButtonText(String action) {
        if (action == "hire") {
            // set image to hire text
            setImage(new GreenfootImage( "Hire", 18, Color.black, background ) );
        } else if (action == "raise") {
            // set image to give raise text
            setImage(new GreenfootImage( "Give Raise", 18, Color.black, background ) );
        } else if (action == "close") {
            // set image to close business text
            setImage(new GreenfootImage( "Close Business", 18, Color.black, background ) );
        } else if (action == "quit") {
            // set image to quit text
            setImage(new GreenfootImage( "Quit Game", 18, Color.black, background ) );
        } else if (action == "fact") {
            // set image to fact text
            setImage(new GreenfootImage( "Speak with Priest", 18, Color.black, background ) );
        } // end else-if block
    } // end ButtonText constructor  
} // end ButtonText class
