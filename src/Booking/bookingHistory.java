package Booking;
import java.util.*;
import dataDriver.InterfaceCsvDelimiter;
import dataDriver.InterfaceToCsvStringHelper;

public class bookingHistory implements InterfaceCsvDelimiter,InterfaceToCsvStringHelper{
    private String TID;
    private String movieID;
    private String MobileNum;
    private String Email;
    private String numOfTickets;
    private String totalTicketPrice;

    public bookingHistory(bookingHistoryBuilder builder){
        this.TID = builder.TID;
        this.movieID = builder.movieID;
        this.MobileNum = builder.MobileNum;
        this.Email = builder.Email;
        this.numOfTickets = builder.numOfTickets;
        this.totalTicketPrice = builder.totalTicketPrice;
    }

    public String toCsvString(){
        ArrayList<String> arrCSV = new ArrayList<>();

        arrCSV.add(this.TID);
        arrCSV.add(this.movieID);
        arrCSV.add(this.MobileNum);
        arrCSV.add(this.Email);
        arrCSV.add(this.numOfTickets);
        arrCSV.add(this.totalTicketPrice);

        return String.join(mainDelimiter,arrCSV);
    }

    public String getTID(){
        return this.TID;
    }
    public String getmovieID(){
        return this.movieID;
    }
    public String getMobileNum(){
        return this.MobileNum;
    }
    public String getEmail(){
        return this.Email;
    }
    public String getnumOfTickets(){
        return this.numOfTickets;
    }
    public String gettotalTicketPrice(){
        return this.totalTicketPrice;
    }




    
}
