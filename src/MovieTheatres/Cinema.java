package MovieTheatres;

import java.util.*;
import dataDriver.InterfaceCsvDelimiter;
import dataDriver.InterfaceToCsvStringHelper;

public class Cinema implements InterfaceCsvDelimiter,InterfaceToCsvStringHelper{
    private String id;
    private int hallNumber;
    private String cinemaCode;

    /** 
     * Constructor for Cinema object
     */
    public Cinema(CinemaBuilder builder){
        this.id = builder.id;
        this.hallNumber = builder.hallNumber;
        this.cinemaCode = builder.cinemaCode;
    }


    
    /** 
     * Returns a constructed string of attributes for Cinema object in the form of csv line
     * @return Constructed string of attributes
     */
    public String toCsvString() {

        // Delimiters are from the toCsvStringHelper interface
        ArrayList<String> arrCSV = new ArrayList<>();

        arrCSV.add(this.id);
        arrCSV.add(String.valueOf(this.hallNumber));
        arrCSV.add(this.cinemaCode);

        return String.join(mainDelimiter, arrCSV);
    }

    
    /** 
     * Returns attribute ID of Cinema object
     * @return ID attribute
     */
    //Accessor Methods
    public String getId(){
        return this.id;
    }
    
    /** 
     * Returns attribute hallNumber of Cinema object
     * @return hallNumber attribute
     */
    public int getHallNumber(){
        return this.hallNumber;
    }
    
    /** 
     * Returns attribute cinemaCode of Cinema object
     * @return cinemaCode attribute
     */
    public String getCinemaCode(){
        return this.cinemaCode;
    }
    
    /** 
     * Returns attribute cinemaClass of Cinema object from cinemaCode
     * @return cinemaClass attribute
     */
    public String getCinemaclass(){
        char firstchar = this.cinemaCode.charAt(0);
        if(Character.compare(firstchar,'R')==0){
            return "Regular";
        }
        else if(Character.compare(firstchar,'F')==0){
            return "First";
        }
        else if(Character.compare(firstchar,'G')==0){
            return "Gold";
        }
        else{
            return "NULL";
        }
        
    }

    //Mutator Methods
    
    /** 
     * Setter for attribute ID for Cinema object
     * @param id
     */
    public void setId(String id){
        this.id = id;
    }
    
    /** 
     * Setter for attribute hallNumber for Cinema object
     * @param hallNumber
     */
    public void setHallNumber(int hallNumber){
        this.hallNumber = hallNumber;
    }
    
    /** 
     * Setter for attribute cinemaCode for Cinema object
     * @param cinemaCode
     */
    public void setCinemaCode(String cinemaCode){
        this.cinemaCode = cinemaCode;
    }

    //abstract methods - no method implementation
    //Implementation of all the abstract class
    /*public abstract void showLayout();
    public abstract boolean BookSeat(int row, int col);
    public abstract int getTotalSeats();
    public abstract int getNumEmptySeats();
    public abstract boolean isFullyBooked();*/





}
