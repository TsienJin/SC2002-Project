package ShowTime;


import Movie.InterfaceBuilder;
import dataDriver.InterfaceCsvDelimiter;
import Movie.*;
import MovieTheatres.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ShowtimeBuilder implements InterfaceBuilder<showtime>, InterfaceCsvDelimiter {

    Movie movie;
    Cinema cinema;
    String time_date;

    public static ShowtimeBuilder showtime(){
        return new ShowtimeBuilder();
    }

    public ShowtimeBuilder(){}

    public ShowtimeBuilder(String csvString){
        ArrayList<String> csvArr = new ArrayList<>(Arrays.asList(csvString.split(mainDelimiter)));

        this.movie = csvArr.get(0);
        this.cinema = csvArr.get(1);
        this.time_date = csvArr.get(2);

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
    public Showtime build(){
        return new showtime(this);
    }


}
