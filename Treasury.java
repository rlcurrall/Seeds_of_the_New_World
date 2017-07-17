import greenfoot.*;

/**
 * Write a description of class Treasury here.
 * 
 * @author Robert Currall
 * @version 17.7.14
 */
public class Treasury extends Actor
{
    /*******************************************************************************************************/
    /* FIELDS */
    /*******************************************************************************************************/
    //* Public variables *//
    public int taxPeriod;
    public int month;
    // Booleans to determine if worker is employed
    public boolean farmerHired;
    public boolean blacksmithHired;
    public boolean merchantHired;
    // variables for tax collection
    public int gold;
    private int collections;
    private int salaries;
    
    // Sounds for when collecting taxes
    GreenfootSound ping = new GreenfootSound( "ping.wav" );
    
    // Variables used for paying & collecting money
    private int farmerTaxes = 50;
    private int blacksmithTaxes = 100;
    private int merchantTaxes = 200;
    
    // Variables used to determine workers wages
    private int farmerLevel = 0;
    private int blacksmithLevel = 0;
    private int merchantLevel = 0;
    
    /*******************************************************************************************************/
    /* CONSTRUCTOR */
    /*******************************************************************************************************/
    /**
     * Constructor - Initializes the values
     */
    public Treasury() {
        // set default values
        gold = 300;
        taxPeriod = 0;
        month = 0;
        farmerHired = false;
        blacksmithHired = false;
        merchantHired = false;
    } // end Treasury constructor
    
    /*******************************************************************************************************/
    /* METHODS */
    /*******************************************************************************************************/
    /**
     * collectTaxes - Will add gold to the players treasury based on what workers they have hired and what
     *                they are paying them.
     */
    public void collectTaxes() {
        if( taxPeriod == 600 ) {
            // sum taxes recieved this month
            collections = 0;
            if ( farmerHired ) {
                collections = collections + farmerTaxes;
            } // end nested if
            if ( blacksmithHired ) {
                collections = collections + blacksmithTaxes;
            } // end nested if
            if ( merchantHired ) {
                collections = collections + merchantTaxes;
            } // end nested if
            
            // add to Treasury gold
            gold = gold + collections;
            
            // play sound and reset sound period
            ping.setVolume(80);
            ping.play();
            taxPeriod = 0;
            month++;
        } else {
            taxPeriod++;
        } // end else-if block
    } // end collectTaxes method
    
    /**
     * donate - When player speaks with the Priest the priest will make a donation to the success of the
     *          settlement.
     */
    public void donate() {
        gold = gold + 10;
    } // end donate method
    
    /**
     * hire -   If Worker not already hired, hire the worker, and subtract cost from gold
     */  
    public boolean hire( String job ) {
        if ( job == "Farmer" && !farmerHired  && gold >= 200 ) {
            farmerHired = true;
            farmerLevel = 1;
            gold = gold - 200;
            return true;
        } else if ( job == "Farmer" && gold < 200 ) {
            return false;
        } else if ( job == "Blacksmith" && !blacksmithHired && gold >= 400 ) {
            blacksmithHired = true;
            blacksmithLevel = 1;
            gold = gold - 400;
            return true;
        } else if ( job == "Blacksmith" && gold < 400 ) {
            return false;
        }else if ( job == "Merchant" && !merchantHired && gold >= 800 ) {
            merchantHired = true;
            merchantLevel = 1;
            gold = gold - 800;
            return true;
        } else if ( job == "Merchant" && gold < 800 ) {
            return false;
        } // end else-if block
        
        // return to supress error on compile
        return false;
    } // end hire method
    
    /**
     * giveRaise -  Removes cost from gold, changes value of Taxes for that worker, and increments level,
     *              returns a boolean on if raise was successful or not
     */
    public boolean giveRaise( String job ) {
        if ( job == "Farmer" && farmerHired && gold >= 200 * farmerLevel ) {
            gold  = gold - ( 200 * farmerLevel );
            farmerLevel++;
            farmerTaxes = (50 * farmerLevel);
            return true;
        } else if ( job == "Farmer" && gold < 200 * farmerLevel ) {
            return false;
        } else if ( job == "Blacksmith" && blacksmithHired  && gold >= 400 * blacksmithLevel ) {
            gold = gold - ( 400 * blacksmithLevel );
            blacksmithLevel++;
            blacksmithTaxes = ( 100 * blacksmithLevel );
            return true;
        } else if ( job == "Blacksmith" && gold < 400 * blacksmithLevel ) {
            return false;
        } else if ( job == "Merchant" && merchantHired && gold >= 800 * merchantLevel ) {
            gold = gold - ( 800 * merchantLevel );
            merchantLevel++;
            merchantTaxes = ( 200 * merchantLevel );
            return true;
        } else if ( job == "Merchant" && gold < 800 * merchantLevel ) {
            return false;
        } // end else-if block
        
        // return to supress error on compile
        return false;
    } // end giveRaise method
    
    /**
     * fire - WIP... not yet implemented.
     */
    public void fire( String job ) {
        if ( job == "Farmer" && farmerHired ) {
            farmerHired = false;
            farmerTaxes = 50;
        } else if ( job == "Blacksmith" && blacksmithHired ) {
            blacksmithHired = false;
            blacksmithTaxes = 100;
        } else if ( job == "Merchant" && merchantHired ) {
            merchantHired = false;
            merchantTaxes = 200;
        } // end else-if block
    } // end fire method
    
    /**
     * getTreasury - Returns the value of gold stored in the Treasury
     */
    public int getTreasury() {
        return gold;
    } // end getTreasury method
    
    /**
     * getLevel - Returns the level of a given worker
     */
    public int getLevel( String job ) {
        if ( job == "Farmer" ) {
            return farmerLevel;
        } else if ( job == "Blacksmith" ) {
            return blacksmithLevel;
        } else if ( job == "Merchant" ) {
            return merchantLevel;
        } // end else-if block
        
        // To address error preventing compile
        return 0;
    } // end getLevel method
    
    /**
     * checkHired - Checks if a worker has been hired, used by displayDialog method in SantaElena
     */
    public boolean checkHired( String job ) {
        if ( job == "Farmer" ) {
            return farmerHired;
        } else if ( job == "Blacksmith" ) {
            return blacksmithHired;
        } else if ( job == "Merchant" ) {
            return merchantHired;
        } // end else-if block
        
        return false;
    } // end checkHired method
} // end Treasury class
