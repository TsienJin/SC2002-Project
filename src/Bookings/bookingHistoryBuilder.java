package Bookings;

import java.util.ArrayList;
import java.util.Arrays;

import Movie.InterfaceBuilder;
import dataDriver.EnumDataFiles;
import dataDriver.FileIO;
import dataDriver.InterfaceCsvDelimiter;

public class bookingHistoryBuilder implements InterfaceBuilder<bookingHistory>, InterfaceCsvDelimiter{
    String TID;
    String movieID;
    String MobileNum;
    String Email;
    String movieName;
    String totalPrice;


    /**
     * Constructs new bookingHistoryBuilder()
     * @return bookingHistoryBuilder
     */
    public static bookingHistoryBuilder bookingHistory(){
        return new bookingHistoryBuilder();
    }


    /**
     * Default constructor 
     */
    public bookingHistoryBuilder(){}

    /**
     * Updates bookingHistoryBuilder oject attributes from bookingHistory File via 'updateFromCSVString()'
     * @param csvString
     */
    public bookingHistoryBuilder(String csvString){
        this.updateFromCSVString(csvString);
    }

    /**
     * Updates bookingHistoryBuilder object attribute from bookingHistory File
     * @param csvString
     */
    private void updateFromCSVString(String csvString){
        ArrayList<String> csvArr = new ArrayList<>(Arrays.asList(csvString.split(mainDelimiter)));

        this.TID = csvArr.get(0);
        this.movieID = csvArr.get(1);
        this.MobileNum = csvArr.get(2);
        this.Email = csvArr.get(3);
        this.movieName = csvArr.get(4);
        this.totalPrice = csvArr.get(5);
    }

    /**
     * Sets TID (Transaction ID) attribute of bookingHistoryBuilder object
     * @param TID
     * @return bookingHistoryBuilder
     */
    public bookingHistoryBuilder setTID(String TID){
        this.TID = TID;
        return this;
    }

    /**
     * Sets movieID attribute of bookingHistoryBuilder object
     * @param movieID 
     * @return bookingHistoryBuilder
     */
    public bookingHistoryBuilder setmovieID(String movieID){
        this.movieID = movieID;
        return this;
    }

    /**
     * Sets MobileNum attribute of bookingHistoryBuilder object
     * @param MobileNum
     * @return bookingHistoryBuilder
     */
    public bookingHistoryBuilder setMobileNum(String MobileNum){
        this.MobileNum = MobileNum;
        return this;
    }

    /**
     * Sets Email attribute of bookingHistoryBuilder object
     * @param Email
     * @return bookingHistoryBuilder
     */
    public bookingHistoryBuilder setEmail(String Email){
        this.Email = Email;
        return this;
    }

    /**
     * Sets movieName attribute of bookingHistoryBuilder object
     * @param movieName
     * @return bookingHistoryBuilder
     */
    public bookingHistoryBuilder setmovieName(String movieName){
        this.movieName = movieName;
        return this;
    }

    /**
     * Sets totalPrice attribute of bookingHistoryBuilder object
     * @param totalPrice 
     * @return bookingHistoryBuilder
     */
    public bookingHistoryBuilder settotalPrice(String totalPrice){
        this.totalPrice = totalPrice;
        return this;
    }


    /**
     * Build method to construct movie object
     * @return bookingHistory
     */
    @Override
    public bookingHistory build(){
        return new bookingHistory(this);
    }



    
}
