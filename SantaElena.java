import greenfoot.*;

/**
 * Write a description of class SantaElena here.
 * 
 * @author Robert Currall
 * @version 7.11.17
 */
public class SantaElena extends World
{
    /* FIELDS */
    // Background music
    GreenfootSound background = new GreenfootSound( "pamfluite_loop.mp3" );
    
    // Create Player for user to control
    Player player = new Player();
    
    // Create Treasury to manage user's gold
    Treasury treasury = new Treasury();
    
    /* CONSTRUCTORS */
    /**
     * Constructor for objects of class SantaElena.
     * 
     */
    public SantaElena()
    {    
        // Create a new world with 725x580 cells with a cell size of 1x1 pixels.
        super(725, 680, 1); 
        // Run prepare to populate the world with the different objects
        prepare();
        //addObject( player, 575, 240 );
    } // end SantaElena constructor
    
    /* METHODS */
    /**
     * Act: Will handle monitoring and setting the players gold value in their treasury
     * and the current date in game.
     */
    public void act() {
         // play background music when game begins
         background.setVolume(7);
         background.playLoop();
         
         // check if game over
         
         // increment and set date
    }
    
    /**
     * Prepare: populate world with objects defined above
     */
    public void prepare() {
        addObject( player, 575, 240 );
        
    }
}
