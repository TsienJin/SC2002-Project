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
    }

    public CinemaBuilder fromCinemaID(String id){
        try {
            String csvString = fileio.findMatchFromFile(EnumDataFiles.Cinema.toString(), id);
            this.updateFromCsvString(csvString);
        } catch (Exception e) {
            //pass
        }
        return this;
    }

    public CinemaBuilder fromCinemaCode(String cinemaCode){
        try {
            String csvString = fileio.findMatchFromFile(EnumDataFiles.Cinema.toString(), cinemaCode, 2);
            this.updateFromCsvString(csvString);
        } catch (Exception e) {
            //pass
        }
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

    @Override
    public Cinema build() {
        return new Cinema(this);
    }

}
