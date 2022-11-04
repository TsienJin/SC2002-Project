package dataDriver;

import java.util.concurrent.ThreadLocalRandom;

import Movie.Movie;
import Movie.MovieBuilder;
import Movie.Review;
import Movie.ReviewBuilder;
import UsrInput.UsrInput;

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

        ReviewBuilder newReviewBuilder = new ReviewBuilder();

        newReviewBuilder.setID(String.format("%d", ThreadLocalRandom.current().nextInt(1000, 9999 + 1)));
        newReviewBuilder.setMovieId(usrInput.getUsrString("Enter Movie ID: "));
        newReviewBuilder.setUsername(usrInput.getUsrString("Enter your username: "));
        newReviewBuilder.setstrReview(usrInput.getUsrString("Enter your review: "));
        newReviewBuilder.setuserRating(usrInput.getUsrInt("Enter Rating, 0-5: "));
        
        Review newReview = new Review(newReviewBuilder);

        super.fileio.writeToFile(EnumDataFiles.Review.toString(), newReview.toCsvString());

        System.out.printf("Review added.\n");
    }

    public void bookSeat(){
        
    }
  
}
