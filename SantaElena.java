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
    
    /*******************************************************************************************************/
    /* CONSTRUCTORS */
    /*******************************************************************************************************/
    /**
     * Constructor for objects of class SantaElena.
     * 
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
     * Act: Will handle monitoring and setting the players gold value in their treasury
     * and the current date in game.
     */
    public void act() {
         // play background music when game begins
         background.setVolume(4);
         background.playLoop();
         
         // check if game over
         
         // collect taxes
         treasury.collectTaxes();
         gold = treasury.getTreasury();
         
         // check current month
         month = treasury.month;
    } // end act method
    
    /**
     * Prepare: populate world with objects defined above
     */
    public void prepare() {
        gold = 0;
        month = 0;
        addObject( player, 575, 240 );
    } // end prepare method
    
    /*******************************************************************************************************/
    /* USER INTERFACE METHODS */
    /*******************************************************************************************************/
    
    // DISPLAY WORKER DIALOG
    /**
     * 
     */
    public void displayDialog(String job) {
        // check if objects exist in world
        List cost = this.getObjects(Cost.class);
        List tax = this.getObjects(Tax.class);
        List value = this.getObjects(Value.class);
        
        // create and add objects to the world
        if ( cost.isEmpty() ) {
            Cost workerCost = new Cost(job);
            // addObject( workerCost , x, x );
        } // end if
        if ( tax.isEmpty() ) {
            Tax workerTax = new Tax(job);
            // addObject( workerTax, x, x);
        } // end if
        if ( value.isEmpty() ) {
            Value workerValue = new Value(job);
            // addObject( workerValue, x, x);
        } // end if
    } // end displayFarmerDialog method
    
    // REMOVE WORKER DIALOG
    /**
     * removeWorkerDialog - removes any Cost, Tax, or Value objects that exist in the world
     */
    public void removeWorkerDialog() {
        // check if objects exist in world
        List cost = this.getObjects(Cost.class);
        List tax = this.getObjects(Tax.class);
        List value = this.getObjects(Value.class);
        
        // if objects exist remove them
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
     * 
     */
    public void hireFarmer() {
        boolean res = treasury.hire("Farmer");
        
        if ( !res ) {
            
        } else {
            
        }
    } // end hireFarmer method
    
    /**
     * 
     */
    public void hireBlacksmith() {
        boolean res = treasury.hire("Blacksmith");
        
        if ( !res ) {
            
        } else {
            
        }
    } // end hireBlacksmith method
    
    /**
     * 
     */
    public void hireMerchant() {
        boolean res = treasury.hire("Merchant");
        
        if ( !res ) {
            
        } else {
            
        }
    } // end hireMerchant method
    
    // GIVE WORKER A RAISE
    /**
     * 
     */
    public void giveRaiseFarmer() {
        boolean res = treasury.giveRaise("Farmer");
    } // end giveRaiseFarmer method
    
    /**
     * 
     */
    public void giveRaiseBlacksmith() {
        boolean res = treasury.giveRaise("Blacksmith");
    } // end giveRaiseBlacksmith method
    
    /**
     * 
     */
    public void giveRaiseMerchant() {
        boolean res = treasury.giveRaise("Merchant");
    } // end giveRaiseMerchant method
    
    // GET WORKER LEVEL
    /**
     * 
     */
    public int getLevelFarmer() {
        return treasury.getLevel("Farmer");
    } // end getLevelFarmer method
    
    /**
     * 
     */
    public int getLevelBlacksmith() {
        return treasury.getLevel("Blacksmith");
    } // end getLevelBlacksmith method
    
    /**
     * 
     */
    public int getLevelMerchant() {
        return treasury.getLevel("Merchant");
    } // end getLevelMerchant
    
    
} // end SantaElena class
