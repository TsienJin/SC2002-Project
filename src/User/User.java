import Menu.Menu;
import UsrInput.UsrInput;
import dataDriver.CSVDriver;
import Booking.BookingApp;

public abstract class User {

    // To be instanciated in subclasses with respective objects
    protected Menu menu;
    protected CSVDriver dataDriver;
    
    // Common to all
    protected UsrInput input = new UsrInput();

    // Common method to all
    protected int getUsrChoice(){
        return this.input.getUsrInt("Enter Option: ");
    }

    // Methods to be implemented
    public abstract void run();

    
}