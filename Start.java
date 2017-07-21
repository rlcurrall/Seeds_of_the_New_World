import greenfoot.*;
import java.util.*;

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
    private int count;
    
    // images for background
    List<GreenfootImage> images = Arrays.asList(
        new GreenfootImage("tutorial_backstory.png"),
        new GreenfootImage("tutorial_characters.png"),
        new GreenfootImage("tutorial_keys.png")
    );
    
    /* CONSTRUCTORS */
    /**
     * Constructor - Set dimensions for the world
     */
    public Start()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(720, 680, 1); 
        count = 0;
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
        if ( "enter".equals( Greenfoot.getKey() ) ) {
            if (count < 3) {
                // change the background and increment count
                setBackground(images.get(count));
                count++;
            } else {
                // stop music playing
                music.stop();
                
                // change the world
                SantaElena elena = new SantaElena();
                Greenfoot.setWorld(elena);
            } // end else-if block
        } // end if block
    } // end Act method
} // end Start class
