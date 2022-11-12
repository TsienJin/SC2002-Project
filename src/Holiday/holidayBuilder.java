package Holiday;
import java.util.ArrayList;
import java.util.Arrays;

import Movie.InterfaceBuilder;
import dataDriver.InterfaceCsvDelimiter;

public class holidayBuilder implements InterfaceBuilder<holiday>,InterfaceCsvDelimiter{
    String holidayName;
    String holidayDate;
    String ticketPrice;

    /**
     * Default constructot
     * @return holidayBuilder object
     */
    public static holidayBuilder holiday(){
        return new holidayBuilder();
    }

    /**
     * Default constructor
     */
    public holidayBuilder(){};

    /** Constructor that builds from CSV line
     * 
     * @param csvString
     */
    public holidayBuilder(String csvString){
        this.updateFromCSVString(csvString);
    }

    /** Private method to update attributes from CSV line
     * @param csvString
     */
    private void updateFromCSVString(String csvString){
        ArrayList<String> csvArr = new ArrayList<>(Arrays.asList(csvString.split(mainDelimiter)));
        this.holidayName = csvArr.get(0);
        this.holidayDate = csvArr.get(1);
        this.ticketPrice = csvArr.get(2);
    }

    /** Setter for holidayName 
     * @param holidayName
     * @return holidayBuilder
     */
    public holidayBuilder setholidayName(String holidayName){
        this.holidayName = holidayName;
        return this;
    }

    /** Setter for holidayDate 
     * @param holidayDate
     * @return holidayBuilder
     */
    public holidayBuilder setholidayDate(String holidayDate){
        this.holidayDate = holidayDate;
        return this;
    }

    /** Setter for ticketPrice 
     * @param ticketPrice
     * @return holidayBuilder
     */
    public holidayBuilder setticketPrice(String ticketPrice){
        this.ticketPrice = ticketPrice;
        return this;
    }

    /** Build method to construct holiday object
     * @return holiday
     */
    @Override
    public holiday build(){
        return new holiday(this);
    }
    
}
