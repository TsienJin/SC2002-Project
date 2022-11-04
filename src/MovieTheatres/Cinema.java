package MovieTheatres;

import java.util.*;
import dataDriver.InterfaceCsvDelimiter;
import dataDriver.InterfaceToCsvStringHelper;

public class Cinema implements InterfaceCsvDelimiter,InterfaceToCsvStringHelper{
    private String id;
    private int hallNumber;
    private String cinemaCode;
    private String bookedSeat;
    private String showTimeId;
    private String time;
    private String movieDay;


    public Cinema(CinemaBuilder builder){
        this.id = builder.id;
        this.hallNumber = builder.hallNumber;
        this.cinemaCode = builder.cinemaCode;
        this.bookedSeat = builder.bookedSeat;
        this.showTimeId = builder.showTimeId;
        this.time = builder.time;
        this.movieDay = builder.movieDay;
    }


    public String toCsvString() {

        // Delimiters are from the toCsvStringHelper interface
        ArrayList<String> arrCSV = new ArrayList<>();

        arrCSV.add(this.id);
        arrCSV.add(String.valueOf(this.hallNumber));
        arrCSV.add(this.cinemaCode);
        arrCSV.add(this.bookedSeat);
        arrCSV.add(this.showTimeId);
        arrCSV.add(this.time);
        arrCSV.add(this.movieDay);

        return String.join(mainDelimiter, arrCSV);
    }

    //Accessor Methods
    public String getId(){
        return this.id;
    }
    public int getHallNumber(){
        return this.hallNumber;
    }
    public String getCinemaCode(){
        return this.cinemaCode;
    }
    public String getBookedSeat(){
        return this.bookedSeat;
    }
    public String getShowtimeID(){
        return this.showTimeId;
    }
    public String gettime(){
        return this.time;
    }
    public String getmovieDay(){
        return this.movieDay;
    }
    public String getCinemaclass(){
        char firstchar = this.cinemaCode.charAt(0);
        if(Character.compare(firstchar,'R')==0){
            return "Regular";
        }
        else if(Character.compare(firstchar,'F')==0){
            return "First";
        }
        else if(Character.compare(firstchar,'G')==0){
            return "Gold";
        }
        else{
            return "NULL";
        }
        
    }

    //Mutator Methods
    public void setId(String id){
        this.id = id;
    }
    public void setHallNumber(int hallNumber){
        this.hallNumber = hallNumber;
    }
    public void setCinemaCode(String cinemaCode){
        this.cinemaCode = cinemaCode;
    }
    public void setBookedSeat(String bookedSeat){
        this.bookedSeat = bookedSeat;
    }
    public void setShowtimeID(String showTimeId){
        this.showTimeId = showTimeId;
    }

    //abstract methods - no method implementation
    //Implementation of all the abstract class
    /*public abstract void showLayout();
    public abstract boolean BookSeat(int row, int col);
    public abstract int getTotalSeats();
    public abstract int getNumEmptySeats();
    public abstract boolean isFullyBooked();*/





}
