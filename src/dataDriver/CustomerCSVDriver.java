package dataDriver;

import Movie.Movie;
import Movie.MovieBuilder;
import Movie.Review;
import Movie.ReviewBuilder;
import UsrInput.UsrInput;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import UsrInput.UsrInput;
import dataDriver.InterfaceCsvDelimiter;

public class CustomerCSVDriver extends CSVDriver {

    // METHOD to get movie
    public Movie getMovie(String id){
        try{
            String movieString = super.fileio.findMatchFromFile(EnumDataFiles.Movie.toString(), id);
            // System.out.println(movieString);
            if(movieString.length()>0){
                return new MovieBuilder(movieString).build();
            } else {
                return null;
            }
        } catch (Exception e){
            return null;
        }
       
    }

    public void getBookingHistory(){

    }

    public void writeReview(){
        UsrInput usrInput = new UsrInput();
        Scanner sc = new Scanner(System.in);

        ReviewBuilder newReviewBuilder = new Movie.ReviewBuilder();

        newReviewBuilder.setID(usrInput.getUsrString("Enter your ID: "));
        newReviewBuilder.setMovieId(usrInput.getUsrString("Enter Movie ID: "));
        newReviewBuilder.setUsername(usrInput.getUsrString("Enter your username: "));
        newReviewBuilder.setstrReview(usrInput.getUsrString("Enter your review: "));
        System.out.printf("Enter Rating, 0-5: ");
        newReviewBuilder.setuserRating(sc.nextInt());
        
        Review newReview = new Review(newReviewBuilder);

        super.fileio.writeToFile(EnumDataFiles.Review.toString(), newReview.toCsvString());

        System.out.printf("Review added.\n");
    }

    public void bookSeat(){
        
    }
  
}
