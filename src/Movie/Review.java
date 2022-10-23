package Movie;

import java.util.ArrayList;

import dataDriver.InterfaceCsvDelimiter;
import dataDriver.InterfaceToCsvStringHelper;

public class Review implements InterfaceToCsvStringHelper, InterfaceCsvDelimiter{
    private String ID;
    private String movieID;
    private String username;
    private String strReview;
    private int usrRating;

    public Review(String ID,String strReview,int usrRating) {
        this.ID = ID;
        this.strReview = strReview;
        this.usrRating = usrRating;
    }

    public Review(ReviewBuilder builder){
        this.ID = builder.ID;
        this.movieID = builder.movieID;
        this.username = builder.username;
        this.strReview = builder.strReview;
        this.usrRating = builder.usrRating;
    }

    public String getID() {
        return this.ID;
    }

    public String getMovieID(){
        return this.movieID;
    }

    public String getstrReview() {
        return this.strReview;
    }

    public String getUsername(){
        return this.username;
    }

    public int getUsrRating() {
        return this.usrRating;
    }

    @Override
    public String toCsvString() {
        ArrayList<String> arrCSV = new ArrayList<>();
        arrCSV.add(this.movieID);
        arrCSV.add(this.ID);
        arrCSV.add(this.username);
        arrCSV.add(this.strReview);
        arrCSV.add(String.valueOf(this.usrRating));

        return String.join(mainDelimiter, arrCSV);
    }
}
