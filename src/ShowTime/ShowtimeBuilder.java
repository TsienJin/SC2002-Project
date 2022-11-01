package ShowTime;


import Movie.InterfaceBuilder;
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

    public static ShowtimeBuilder showtime(){
        return new ShowtimeBuilder();
    }

    public ShowtimeBuilder(){}

    public ShowtimeBuilder(String csvString){
        ArrayList<String> csvArr = new ArrayList<>(Arrays.asList(csvString.split(mainDelimiter)));

        // MovieBuilder showtimeMovie = new MovieBuilder();
        // showtimeMovie.fromMovieID(csvArr.get(1));
        
        CinemaBuilder showtimeCinema = new CinemaBuilder();
        showtimeCinema.fromCinemaID(csvArr.get(2));

        this.showtimeID = csvArr.get(0);
        //this.movie = showtimeMovie.build();
        this.cinema = showtimeCinema.build();
        this.time_date = csvArr.get(3);

    }

    public ShowtimeBuilder setShowtimeID(String showtimeID){
        this.showtimeID = showtimeID;
        return this;
    }

    public ShowtimeBuilder setMovie(Movie movie){
        this.movie = movie;
        return this;
    }

    public ShowtimeBuilder setCinema(Cinema cinema){
        this.cinema = cinema;
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
