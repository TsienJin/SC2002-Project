package dataDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Movie.EnumMovieType;
import Movie.EnumShowingStatus;
import Movie.Movie;
import Movie.MovieBuilder;
import UsrInput.UsrInput;

public class StaffCSVDriver extends CSVDriver {
 
    public static void inputMovieDetails(MovieBuilder inputMovie){
        UsrInput usrInput = new UsrInput();
        Scanner sc = new Scanner(System.in);

        inputMovie.setID(usrInput.getUsrString("Enter Movie ID: "));
        inputMovie.setMovieTitle(usrInput.getUsrString("Enter Movie Title: "));
        inputMovie.setStatus(EnumShowingStatus.valueOf(usrInput.getUsrString("Enter Showing Status: ")));
        inputMovie.setMovieType(EnumMovieType.valueOf(usrInput.getUsrString("Enter Movie Type: ")));
        inputMovie.setSynopsis(usrInput.getUsrString("Enter Movie Synopsis: "));
        inputMovie.setDirector(usrInput.getUsrString("Enter Movie Director: "));
        inputMovie.setCast(new ArrayList<>(Arrays.asList((usrInput.getUsrString("Enter Movie Casts: ")))));
        
    }

    public boolean authenticate(String usrName, String usrPwd) {

        String staffDetails = super.fileio.findMatchFromFile(EnumDataFiles.StaffUser.toString(), usrName);
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
        MovieBuilder newMovieBuilder = new MovieBuilder();

        StaffCSVDriver.inputMovieDetails(newMovieBuilder);

        Movie newMovie = new Movie(newMovieBuilder);

        super.fileio.writeToFile(EnumDataFiles.Movie.toString(), newMovie.toCsvString());
        
        System.out.println("Movie created!");
    }

    public void updateMovieListing() {
        MovieBuilder updateMovieBuilder = new MovieBuilder();

        StaffCSVDriver.inputMovieDetails(updateMovieBuilder);

        Movie updateMovie = new Movie(updateMovieBuilder);

        super.fileio.updateKeyInFile(EnumDataFiles.Movie.toString(), updateMovie.toCsvString());
        
        System.out.println("Movie updated!");

    }

    public void deleteMovieListing() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Movie ID: ");
        String deleteMovie = sc.nextLine();

        super.fileio.deleteKeyInFile(EnumDataFiles.Movie.toString(), deleteMovie);
        System.out.println("Movie deleted!");
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

        hallo.createMovieListing();
        hallo.updateMovieListing();
        hallo.deleteMovieListing();
    }
}