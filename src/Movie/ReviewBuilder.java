package Movie;

import java.util.ArrayList;
import java.util.Arrays;

import dataDriver.InterfaceCsvDelimiter;

public class ReviewBuilder implements InterfaceBuilder<Review>, InterfaceCsvDelimiter {
    String ID;
    String movieID;
    String username;
    String strReview;
    int usrRating;


    /**
     * Default Constructor
     */
    public ReviewBuilder() {}

    /** 
     * Construct ReviewBuilder object from CSV String input
     * @param csvString
     */
    public ReviewBuilder(String csvString){
        ArrayList<String> csvArr = new ArrayList<>(Arrays.asList(csvString.split(mainDelimiter)));
        this.movieID = csvArr.get(0);
        this.ID = csvArr.get(1);
        this.username = csvArr.get(2);
        this.strReview = csvArr.get(3);
        this.usrRating = Integer.parseInt(csvArr.get(4));
    }




    
    /** 
     * Sets ID attribute of ReviewBuilder object
     * @param ID
     * @return ReviewBuilder
     */
    public ReviewBuilder setID(String ID) {
        this.ID = ID;
        return this;
    }

    
    /** 
     * Sets movieID attribute of ReviewBuilder object
     * @param movieID
     * @return ReviewBuilder
     */
    public ReviewBuilder setMovieId(String movieID){
        this.movieID = movieID;
        return this;
    }

    
    /** 
     * Sets username attribute of ReviewBuilder object
     * @param username
     * @return ReviewBuilder
     */
    public ReviewBuilder setUsername(String username){
        this.username = username;
        return this;
    }

    
    /** 
     * Sets strReview attribute of ReviewBuilder object
     * @param strReview
     * @return ReviewBuilder
     */
    public ReviewBuilder setstrReview(String strReview) {
        this.strReview = strReview;
        return this;
    }

    
    /** 
     * Sets userRating attribute of ReviewBuilder object
     * @param userRating
     * @return ReviewBuilder
     */
    public ReviewBuilder setuserRating(int userRating) {
        this.usrRating = userRating;
        return this;
    }

    /** 
     * Build method to construct Review object
     * @return showtime
     */
    @Override
    public Review build(){
        return new Review(this);
    }

    // @Override
    // public Review fromCsvString(String csvString) {
    //     ArrayList<String> csvArr = new ArrayList<>(Arrays.asList(csvString.split(mainDelimiter)));
    //     this.movieID = csvArr.get(0);
    //     this.ID = csvArr.get(1);
    //     this.username = csvArr.get(2);
    //     this.strReview = csvArr.get(3);
    //     this.usrRating = Integer.parseInt(csvArr.get(4));

    //     return new Review(this);
    // }
}
