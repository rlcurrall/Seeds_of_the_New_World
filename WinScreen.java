import greenfoot.*;

/**
 * Write a description of class WinScreen here.
 * 
 * @author Robert Currall 
 * @version 17.7.16
 */
public class WinScreen extends World
{
    /*******************************************************************************************************/
    /* FIELDS */
    /*******************************************************************************************************/
    // add music variable
    GreenfootSound music = new GreenfootSound( "friends.mp3" );
    
    /*******************************************************************************************************/
    /* CONSTRUCTOR */
    /*******************************************************************************************************/
    /**
     * Constructor - Sets the dimensions of the world
     */
    public WinScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(720, 680, 1); 
    } // end WinScreen constructor
    
    /*******************************************************************************************************/
    /* METHODS */
    /*******************************************************************************************************/
    /**
     * Act - Check if player pressed the ENTER key, if so restart the game.
     */
    public void act() {
        // start music
        music.setVolume(10);
        music.playLoop();
        
        // check if player pressed the ENTER key
        if ( "enter".equals( Greenfoot.getKey() )) {
            // stop the music
            music.stop();
            
            // change the world
            Start start = new Start();
            Greenfoot.setWorld(start);
        } // end if        
    } // end act method
} // end WinScreen class
