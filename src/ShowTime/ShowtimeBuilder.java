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
    String bookedSeat;
    
    private FileIO fileio = new FileIO();

    public static ShowtimeBuilder showtime(){
        return new ShowtimeBuilder();
    }

    public ShowtimeBuilder(){}

    public ShowtimeBuilder(String csvString){
        this.updateFromCsvString(csvString);
    }

    private void updateFromCsvString(String csvString){
        ArrayList<String> csvArr = new ArrayList<>(Arrays.asList(csvString.split(mainDelimiter)));

        this.showtimeID = csvArr.get(0);
        this.movie = new MovieBuilder().fromMovieID(csvArr.get(1)).build();
        this.cinema = new CinemaBuilder().fromCinemaCode(csvArr.get(2)).build();
        this.time_date = csvArr.get(3);
        this.bookedSeat = csvArr.get(4);

    }

    /*public ShowtimeBuilder setMovie(Movie movie){
        this.movie = movie;
        //this.movie = new MovieBuilder().fromMovieID(csvArr.get(1)).build();
        //this.cinema = new CinemaBuilder().fromCinemaID(csvArr.get(2)).build();
        this.movieId = csvArr.get(1);
        this.cinemaId = csvArr.get(2);
        this.showtimeID = csvArr.get(0);
        this.time_date = csvArr.get(3);

    }*/

    public ShowtimeBuilder fromShowtimeID(String showtimeID){
        try {
            String csvString = fileio.findMatchFromFile(EnumDataFiles.Showtime.toString(), showtimeID);
            this.updateFromCsvString(csvString);
        } catch (Exception e) {
            //pass
        }
        return this;
    }

    public ShowtimeBuilder setShowtimeID(String showtimeID){
        this.showtimeID = showtimeID;
        return this;
    }

    public ShowtimeBuilder setMovie(String movieId){
        this.movie = new MovieBuilder().fromMovieID(movieId).build();
        return this;
    }

    public ShowtimeBuilder setCinema(String cinemaCode){
        this.cinema = new CinemaBuilder().fromCinemaCode(cinemaCode).build();
        return this;
    }

    public ShowtimeBuilder setTimeDate(String time_date){
        this.time_date = time_date;
        return this;
    }

    @Override
    public showtime build(){
        return new showtime(this);
    }


}
