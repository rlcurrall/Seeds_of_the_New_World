import greenfoot.*;
import java.awt.*;
import java.util.*;

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
    private boolean hmmPlayed = false;
    
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
    
    // Variables for Dialog boxes
    private boolean dialogRemoved = false;
    
    
    /* METHODS */
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkQuit();
        // determine which arrow keys are being pushed
        arrowKeys();
        // move character 3px in the direction of the arrow key being pressed
        movement();
        // the color of the pixel below the character and display the appropriate dialog box
        //dialogCheck();
        dialog();
        
    } // end act method
    
    /**
     * arrowKeys - Reads input from user to determine the direction to move the Player
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
     * movement -   Takes value set by the arrowKeys function, calls the checkClear function to ensure that
     *              player can be moved in desired direction, if true Player is moved 3 px in that direction.
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
     * checkClear - Checks 3 px in the direction the user want to move the Player, returns TRUE or FALSE
     *              if Player can be moved in that direction
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
        
        // teturn TRUE or FALSE depending on color in currentColor and if there is already an actor there
        if ( currentColor.equals( Color.black ) || getOneObjectAtOffset( checkX, checkY, Actor.class ) != null) {
            return false;
        } else {
            return true;
        } // end else-if block
    } // end checkClear method
    
    /**
     * dialog - Determines where the player is standing, if the player is in one of the colored areas, then
     *          display the appropriate dialog
     */
    public void dialog() {
        // get color at Player's current location
        Color currentColor = border.getColorAt( getX(), getY() );
        
        if ( currentColor.equals( Color.blue ) ) {
            // Farmer
            dialogRemoved = false;
            boolean isHired = ((SantaElena) getWorld()).treasury.checkHired("Farmer");
            ((SantaElena) getWorld()).displayDialog("Farmer");
            
            // play sound once
            if ( !hmmPlayed ) {
                hmm.setVolume(20);
                hmm.play();
                hmmPlayed = true;
            } // end if
            
            if ( isHired ) {
                if( "r".equals(Greenfoot.getKey()) || "R".equals(Greenfoot.getKey()) ) {
                    ((SantaElena) getWorld()).giveRaiseFarmer();
                } else if ( "c".equals(Greenfoot.getKey()) || "C".equals(Greenfoot.getKey()) ) {
                    //((SantaElena) getWorld()).closeFarmer();
                } // end else-if block
            } else {
                if( "h".equals(Greenfoot.getKey()) || "H".equals(Greenfoot.getKey()) ) {
                    ((SantaElena) getWorld()).hireFarmer();
                    ((SantaElena) getWorld()).removeWorkerDialog();
                    ((SantaElena) getWorld()).displayDialog("Farmer");
                } // end if
            } // end if
        } else if ( currentColor.equals( Color.green ) ) {
            // Blacksmith
            dialogRemoved = false;
            boolean isHired = ((SantaElena) getWorld()).treasury.checkHired("Blacksmith");
            ((SantaElena) getWorld()).displayDialog("Blacksmith");
            
            // play sound once
            if ( !hmmPlayed ) {
                hmm.setVolume(20);
                hmm.play();
                hmmPlayed = true;
            } // end if
            
            if ( isHired ) {
                if( "r".equals(Greenfoot.getKey()) || "R".equals(Greenfoot.getKey()) ) {
                    ((SantaElena) getWorld()).giveRaiseBlacksmith();
                } else if ( "c".equals(Greenfoot.getKey()) || "C".equals(Greenfoot.getKey()) ) {
                    //((SantaElena) getWorld()).closeBlacksmith();
                } // end else-if block
            } else {
                if( "h".equals(Greenfoot.getKey()) || "H".equals(Greenfoot.getKey()) ) {
                    ((SantaElena) getWorld()).hireBlacksmith();
                    ((SantaElena) getWorld()).removeWorkerDialog();
                    ((SantaElena) getWorld()).displayDialog("Blacksmith");
                } // end if
            } // end if
        } else if ( currentColor.equals( Color.red) ) {
            // Merchant
            dialogRemoved = false;
            boolean isHired = ((SantaElena) getWorld()).treasury.checkHired("Merchant");
            ((SantaElena) getWorld()).displayDialog("Merchant");
            
            // play sound once
            if ( !hmmPlayed ) {
                hmm.setVolume(20);
                hmm.play();
                hmmPlayed = true;
            } // end if
            
            if ( isHired ) {
                if( "r".equals(Greenfoot.getKey()) || "R".equals(Greenfoot.getKey()) ) {
                    ((SantaElena) getWorld()).giveRaiseMerchant();
                } else if ( "c".equals(Greenfoot.getKey()) || "C".equals(Greenfoot.getKey()) ) {
                    //((SantaElena) getWorld()).closeMerchant();
                } // end else-if block
            } else {
                if( "h".equals(Greenfoot.getKey()) || "H".equals(Greenfoot.getKey()) ) {
                    ((SantaElena) getWorld()).hireMerchant();
                    ((SantaElena) getWorld()).removeWorkerDialog();
                    ((SantaElena) getWorld()).displayDialog("Merchant");
                } // end if
            } // end if
        } else if ( currentColor.equals( Color.white ) ) {
            dialogRemoved = false;
            ((SantaElena) getWorld()).displayDialog("Priest");
            if ( "enter".equals( Greenfoot.getKey() ) ) {
                ((SantaElena) getWorld()).priestDialog();
            }
        } else {
            if (!dialogRemoved){
                ((SantaElena) getWorld()).removeWorkerDialog();
                dialogRemoved = true;
            } // end if
            hmmPlayed = false;
        }
    } // end dialog method
    
    /**
     * checkQuit - if player presses the q key restart the game
     */
    public void checkQuit() {
        if( Greenfoot.isKeyDown("q") || Greenfoot.isKeyDown("Q") ) {
            Start start = new Start();
            ((SantaElena) getWorld()).background.stop();
            Greenfoot.setWorld(start);
        } // end if
    } // end checkQuit method
} // end Player class
