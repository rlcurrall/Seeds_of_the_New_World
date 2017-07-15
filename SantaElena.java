/* IMPORTS */
import java.util.*;
import greenfoot.*;

/**
 * Write a description of class SantaElena here.
 * 
 * @author Robert Currall
 * @version 7.14.17
 */
public class SantaElena extends World
{
    /*******************************************************************************************************/
    /* FIELDS */
    /*******************************************************************************************************/
    // Background music
    GreenfootSound background = new GreenfootSound( "pamfluite_loop.mp3" );
    public int month;
    
    // Create Player for user to control
    Player player = new Player();
    public int gold;
    
    // Create Treasury to manage user's gold
    Treasury treasury = new Treasury();
    
    // Create NPC signs
    Sign farmerSign = new Sign();
    Sign blacksmithSign = new Sign();
    Sign merchantSign = new Sign();
    
    // Create NPCs
    Farmer farmer = new Farmer();
    Blacksmith blacksmith = new Blacksmith();
    Merchant merchant = new Merchant();
    
    /*******************************************************************************************************/
    /* CONSTRUCTORS */
    /*******************************************************************************************************/
    /**
     * Constructor for objects of class SantaElena.
     */
    public SantaElena()
    {    
        // Create a new world with 725x580 cells with a cell size of 1x1 pixels.
        super(720, 680, 1); 
        // Run prepare to populate the world with the different objects
        prepare();
    } // end SantaElena constructor
    
    /*******************************************************************************************************/
    /* METHODS */
    /*******************************************************************************************************/
    /**
     * Act -    Will handle monitoring and setting the players gold value in their treasury
     *          and the current date in game.
     */
    public void act() {
         // play background music when game begins
         background.setVolume(4);
         background.playLoop();
         
         // check if game over
         checkGameOver();
         
         // collect taxes
         treasury.collectTaxes();
         gold = treasury.getTreasury();
         
         // check current month
         month = treasury.month;
    } // end act method
    
    /**
     * Prepare -    populate world with objects defined above
     */
    public void prepare() {
        gold = 0;
        month = 0;
        
        // Add Player object
        addObject( player, 575, 240 );
        
        // Add Sign objects
        // addObject( farmerSign, x, x);
        // addObject( blacksmithSign, x, x);
        // addObject( merchantSign, x, x);
    } // end prepare method
    
    /*******************************************************************************************************/
    /* USER INTERFACE METHODS */
    /*******************************************************************************************************/
    
    // DISPLAY WORKER DIALOG
    /**
     * displayDialog -  Adds a Cost/Tax/Value object into the world if they do not already exist
     */
    public void displayDialog(String job) {
        if ( treasury.checkHired(job) ) {
            // check if objects exist in world
            List name = this.getObjects(Name.class);
            List cost = this.getObjects(Cost.class);
            List tax = this.getObjects(Tax.class);
            List value = this.getObjects(Value.class);
            
            // create and add objects to the world
            if ( name.isEmpty() ) {
                Name workerName = new Name(job);
                addObject( workerName, 100, 80 );
            } // end if
            if ( cost.isEmpty() ) {
                Cost workerCost = new Cost(job);
                addObject( workerCost , 100, 120 );
            } // end if
            if ( tax.isEmpty() ) {
                Tax workerTax = new Tax(job);
                addObject( workerTax, 100, 140);
            } // end if
            if ( value.isEmpty() ) {
                Value workerValue = new Value(job);
                addObject( workerValue, 100, 160);
            } // end if
        } else {
            // check if objects exist in world
            List name = this.getObjects(Name.class);
            List cost = this.getObjects(Cost.class);
            
            // create and add objects to the world
            if ( name.isEmpty() ) {
                Name workerName = new Name(job);
                addObject( workerName, 100, 100);
            } // end if
            if ( cost.isEmpty() ) {
                Cost workerCost = new Cost(job);
                addObject( workerCost, 100, 110);
            } // end if
        }
    } // end displayFarmerDialog method
    
    // REMOVE WORKER DIALOG
    /**
     * removeWorkerDialog - removes any Cost, Tax, or Value objects that exist in the world
     */
    public void removeWorkerDialog() {
        // check if objects exist in world
        List name = this.getObjects(Name.class);
        List cost = this.getObjects(Cost.class);
        List tax = this.getObjects(Tax.class);
        List value = this.getObjects(Value.class);
        
        // if objects exist remove them
        if (!name.isEmpty()) {
            this.removeObjects(name);
        } // end if
        if (!cost.isEmpty()) {
            this.removeObjects(cost);
        } // end if
        if (!tax.isEmpty()) {
            this.removeObjects(tax);
        } // end if
        if (!value.isEmpty()) {
            this.removeObjects(value);
        } // end if
    } // end removeFarmerDialog method
    
