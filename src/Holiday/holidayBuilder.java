package Holiday;
import java.util.ArrayList;
import java.util.Arrays;

import Movie.InterfaceBuilder;
import dataDriver.InterfaceCsvDelimiter;

public class holidayBuilder implements InterfaceBuilder<holiday>,InterfaceCsvDelimiter{
    String holidayName;
    String holidayDate;
    String ticketPrice;

    public static holidayBuilder holiday(){
        return new holidayBuilder();
    }

    public holidayBuilder(){};

    public holidayBuilder(String csvString){
        this.updateFromCSVString(csvString);
    }

    private void updateFromCSVString(String csvString){
        ArrayList<String> csvArr = new ArrayList<>(Arrays.asList(csvString.split(mainDelimiter)));
        this.holidayName = csvArr.get(0);
        this.holidayDate = csvArr.get(1);
        this.ticketPrice = csvArr.get(2);
    }

    public holidayBuilder setholidayName(String holidayName){
        this.holidayName = holidayName;
        return this;
    }

    public holidayBuilder setholidayDate(String holidayDate){
        this.holidayDate = holidayDate;
        return this;
    }

    public holidayBuilder settickePrice(String ticketPrice){
        this.ticketPrice = ticketPrice;
        return this;
    }

    @Override
    public holiday build(){
        return new holiday(this);
    }
    
}
