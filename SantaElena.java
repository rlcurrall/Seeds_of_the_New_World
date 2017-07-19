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
    Priest priest = new Priest();
    
    // Create UI objects
    Gold goldUI = new Gold(gold);
    Date dateUI = new Date();
    
    // Key UI objects
    // for quit
    Button q = new Button("quit");
    ButtonText qT = new ButtonText("quit");
    
    // for hire
    Button h = new Button("hire");
    ButtonText hT = new ButtonText("hire");
    
    // for raise
    Button r = new Button("raise");
    ButtonText rT = new ButtonText("raise");
    
    // for Priest's random facts
    Button enter = new Button("fact");
    ButtonText enterT = new ButtonText("fact");
    
    // List of facts that Priest will say
    List<String> facts = Arrays.asList(
        "Santa Elena was the first colonial\ncapital of Spanish Florida, and\nwas founded in 1566!",
        "Pedro Menendez de Aviles was appointed\nadelantado, or governor, of Spanish\nFlorida in 1565 and was ordered to\nestablish military bases on the\nFlorida mainland.",
        "Adelantado was an elite military and\nadministrative position created when\nthe Christian Spaniards took the\nIberian Peninsula back from the\nMuslim Moors.",
        "In return for the adelantado's work,\nthe Spanish crown granted the\nindividual economic privileges and honors.",
        "Ponce de Leon, Lucas Vasquez de\nAyllon, Panfilo de Narvaez, Hernando\nde Soto, and Tristan de Luna y Arellano\nwere all adelantados.",
        "Menendez is best known for founding\nSt. Augustine, the oldest continuously\noccupied Eropean city in the continental\nUnited States.",
        "Before Menendez arrived, his French\nrival, Jean Ribault, founded\nCharlesfort on Parris Island in 1562\nand claimed the land for France.",
        "The settlers of Santa Elena have not\nbeen on friendly terms with the\nNative Americans in the region - the\nOrista and Guale tribes.",
        "A fire destroyed the fort in 1571.\nMenendez's son-in-law, Don Diego\nde Velasco, oversaw the construction of\nthe new fort, named San Felipe.",
        "Menendez passed away in 1574, and\nthe title of adelantado passed on\nto you, Hernando de Miranda, his daughter\nCatalina's husband.");
    // used to get random number
    Random rand = new Random();
    
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
        // Initiate values
        gold = 0;
        month = 0;
        
        // Add UI objects
        addObject( goldUI, 75, 620 );
        addObject( dateUI, 72, 640 );
        
        // Add quit key image
        addObject( q, 550, 630 );
        addObject( qT, 620, 630 );
        
        // Add Sign objects
        addObject( farmerSign, 440, 480 );
        addObject( blacksmithSign, 225, 475 );
        addObject( merchantSign, 660, 470 );
        
        // Add Priest
        addObject( priest, 250, 120 );
        
        // Add Player object
        addObject( player, 575, 240 );
    } // end prepare method
    
    /*******************************************************************************************************/
    /* USER INTERFACE METHODS */
    /*******************************************************************************************************/
    
    // DISPLAY WORKER DIALOG
    /**
     * displayDialog -  Adds a Cost/Tax/Value object into the world if they do not already exist
     */
    public void displayDialog(String job) {
        // remove current button images
        removeObject(q);
        removeObject(qT);
        
        // Variables used to calculate and set locations
        GreenfootImage image;
        int width;
        
        // check if objects exist in the world
        List<Name> name = this.getObjects(Name.class);
        List<Cost> cost = this.getObjects(Cost.class);
        
        if (job != "Priest") {
            // check worker Level, if 0 set local value to 1 for display purposes, then update cost
            int workerLevel = treasury.getLevel(job);
            int calcTax = treasury.getTax(job);
            if (workerLevel == 0) {
                workerLevel = 1;
            } // end if
            if ( cost.size() > 0 ) {
                cost.get(0).setLevel(workerLevel);
            } // end if
        
            if ( treasury.checkHired(job) ) {
                // check if objects exist in world
                List<Tax> tax = this.getObjects(Tax.class);
                List<Value> value = this.getObjects(Value.class);
                
                // add raise button object
                addObject( r, 550, 630 );
                addObject( rT, 620, 630 );
            
                // update tax and value 
                if ( tax.size() > 0 ) {
                    tax.get(0).setLevel(workerLevel, calcTax);
                } // end if
                if ( value.size() > 0 ) {
                    value.get(0).setLevel(workerLevel);
                } // end if
            
                // create and add objects to the world
                if ( name.isEmpty() ) {
                    Name workerName = new Name(job);
                    image = workerName.getImage();
                    width = image.getWidth();
                    addObject( workerName, 250 + width/2, 600 );
                } // end if
                if ( cost.isEmpty() ) {
                    Cost workerCost = new Cost(job);
                    image = workerCost.getImage();
                    width = image.getWidth();
                    addObject( workerCost , 260 + width/2, 620 );
                } // end if
                if ( tax.isEmpty() ) {
                    Tax workerTax = new Tax(job, calcTax);
                    image = workerTax.getImage();
                    width = image.getWidth();
                    addObject( workerTax, 260 + width/2, 635);
                } // end if
                if ( value.isEmpty() ) {
                    Value workerValue = new Value(job);
                    image = workerValue.getImage();
                    width = image.getWidth();
                    addObject( workerValue, 260 + width/2, 650);
                } // end if
            } else {// create and add objects to the world
                // Add quit key image
                addObject( h, 550, 630 );
                addObject( hT, 600, 630 );
            
                if ( name.isEmpty() ) {
                    Name workerName = new Name(job);
                    image = workerName.getImage();
                    width = image.getWidth();
                    addObject( workerName, 250 + width/2, 600);
                } // end if
                if ( cost.isEmpty() ) {
                    Cost workerCost = new Cost(job);
                    image = workerCost.getImage();
                    width = image.getWidth();
                    addObject( workerCost, 260 + width/2, 620);
                } // end if
            } // end else-if block
        } else {
            // remove current button images
            removeObject(q);
            removeObject(qT);
            
            // display name object
            if ( name.isEmpty() ) {
                Name priestName = new Name(job);
                addObject( priestName, 250 + priestName.getImage().getWidth()/2, 600 );
            } // end if
            
            // Add enter key image
            addObject( enter, 300, 635 );
            addObject( enterT, 420, 635 );
        } // end else-if block
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
        List<Button> buttons = this.getObjects(Button.class);
        List<ButtonText> buttonTexts = this.getObjects(ButtonText.class);
        
        // remove all buttons from the screen
        for ( Button b : buttons ) {
            removeObject(b);
        } // end for each loop
        
        // remove all buttonText objects from the screen
        for ( ButtonText bt : buttonTexts ) {
            removeObject(bt);
        } // end for each loop
        
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
        
        // Add quit key image
        addObject( q, 550, 630 );
        addObject( qT, 620, 630 );
    } // end removeFarmerDialog method
    
    /**
     * priestDialog - Used to display random facts when the player speaks with the priest, and will give the player 
     *                10 Reals. 
     */
    public void priestDialog() {
        // remove any fact on the screen
        List<Fact> oldFact = this.getObjects(Fact.class);
        
        if (oldFact.size() == 0) {
            // Get a random element from the facts List
            int n = rand.nextInt(10);
            String text = facts.get(n);
            
            // Create new fact object and display in the world and add 10 gold to the treasury.
            Fact fact = new Fact(text);
            Bubble bubble = new Bubble();
            // addObject( fact, 200 + fact.getImage().getWidth()/2, 20 + fact.getImage().getHeight()/2 );
            addObject( bubble, 240 + bubble.getImage().getWidth()/2, 40 + bubble.getImage().getHeight()/2);
            addObject( fact, 250 + 3*bubble.getImage().getWidth()/5, 40 + bubble.getImage().getHeight()/3);
            treasury.donate();
        } else {
            if (oldFact.get(0).getCount() < 300) {
                // remove old fact
                removeObject(oldFact.get(0));
                
                // add new fact
                int n = rand.nextInt(10);
                String text = facts.get(n);
                
                Fact fact = new Fact(text);
                Bubble bubble = new Bubble();
                addObject( bubble, 240 + bubble.getImage().getWidth()/2, 40 + bubble.getImage().getHeight()/2);
                addObject( fact, 250 + 3*bubble.getImage().getWidth()/5, 40 + bubble.getImage().getHeight()/3);
            } // end if
        } // end if
    } // end priestDialog method
    
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
            removeObject( farmerSign );
            addObject( farmer, 440, 480 );
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
            removeObject( blacksmithSign );
            addObject( blacksmith, 225, 475 );
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
            removeObject( merchantSign );
            addObject( merchant, 660, 470 );
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
        
        if ( res ) {
            // removeObject( merchantSign, x, x);
            // addObject( merchant, x, x);
            List<Cost> cost = this.getObjects(Cost.class);
            List<Tax> tax = this.getObjects(Tax.class);
            List<Value> value = this.getObjects(Value.class);
            int newLevel = treasury.getLevel("Farmer");
            int calcTax = treasury.getTax("Farmer");
            if (cost.size() > 0) {
                Cost wC = cost.get(0);
                Tax wT = tax.get(0);
                Value wV = value.get(0);
                
                wC.setLevel( newLevel );
                wT.setLevel( newLevel, calcTax );
                wV.setLevel( newLevel );
            } // end if
        } else {
            // handle error
        } // end else-if block
    } // end giveRaiseFarmer method
    
    /**
     * giveRaiseBlacksmith - Will give a raise to the Blacksmith in the Treasury object. Will be used by the 
     *                       Player object.
     */
    public void giveRaiseBlacksmith() {
        boolean res = treasury.giveRaise("Blacksmith");
        
        if ( res ) {
            // removeObject( merchantSign, x, x);
            // addObject( merchant, x, x);
            List<Cost> cost = this.getObjects(Cost.class);
            List<Tax> tax = this.getObjects(Tax.class);
            List<Value> value = this.getObjects(Value.class);
            int newLevel = treasury.getLevel("Blacksmith");
            int calcTax = treasury.getTax("Blacksmith");
            if (cost.size() > 0) {
                Cost wC = cost.get(0);
                Tax wT = tax.get(0);
                Value wV = value.get(0);
                
                wC.setLevel( newLevel );
                wT.setLevel( newLevel, calcTax );
                wV.setLevel( newLevel );
            } // end if
        } else {
            // handle error
        } // end else-if block
    } // end giveRaiseBlacksmith method
    
    /**
     * giveRaiseMerchant -  Will give a raise to the Merchant in the Treasury object. Will be used by the 
     *                      Player object.
     */
    public void giveRaiseMerchant() {
        boolean res = treasury.giveRaise("Merchant");
        
        if ( res ) {
            // removeObject( merchantSign, x, x);
            // addObject( merchant, x, x);
            List<Cost> cost = this.getObjects(Cost.class);
            List<Tax> tax = this.getObjects(Tax.class);
            List<Value> value = this.getObjects(Value.class);
            int newLevel = treasury.getLevel("Merchant");
            int calcTax = treasury.getTax("Merchant");
            if (cost.size() > 0) {
                Cost wC = cost.get(0);
                Tax wT = tax.get(0);
                Value wV = value.get(0);
                
                wC.setLevel( newLevel );
                wT.setLevel( newLevel, calcTax );
                wV.setLevel( newLevel );
            } // end if
        } else {
            // handle error
        } // end else-if block
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
        } else if ( gold > 200000 ) {
            WinScreen win = new WinScreen();
            background.stop();
            Greenfoot.setWorld(win);
        } // end else-if block
    } // end checkGameOver method
} // end SantaElena class
