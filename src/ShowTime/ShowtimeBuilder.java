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
     * @return ShowtimeBuilder
     */
    public static ShowtimeBuilder showtime(){
        return new ShowtimeBuilder();
    }

    public ShowtimeBuilder(){}

    public ShowtimeBuilder(String csvString){
        this.updateFromCsvString(csvString);
    }

    
    /** 
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
     * @param showtimeID
     * @return ShowtimeBuilder
     */
    public ShowtimeBuilder setShowtimeID(String showtimeID){
        this.showtimeID = showtimeID;
        return this;
    }

    
    /** 
     * @param movieId
     * @return ShowtimeBuilder
     */
    public ShowtimeBuilder setMovie(String movieId){
        this.movie = new MovieBuilder().fromMovieID(movieId).build();
        return this;
    }

    
    /** 
     * @param cinemaCode
     * @return ShowtimeBuilder
     */
    public ShowtimeBuilder setCinema(String cinemaCode){
        this.cinema = new CinemaBuilder().fromCinemaCode(cinemaCode).build();
        return this;
    }

    
    /** 
     * @param time_date
     * @return ShowtimeBuilder
     */
    public ShowtimeBuilder setTimeDate(String time_date){
        this.time_date = time_date;
        return this;
    }

    
    /** 
     * @param cinemaCode
     * @return String
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
     * @return showtime
     */
    @Override
    public showtime build(){
        return new showtime(this);
    }


}
