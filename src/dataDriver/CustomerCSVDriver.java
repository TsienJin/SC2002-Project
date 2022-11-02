package dataDriver;

import Movie.Movie;
import Movie.MovieBuilder;

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

    }

    public void bookSeat(){
        
    }
    
}
