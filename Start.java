import greenfoot.*;

/**
 * Start: creates the start screen for the game and plays the intro music "friends.mp3", changes the screen
 *        to the SantaElena world when the user presses enter.
 * 
 * @author Robert Currall 
 * @version 17.7.11
 */
public class Start extends World
{
    /* FIELDS */
    // add music variable
    GreenfootSound music = new GreenfootSound( "friends.mp3" );
    
    /* CONSTRUCTORS */
    /**
     * Constructor - Set dimensions for the world
     */
    public Start()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(720, 680, 1); 
    } // end Start constructor
    
    /* METHODS*/
    /**
     * Act: Plays background music for game start screen.
     */
    public void act() {
        // start music
        music.setVolume(10);
        music.playLoop();
        
        // start the game & end the music when user presses enter
        if ( "enter".equals( Greenfoot.getKey() )) {
            // stop the music
            music.stop();
            // change the world to begin the game
            startGame();
        }
    } // end Act method
    
    /**
     * startGame: Will change world to the SantaElena world when called
     */
    public void startGame() {
        Backstory back = new Backstory();
        Greenfoot.setWorld(back);
    } // end startGame method
} // end Start class
