import greenfoot.*;

/**
 * Write a description of class Tutorial here.
 * 
 * @author Robert Currall
 * @version 17.7.20
 */
public class Tutorial extends World
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
     * Constructor - Sets the dimensions of the world.
     * 
     */
    public Tutorial()
    {    
        super(720, 680, 1);
    } // end Tutorial constructor
    
    /*******************************************************************************************************/
    /* METHODS */
    /*******************************************************************************************************/
    /**
     * Act - Check if player pressed the ENTER key, if so move to the next world.
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
            SantaElena santaElena = new SantaElena();
            Greenfoot.setWorld(santaElena);
        } // end if        
    } // end act method
} // end Tutorial class
