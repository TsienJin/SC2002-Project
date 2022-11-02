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


    //Constructors
      /*public Cinema(){
        id = "";
        hallNumber = 0;
        cinemaCode = " ";
    }*/


    //Preceeded
    // public Cinema(String id, int hallNumber,String cinemaCode){
    //     this.id = id;
    //     this.hallNumber = hallNumber;
    //     this.cinemaCode = cinemaCode;
    // }

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



    //abstract methods - no method implementation
    //Implementation of all the abstract class
    /*public abstract void showLayout();
    public abstract boolean BookSeat(int row, int col);
    public abstract int getTotalSeats();
    public abstract int getNumEmptySeats();
    public abstract boolean isFullyBooked();*/





}
