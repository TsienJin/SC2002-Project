package ShowTime;


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
    // String movieId;
    // String cinemaId;
    

    public static ShowtimeBuilder showtime(){
        return new ShowtimeBuilder();
    }

    public ShowtimeBuilder(){}

    public ShowtimeBuilder(String csvString){
        ArrayList<String> csvArr = new ArrayList<>(Arrays.asList(csvString.split(mainDelimiter)));

        //this.movie = new MovieBuilder().fromMovieID(csvArr.get(1)).build();
        //this.cinema = new CinemaBuilder().fromCinemaID(csvArr.get(2)).build();
        this.showtimeID = csvArr.get(0);
        this.movie = new MovieBuilder().fromMovieID(csvArr.get(1)).build();
        this.cinema = new CinemaBuilder().fromCinemaID(csvArr.get(2)).build();
        // this.movieId = csvArr.get(1);
        // this.cinemaId = csvArr.get(2);
        this.time_date = csvArr.get(3);

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

    public ShowtimeBuilder setShowtimeID(String showtimeID){
        this.showtimeID = showtimeID;
        return this;
    }

    public ShowtimeBuilder setMovie(String movieId){
        // this.movieId = movieId;
        this.movie = new MovieBuilder().fromMovieID(movieId).build();
        return this;
    }

    public ShowtimeBuilder setCinema(String cinemaId){
        // this.cinemaId = cinemaId;
        this.cinema = new CinemaBuilder().fromCinemaID(cinemaId).build();
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
