import greenfoot.*;
import java.awt.*;

/**
 * Write a description of class Date here.
 * 
 * @author Robert Currall 
 * @version 17.7.16
 */
public class Date extends Actor
{
    /*******************************************************************************************************/
    /* FIELDS */
    /*******************************************************************************************************/
    private int date = 1;
    private int month = 1;
    private int year = 1577;
    private String monthString;
    private String curDate = "Jan 1577";
    Color background = new Color(0xffcc66);
    
    /*******************************************************************************************************/
    /* CONSTRUCTOR */
    /*******************************************************************************************************/
    /**
     * Constructor - sets the image of the Date object to the initialized value.
     */
    public Date() {
        setImage( new GreenfootImage( "Date: " + curDate, 20, Color.black, background ) );
    } // end Date constructor
    
    /*******************************************************************************************************/
    /* METHODS */
    /*******************************************************************************************************/
    /**
     * act - will check the date stored in the SantaElena world and then update the image of the object
     */
    public void act() {
        date = ((SantaElena) getWorld()).month;
        update();
    } // end act method
    
    /**
     * update - update the image of the Date object
     */
    public void update() {
        // set month to the modulus of date and 12 and year is the start of 1577 plus date divided by 12
        month = date % 12;
        year = 1577 + ( date / 12 );
        
        // switch statement used to determine the month of the year
        switch (month) {
            case 0: monthString = "Jan";
                    break;
            case 1: monthString = "Feb";
                    break;
            case 2: monthString = "Mar";
                    break;
            case 3: monthString = "Apr";
                    break;
            case 4: monthString = "May";
                    break;
            case 5: monthString = "Jun";
                    break;
            case 6: monthString = "Jul";
                    break;
            case 7: monthString = "Aug";
                    break;
            case 8: monthString = "Sep";
                    break;
            case 9: monthString = "Oct";
                    break;
            case 10: monthString = "Nov";
                     break;
            case 11: monthString = "Dec";
                     break;
            default: monthString = "Jan";
                     break;
        } // end switch
    
        // concat monthString with the year to display in the world
        curDate = monthString + " " + year;
        
        // set image of the date object
        setImage( new GreenfootImage( "Date: " + curDate , 20, Color.black, background ) );
    } // end update method
} // end Date class
