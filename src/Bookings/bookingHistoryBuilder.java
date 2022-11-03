package Booking;

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



    public static bookingHistoryBuilder bookingHistory(){
        return new bookingHistoryBuilder();
    }

    public bookingHistoryBuilder(){}

    public bookingHistoryBuilder(String csvString){
        this.updateFromCSVString(csvString);
    }

    private void updateFromCSVString(String csvString){
        ArrayList<String> csvArr = new ArrayList<>(Arrays.asList(csvString.split(mainDelimiter)));

        this.TID = csvArr.get(0);
        this.movieID = csvArr.get(1);
        this.MobileNum = csvArr.get(2);
        this.Email = csvArr.get(3);
        this.movieName = csvArr.get(4);
    }

    public bookingHistoryBuilder setTID(String TID){
        this.TID = TID;
        return this;
    }

    public bookingHistoryBuilder setmovieID(String movieID){
        this.movieID = movieID;
        return this;
    }

    public bookingHistoryBuilder setMobileNum(String MobileNum){
        this.MobileNum = MobileNum;
        return this;
    }

    public bookingHistoryBuilder setEmail(String Email){
        this.Email = Email;
        return this;
    }
    public bookingHistoryBuilder setmovieName(String movieName){
        this.movieName = movieName;
        return this;
    }


    @Override
    public bookingHistory build(){
        return new bookingHistory(this);
    }



    
}
