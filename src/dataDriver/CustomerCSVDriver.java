package dataDriver;

import java.util.concurrent.ThreadLocalRandom;

import Movie.Movie;
import Movie.MovieBuilder;
import Movie.Review;
import Movie.ReviewBuilder;
import UsrInput.UsrInput;

public class CustomerCSVDriver extends CSVDriver {
    private UsrInput usrInput = new UsrInput();

    public ReviewBuilder inputReviewDetails(ReviewBuilder inputReview) {
        inputReview.setID(String.format("%d", ThreadLocalRandom.current().nextInt(1000, 9999 + 1)));
        inputReview.setMovieId(usrInput.getUsrString("Enter Movie ID: "));
        inputReview.setUsername(usrInput.getUsrString("Enter your username: "));
        inputReview.setstrReview(usrInput.getUsrString("Enter your review: "));
        inputReview.setuserRating(usrInput.getUsrInt("Enter Rating, 0-5: "));

        return inputReview;
    }
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

    public void writeReview(){
        Review newReview = this.inputReviewDetails(new ReviewBuilder()).build();
        super.fileio.writeToFile(EnumDataFiles.Review.toString(), newReview.toCsvString());
        System.out.printf("Review added.\n");
    }  
}
