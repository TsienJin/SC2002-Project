package MovieTheatres;

import java.util.ArrayList;
import java.util.Arrays;

import Movie.InterfaceBuilder;
import dataDriver.EnumDataFiles;
import dataDriver.FileIO;
import dataDriver.InterfaceCsvDelimiter;

public class CinemaBuilder implements InterfaceBuilder<Cinema>, InterfaceCsvDelimiter {
    private FileIO fileio = new FileIO();
    String id;
    int hallNumber;
    String cinemaCode;

    
    /** 
     * Constructs new Cinema()
     * @return CinemaBuilder
     */
    public static CinemaBuilder Cinema(){
        return new CinemaBuilder();
    }

    /**
     * Default Constructor
     */
    public CinemaBuilder(){}

    /**
     * Updates CinemaBuilder object attributes from Cinema File via `updateFromCsvString()`
     * @param csvString
     */
    public CinemaBuilder(String csvString){
        this.updateFromCsvString(csvString);
    }

    
    /** 
     * Updates CinemaBuilder object attributes from Cinema File
     * @param csvString
     */
    private void updateFromCsvString(String csvString){
        ArrayList<String> csvArr = new ArrayList<>(Arrays.asList(csvString.split(mainDelimiter)));

        this.id = csvArr.get(0);
        this.hallNumber = Integer.parseInt(csvArr.get(1));
        this.cinemaCode = csvArr.get(2);
    }

    
    /** 
     * Finds Cinema object thorugh CinemaID via `findMatchFromFile()`
     * @param id
     * @return CinemaBuilder
     */
    public CinemaBuilder fromCinemaID(String id){
        try {
            String csvString = fileio.findMatchFromFile(EnumDataFiles.Cinema.toString(), id);
            this.updateFromCsvString(csvString);
        } catch (Exception e) {
            //pass
        }
        return this;
    }

    
    /** 
     * Finds Cinema object thorugh cinemaCode via `findMatchFromFile()`
     * @param cinemaCode
     * @return CinemaBuilder
     */
    public CinemaBuilder fromCinemaCode(String cinemaCode){
        try {
            String csvString = fileio.findMatchFromFile(EnumDataFiles.Cinema.toString(), cinemaCode, 2);
            this.updateFromCsvString(csvString);
        } catch (Exception e) {
            //pass
        }
        return this;
    }

    
    /** 
     * Sets CinemaID attribute of CinemaBuilder object
     * @param id
     * @return CinemaBuilder
     */
    public CinemaBuilder setCinemaID(String id){
        this.id = id;
        return this;
    }

    
    /** 
     * Sets hallNumber attribute of CinemaBuilder object
     * @param hallNumber
     * @return CinemaBuilder
     */
    public CinemaBuilder setHallNumber(int hallNumber){
        this.hallNumber = hallNumber;
        return this;
    }

    
    /** 
     * Sets cinemaCode attribute of CinemaBuilder object
     * @param cinemaCode
     * @return CinemaBuilder
     */
    public CinemaBuilder setCinemaCode(String cinemaCode){
        this.cinemaCode = cinemaCode;
        return this;
    }

    
    /** 
     * Build method to construct CInema object
     * @return Cinema
     */
    @Override
    public Cinema build() {
        return new Cinema(this);
    }

}
