package dataDriver;

import Movie.MovieBuilder;

public class StaffCSVDriver extends CSVDriver {
 
    public boolean authenticate(String usrName, String usrPwd) {
        FileIO fetchUserPass = new FileIO();

        String staffDetails = fetchUserPass.findMatchFromFile("staffUser.csv", usrName);
        //System.out.println(staffDetails);
        String[] staffArray = staffDetails.split(","); //Need to find a better way to do this
        String csvUsername = staffArray[0];
        String csvPassword = staffArray[2];

        if(usrName.equals(csvUsername) && usrPwd.equals(csvPassword)){
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

    public static void main(String[] args) {
        StaffCSVDriver hallo = new StaffCSVDriver();
        
        if(hallo.authenticate("admin1", "password")){
            System.out.println("Username and password matches");
        }
        else{
            System.out.println("Not matched");
        }
    }
}