import greenfoot.*;

/**
 * Write a description of class Treasury here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Treasury extends Actor
{
    /* FIELDS */
    //* Public variables *//
    public int gold;
    public int taxPeriod;
    // Booleans to determine if worker is employed
    public boolean farmerHired;
    public boolean blacksmithHired;
    public boolean merchantHired;
    // variables for tax collection
    public int collections;
    public int salaries;
    
    // Sounds for when collecting taxes
    GreenfootSound ping = new GreenfootSound( "ping.wav" );
    
    // Variables used for paying & collecting money
    private int farmerTaxes = 50;
    private int blacksmithTaxes = 100;
    private int merchantTaxes = 200;
    
    // Variables used to determine workers wages
    private int farmerLevel;
    private int blacksmithLevel;
    private int merchantLevel;
    
    
    /* CONSTRUCTOR */
    public Treasury() {
        // set default values
        gold = 300;
        taxPeriod = 0;
        farmerLevel = 0;
        blacksmithLevel = 0;
        merchantLevel = 0;
        farmerHired = false;
        blacksmithHired = false;
        merchantHired = false;
    } // end Treasury constructor
    
    /* METHODS */
    /**
     * collectTaxes -
     */
    public void collectTaxes() {
        if( taxPeriod == 700 ) {
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
            ping.setVolume(50);
            ping.play();
            taxPeriod = 0;
        } else {
            taxPeriod++;
        }
    }
    
    /**
     * hire -
     */  
    public void hire( String job ) {
        if ( job == "Farmer" && !farmerHired ) {
            farmerHired = true;
            farmerLevel = 1;
            gold = gold - 200;
        } else if ( job == "Blacksmith" && !blacksmithHired ) {
            blacksmithHired = true;
            blacksmithLevel = 1;
            gold = gold - 400;
        } else if ( job == "Merchant" && !merchantHired ) {
            merchantHired = true;
            merchantLevel = 1;
            gold = gold - 800;
        } // end else-if block
    } // end hire method
    
    /**
     * giveRaise -
     */
    public void giveRaise( String job ) {
        if ( job == "Farmer" && farmerHired ) {
            gold  = gold - ( 200 * farmerLevel );
            farmerTaxes = (50 * farmerLevel);
            farmerLevel++;
        } else if ( job == "Blacksmith" && blacksmithHired ) {
            gold = gold - ( 400 * blacksmithLevel );
            blacksmithTaxes = ( 100 * blacksmithLevel );
            blacksmithLevel++;
        } else if ( job == "Merchant" && merchantHired ) {
            gold = gold - ( 800 * merchantLevel );
            merchantTaxes = ( 200 * merchantLevel );
            merchantLevel++;
        } // end else-if block
    } // end giveRaise method
    
    /**
     * fire -
     */
    public void fire( String job ) {
        if ( job == "Farmer" && farmerHired ) {
            farmerHired = false;
        } else if ( job == "Blacksmith" && blacksmithHired ) {
            blacksmithHired = false;
        } else if ( job == "Merchant" && merchantHired ) {
            merchantHired = false;
        } // end else-if block
    } // end fire method
    
    /**
     * getTreasury -
     */
    public int getTreasury() {
        return gold;
    } // end getTreasury method
    
    /**
     * getLevel -
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
} // end Treasury class
