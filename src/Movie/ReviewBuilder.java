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

    public ReviewBuilder(String csvString){
        ArrayList<String> csvArr = new ArrayList<>(Arrays.asList(csvString.split(mainDelimiter)));
        this.movieID = csvArr.get(0);
        this.ID = csvArr.get(1);
        this.username = csvArr.get(2);
        this.strReview = csvArr.get(3);
        this.usrRating = Integer.parseInt(csvArr.get(4));
    }


    public ReviewBuilder setID(String ID) {
        this.ID = ID;
        return this;
    }

    public ReviewBuilder setMovieId(String movieID){
        this.movieID = movieID;
        return this;
    }

    public ReviewBuilder setUsername(String username){
        this.username = username;
        return this;
    }

    public ReviewBuilder setstrReview(String strReview) {
        this.strReview = strReview;
        return this;
    }

    public ReviewBuilder setuserRating(int userRating) {
        this.usrRating = userRating;
        return this;
    }





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
