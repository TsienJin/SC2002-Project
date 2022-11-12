package Holiday;
import java.util.*;
import dataDriver.InterfaceCsvDelimiter;
import dataDriver.InterfaceToCsvStringHelper;

public class holiday implements InterfaceCsvDelimiter,InterfaceToCsvStringHelper{
    private String holidayName;
    private String holidayDate;
    private String ticketPrice;

    /** 
     * Takes in holidayBuilder object
     * Constructs the holiday object from holidayBuilder object
     * @param builder holidayBuilder Object
     */
    public holiday(holidayBuilder builder){
        this.holidayName = builder.holidayName;
        this.holidayDate = builder.holidayDate;
        this.ticketPrice = builder.ticketPrice;
    }
    /** 
     * Returns a constructed string of attributes for holiday object in the form of csv line
     * @return Constructed string of attributes
     */
    public String toCsvString(){
        ArrayList<String> arrCSV = new ArrayList<>();

        arrCSV.add(this.holidayName);
        arrCSV.add(this.holidayDate);
        arrCSV.add(this.ticketPrice);

        return String.join(mainDelimiter,arrCSV);
    }

    /** 
     * Returns attribute holidayName of holiday object
     * @return holidayName attribute
     */
    public String getholidayName(){
        return this.holidayName;
    }

    /** 
     * Returns attribute holidayDate of holiday object
     * @return holidayDate attribute
     */
    public String getholidayDate(){
        return this.holidayDate;
    }

    /** 
     * Returns attribute ticketPrice of holiday object
     * @return ticketPrice attribute
     */
    public String getticketPrice(){
        return this.ticketPrice;
    }

    
}
