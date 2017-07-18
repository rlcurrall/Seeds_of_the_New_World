import greenfoot.*;

/**
 * Write a description of class button here.
 * 
 * @author Robert Currall
 * @version 17.7.17
 */
public class Button extends Actor
{
    /*******************************************************************************************************/
    /* CONSTRUCTOR */
    /*******************************************************************************************************/
    /**
     * Constructor - Takes a string input that determines the action associated with the key and sets the
     *               image to the key image associated with that action
     */
    public Button(String action) {
        if (action == "hire") {
            // set image to H button
            setImage(new GreenfootImage("key_h.png"));
        } else if (action == "raise") {
            // set image to R button
            setImage(new GreenfootImage("key_r.png"));
        } else if (action == "close") {
            // set image to C button
            setImage(new GreenfootImage("key_c.png"));
        } else if (action == "quit") {
            // set image to Q button
            setImage(new GreenfootImage("key_q.png"));
        } else if (action == "fact") {
            // set image to ENTER button
            setImage(new GreenfootImage("key_enter.png"));
        } else if (action == "right") {
            // set image to RIGHT arrow key
            setImage(new GreenfootImage("key_right.png"));
        } else if (action == "left") {
            // set image to LEFT arrow key
            setImage(new GreenfootImage("key_left.png"));
        } else if (action == "up") {
            // set image to UP arrow key
            setImage(new GreenfootImage("key_up.png"));
        } else if (action == "down") {
            // set image to DOWN arrow key
            setImage(new GreenfootImage("key_down.png"));
        }// end else-if block
    } // end Button constructor
} // end Button class
