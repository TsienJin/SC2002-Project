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

    public ShowtimeBuilder(){}

    public ShowtimeBuilder(String csvString){
        ArrayList<String> csvArr = new ArrayList<>(Arrays.asList(csvString.split(mainDelimiter)));


        this.time_date = csvArr.get(2);

    }

    @Override
    public showtime build(){
        return new showtime(movie,cinema,time_date);
    }


}
