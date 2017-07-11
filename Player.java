import greenfoot.*;
import java.awt.*;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /* FIELDS */
    // Image for the border of movable space in the world
    GreenfootImage border = new GreenfootImage( "Border.png" );
    
    // Sound for NPC
    GreenfootSound hmm = new GreenfootSound( "hmm.wav" );
    
    // Player Images
    // Up/Down
    GreenfootImage player = new GreenfootImage( "Player.png" );
    GreenfootImage playerDown = new GreenfootImage( "Player-Down1.png" );
    // Right
    GreenfootImage playerRight1 = new GreenfootImage( "Player-right1.png" );
    GreenfootImage playerRight2 = new GreenfootImage( "Player-right2.png" );
    GreenfootImage playerRight3 = new GreenfootImage( "Player-right3.png" );
    // Left
    GreenfootImage playerLeft1 = new GreenfootImage( "Player-left1.png" );
    GreenfootImage playerLeft2 = new GreenfootImage( "Player-left2.png" );
    GreenfootImage playerLeft3 = new GreenfootImage( "Player-left3.png" );
    
    // Direction variables
    int dirX;
    int dirY;
    
    
    /* METHODS */
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // determine which arrow keys are being pushed
        arrowKeys();
        // move character 3px in the direction of the arrow key being pressed
        movement();
        // the color of the pixel below the character and display the appropriate dialog box
        //dialogCheck();
        
    } // end act method
    
    /**
     * arrowKeys -
     * 
     */
    public void arrowKeys() {
        // reset values
        dirX = 0;
        dirY = 0;
        
        // Check the keys that are being pressed
        // check X axis
        if (Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("left")) {
            dirX = 1;
        } else if (!Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("left")) {
            dirX = 2;
        } // end else-if block
        // check Y axis
        if (Greenfoot.isKeyDown("down") && !Greenfoot.isKeyDown("up")) {
            dirY = 3;
        } else if (!Greenfoot.isKeyDown("down") && Greenfoot.isKeyDown("up")) {
            dirY = 4;
        } // end else-if block
    } // end arrowKeys method
    
    /**
     * movement - 
     */
    public void movement() {
        if (dirX == 1 && checkClear(dirX, dirY)) {
            // change image, move player, reset value of dirX
            setImage( playerLeft1 );
            setLocation( getX() + 3, getY());
            dirX = 0;
        } else if ( dirX == 2 && checkClear(dirX, dirY)) {
            // change image, move player, reset value of dirX
            setImage( playerRight1 );
            setLocation( getX() - 3, getY());
            dirX = 0;
        } else if ( dirY == 3 && checkClear(dirX, dirY)) {
            // change image, move player, reset value of dirY
            setImage( player );
            setLocation( getX(), getY() + 3);
            dirY = 0;
        } else if ( dirY == 4 && checkClear(dirX, dirY)) {
            // change image, move player, reset value of dirY
            setImage( playerDown );
            setLocation( getX(), getY() - 3);
            dirY = 0;
        }// end else-if block
    }// end movement method
    
    /**
     * checkClear -
     */
    public boolean checkClear(int dirX, int dirY) {
        /* VARIABLES */
        int checkX = 0;
        int checkY = 0;
        Color currentColor;
        
        // determine where to check in the x direction
        if (dirX == 0) {
            checkX = 0;
        } else if (dirX == 1) {
            checkX = 3;
        } else if (dirX == 2) {
            checkX = -3;
        } // end else-if block
        
        // determine where to check in the y direction
        if (dirY == 0) {
            checkY = 0;
        } else if (dirY == 3) {
            checkY = 3;
        } else if (dirY == 4) {
            checkY = -3;
        } // end else-if block
        
        // Color object to assign value of color at given point
        currentColor = border.getColorAt( getX() + checkX, getY() + checkY);
        
        // teturn TRUE or FALSE depending on color in currentColor
        if ( currentColor.equals( Color.black ) ) {
            return false;
        } else {
            return true;
        } // end else-if block
    } // end checkClear method
}