    /*******************************************************************************************************/
    /* TREASURY GETTERS & SETTERS */
    /*******************************************************************************************************/
    // HIRE WORKER
    /**
     * hireFarmer -     Will hire the Farmer in the Treasury object, calls the hire() method from the 
     *                  Treasury object which returns a boolean of success or failure, handles any exceptions
     */
    public void hireFarmer() {
        boolean res = treasury.hire("Farmer");
        
        if ( res ) {
            // removeObject( farmerSign, x, x);
            // addObject( farmer, x, x);
            List<Cost> cost = this.getObjects(Cost.class);
            if (cost.size() > 0) {
                Cost worker = cost.get(0);
                worker.setLevel( treasury.getLevel("Farmer") );
            } // end if
        } else {
            // handle error
        } // end else-if block
    } // end hireFarmer method
    
    /**
     * hireBlacksmith - Will hire the Blacksmith in the Treasury object, calls the hire() method from the 
     *                  Treasury object which returns a boolean of success or failure, handles any exceptions
     */
    public void hireBlacksmith() {
        boolean res = treasury.hire("Blacksmith");
        
        if ( res ) {
            // removeObject( blacksmithSign, x, x);
            // addObject( blacksmith, x, x);
            List<Cost> cost = this.getObjects(Cost.class);
            if (cost.size() > 0) {
                Cost worker = cost.get(0);
                worker.setLevel( treasury.getLevel("Blacksmith") );
            } // end if
        } else {
            // handle error
        } // end else-if block
    } // end hireBlacksmith method
    
    /**
     * hireMerchant -   Will hire the Merchant in the Treasury object, calls the hire() method from the 
     *                  Treasury object which returns a boolean of success or failure, handles any exceptions
     */
    public void hireMerchant() {
        boolean res = treasury.hire("Merchant");
        
        if ( res ) {
            // removeObject( merchantSign, x, x);
            // addObject( merchant, x, x);
            List<Cost> cost = this.getObjects(Cost.class);
            if (cost.size() > 0) {
                Cost worker = cost.get(0);
                worker.setLevel( treasury.getLevel("Merchant") );
            } // end if
        } else {
            // handle error
        } // end else-if block
    } // end hireMerchant method
    
    // GIVE WORKER A RAISE
    /**
     * giveRaiseFarmer -    Will give a raise to the Farmer in the Treasury object. Will be used by the 
     *                      Player object.
     */
    public void giveRaiseFarmer() {
        boolean res = treasury.giveRaise("Farmer");
    } // end giveRaiseFarmer method
    
    /**
     * giveRaiseBlacksmith - Will give a raise to the Blacksmith in the Treasury object. Will be used by the 
     *                       Player object.
     */
    public void giveRaiseBlacksmith() {
        boolean res = treasury.giveRaise("Blacksmith");
    } // end giveRaiseBlacksmith method
    
    /**
     * giveRaiseMerchant -  Will give a raise to the Merchant in the Treasury object. Will be used by the 
     *                      Player object.
     */
    public void giveRaiseMerchant() {
        boolean res = treasury.giveRaise("Merchant");
    } // end giveRaiseMerchant method
    
    // GET WORKER LEVEL
    // ERROR IN RETRIEVING THE LEVEL
	
	// May no longer be necessary...
	
    /**
     * getLevelFarmer -     Gets the Farmer level from the treasury object, will be used by objects
     *                      that exist in the world such as the Cost/Tax/Value objects
     */
    public int getLevelFarmer() {
        int level = treasury.getLevel("Farmer");
        return level;
    } // end getLevelFarmer method
    
    /**
     * getLevelBlacksmtih - Gets the Blacksmith level from the treasury object, will be used by objects
     *                      that exist in the world such as the Cost/Tax/Value objects
     */
    public int getLevelBlacksmith() {
        //int level = treasury.getLevel("Blacksmith");
        return 1;
    } // end getLevelBlacksmith method
    
    /**
     * getLevelMerchant -   Gets the Merchants level from the treasury object, will be used by objects
     *                      that exist in the world such as the Cost/Tax/Value objects
     */
    public int getLevelMerchant() {
        int level = treasury.getLevel("Merchant");
        return level;
    } // end getLevelMerchant
    
    /*******************************************************************************************************/
    /* CHECK GAMEOVER */
    /*******************************************************************************************************/
    /**
     * checkGameOver -  Checks if the time has run out or the player reached the desired gold value
     */
    public void checkGameOver() {
        // if player runs out of time
        if ( month == 131 ) {
            GameOver lose = new GameOver();
            background.stop();
            Greenfoot.setWorld(lose);
        } else if ( gold == 200000 ) {
            WinScreen win = new WinScreen();
            background.stop();
            Greenfoot.setWorld(win);
        } // end else-if block
    } // end checkGameOver method
} // end SantaElena class
