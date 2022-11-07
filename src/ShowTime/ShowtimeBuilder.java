package ShowTime;


import dataDriver.EnumDataFiles;
import dataDriver.FileIO;
import dataDriver.InterfaceCsvDelimiter;
import Movie.*;
import MovieTheatres.*;

import java.util.ArrayList;
import java.util.Arrays;


public class ShowtimeBuilder implements InterfaceBuilder<showtime>, InterfaceCsvDelimiter {
    FileIO showtimeFileio = new FileIO();
    
    String showtimeID;
    Movie movie;
    Cinema cinema;
    String time_date;
    String bookedSeat = null;
    
    private FileIO fileio = new FileIO();

    
    /** 
     * Constructs new ShowtimeBuilder()
     * @return ShowtimeBuilder
     */
    public static ShowtimeBuilder showtime(){
        return new ShowtimeBuilder();
    }

    /**
     * Default Constructor
     */
    public ShowtimeBuilder(){}

    /**
     * Updates ShowtimeBuilder object attributes from Showtime File via `updateFromCsvString()`
     * @param csvString
     */
    public ShowtimeBuilder(String csvString){
        this.updateFromCsvString(csvString);
    }

    
    /** 
     * Updates ShowtimeBuilder object attributes from Showtime File
     * @param csvString
     */
    private void updateFromCsvString(String csvString){
        ArrayList<String> csvArr = new ArrayList<>(Arrays.asList(csvString.split(mainDelimiter)));

        this.showtimeID = csvArr.get(0);
        this.movie = new MovieBuilder().fromMovieID(csvArr.get(1)).build();
        this.cinema = new CinemaBuilder().fromCinemaCode(csvArr.get(2)).build();
        this.bookedSeat = csvArr.get(3);
        this.time_date = csvArr.get(4);
        

    }

    
    /** 
     * Finds Showtime object thorugh Showtime ID via `findMatchFromFile()`
     * @param showtimeID
     * @return ShowtimeBuilder
     */
    public ShowtimeBuilder fromShowtimeID(String showtimeID){
        try {
            String csvString = fileio.findMatchFromFile(EnumDataFiles.Showtime.toString(), showtimeID);
            this.updateFromCsvString(csvString);
        } catch (Exception e) {
            //pass
        }
        return this;
    }

    
    /** 
     * Sets ShowtimeID attribute of ShowtimeBuilder object
     * @param showtimeID
     * @return ShowtimeBuilder
     */
    public ShowtimeBuilder setShowtimeID(String showtimeID){
        this.showtimeID = showtimeID;
        return this;
    }

    
    /** 
     * Sets movieId attribute of ShowtimeBuilder object
     * @param movieId
     * @return ShowtimeBuilder
     */
    public ShowtimeBuilder setMovie(String movieId){
        this.movie = new MovieBuilder().fromMovieID(movieId).build();
        return this;
    }

    
    /** 
     * Sets cinemaCode attribute of ShowtimeBuilder object
     * @param cinemaCode
     * @return ShowtimeBuilder
     */
    public ShowtimeBuilder setCinema(String cinemaCode){
        this.cinema = new CinemaBuilder().fromCinemaCode(cinemaCode).build();
        return this;
    }

    
    /** 
     * Sets time_date attribute of ShowtimeBuilder object
     * @param time_date
     * @return ShowtimeBuilder
     */
    public ShowtimeBuilder setTimeDate(String time_date){
        this.time_date = time_date;
        return this;
    }

    
    /** 
     * Get class of Cinema with cinemaCode attribute.
     * @param cinemaCode
     * @return String cinema class
     */
    public String getCinemaClass(String cinemaCode){
        if(Character.compare(cinemaCode.charAt(0),'R')==0){
            return "Regular";
        }
        else if(Character.compare(cinemaCode.charAt(0),'F')==0){
            return "First";
        }
        else if(Character.compare(cinemaCode.charAt(0),'G')==0){
            return "Gold";
        }
        return null;
    }

    
    /** 
     * Build method to construct movie object
     * @return showtime
     */
    @Override
    public showtime build(){
        return new showtime(this);
    }


}
