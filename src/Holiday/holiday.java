package Holiday;
import java.util.*;
import dataDriver.InterfaceCsvDelimiter;
import dataDriver.InterfaceToCsvStringHelper;

public class holiday implements InterfaceCsvDelimiter,InterfaceToCsvStringHelper{
    private String holidayName;
    private String holidayDate;
    private String ticketPrice;

    public holiday(holidayBuilder builder){
        this.holidayName = builder.holidayName;
        this.holidayDate = builder.holidayDate;
        this.ticketPrice = builder.ticketPrice;
    }

    public String toCsvString(){
        ArrayList<String> arrCSV = new ArrayList<>();

        arrCSV.add(this.holidayName);
        arrCSV.add(this.holidayDate);
        arrCSV.add(this.ticketPrice);

        return String.join(mainDelimiter,arrCSV);
    }

    public String getholidayName(){
        return this.holidayName;
    }

    public String getholidayDate(){
        return this.holidayDate;
    }

    public String getticketPrice(){
        return this.ticketPrice;
    }

    
}
