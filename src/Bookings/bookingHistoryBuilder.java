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



    public static bookingHistoryBuilder bookingHistory(){
        return new bookingHistoryBuilder();
    }

    public bookingHistoryBuilder(){}

    /**
     *
     * @param csvString
     */
    public bookingHistoryBuilder(String csvString){
        this.updateFromCSVString(csvString);
    }

    /**
     *
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
     *
     * @param TID
     * @return
     */
    public bookingHistoryBuilder setTID(String TID){
        this.TID = TID;
        return this;
    }

    /**
     *
     * @param movieID
     * @return
     */
    public bookingHistoryBuilder setmovieID(String movieID){
        this.movieID = movieID;
        return this;
    }

    /**
     *
     * @param MobileNum
     * @return
     */
    public bookingHistoryBuilder setMobileNum(String MobileNum){
        this.MobileNum = MobileNum;
        return this;
    }

    /**
     *
     * @param Email
     * @return
     */
    public bookingHistoryBuilder setEmail(String Email){
        this.Email = Email;
        return this;
    }

    /**
     *
     * @param movieName
     * @return
     */
    public bookingHistoryBuilder setmovieName(String movieName){
        this.movieName = movieName;
        return this;
    }

    /**
     *
     * @param totalPrice
     * @return
     */
    public bookingHistoryBuilder settotalPrice(String totalPrice){
        this.totalPrice = totalPrice;
        return this;
    }


    /**
     *
     * @return
     */
    @Override
    public bookingHistory build(){
        return new bookingHistory(this);
    }



    
}
