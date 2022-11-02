package MovieTheatres;

import java.util.ArrayList;
import java.util.Arrays;

import Movie.InterfaceBuilder;
import dataDriver.EnumDataFiles;
import dataDriver.FileIO;
import dataDriver.InterfaceCsvDelimiter;


public class CinemaBuilder implements InterfaceBuilder<Cinema>, InterfaceCsvDelimiter {
    String id;
    int hallNumber;
    String cinemaCode;
    String bookedSeat;
    String showTimeId;
    String time;
    String movieDay;

    private FileIO fileio = new FileIO();

    public static CinemaBuilder Cinema(){
        return new CinemaBuilder();
    }

    public CinemaBuilder(){}

    public CinemaBuilder(String csvString){
        this.updateFromCsvString(csvString);
    }

    private void updateFromCsvString(String csvString){
        ArrayList<String> csvArr = new ArrayList<>(Arrays.asList(csvString.split(mainDelimiter)));

        this.id = csvArr.get(0);
        this.hallNumber = Integer.parseInt(csvArr.get(1));
        this.cinemaCode = csvArr.get(2);
        this.bookedSeat = csvArr.get(3);
        this.showTimeId = csvArr.get(4);
        this.time = csvArr.get(5);
        this.movieDay = csvArr.get(6);
    }


    public CinemaBuilder fromCinemaID(String id){
        String csvString = fileio.findMatchFromFile(EnumDataFiles.Cinema.toString(), id);
        this.updateFromCsvString(csvString);
        return this;
    }


    public CinemaBuilder setCinemaID(String id){
        this.id = id;
        return this;
    }

    public CinemaBuilder setHallNumber(int hallNumber){
        this.hallNumber = hallNumber;
        return this;
    }

    public CinemaBuilder setCinemaCode(String cinemaCode){
        this.cinemaCode = cinemaCode;
        return this;
    }

    public CinemaBuilder setBookedSeat(String bookedSeat){
        this.bookedSeat = bookedSeat;
        return this;
    }
    public CinemaBuilder setShowTimeId(String showTimeId){
        this.showTimeId = showTimeId;
        return this;
    }
    public CinemaBuilder setTime(String time){
        this.time = time;
        return this;
    }
    public CinemaBuilder setMovieDay(String movieDay){
        this.movieDay = movieDay;
        return this;
    }

    @Override
    public Cinema build() {
        return new Cinema(this);
    }

}
