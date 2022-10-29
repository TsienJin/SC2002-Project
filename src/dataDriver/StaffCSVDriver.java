package dataDriver;

import Movie.MovieBuilder;

public class StaffCSVDriver extends CSVDriver {
 
    public boolean authenticate(String usrName, String usrPwd) {
        FileIO fetchUserPass = new FileIO();

        String userDetails = fetchUserPass.findMatchFromFile("staff.csv", usrName);
        // String csvUsername = userDetails.
        // String csvPassword = 
        
        if(1){
            return true;
        }
        else{
            return false;
        }
    }

    public void createMovieListing() {
        //Ask for input here?
                
        // after asking for all required parameters
        String finalUserInput = "Hello world, goodbye world";

        FileIO newMovie = new FileIO();
        newMovie.writeToFile("movie.csv", finalUserInput);

    }

    public void updateMovieListing() {
        //ask staff for movieID
        String movieID = "123";
        
        String finalUserInput = "Hello world, goodbye world";
        FileIO updateMovie = new FileIO();
        updateMovie.overwriteToFile("movie.csv", finalUserInput);
        

    }

    public void deleteMovieListing() {

    }

    public void createCinemaShowtime() {

    }

    public void updateCinemaShowtime() {

    }

    public void deleteCinemaShowtime() {

    }
}