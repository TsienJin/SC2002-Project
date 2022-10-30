package dataDriver;

import java.util.Scanner;

import Movie.Movie;
import Movie.MovieBuilder;

public class StaffCSVDriver extends CSVDriver implements InterfaceCsvDelimiter {
 
    public static String inputMovieDetails(){
        Scanner sc = new Scanner(System.in);
        String movieInput = "";
        System.out.print("Enter Movie ID: ");
        movieInput += sc.nextLine() + ",";

        System.out.print("Enter Movie Title: ");
        movieInput += sc.nextLine() + ",";

        System.out.print("Enter Showing Status: ");
        movieInput += sc.nextLine() + ",";

        System.out.print("Enter Movie Type: ");
        movieInput += sc.nextLine() + ",";

        System.out.print("Enter Movie Synopsis: ");
        movieInput += sc.nextLine() + ",";

        System.out.print("Enter Movie Director: ");
        movieInput += sc.nextLine() + ",";

        System.out.print("Enter Movie Casts: ");
        movieInput += sc.nextLine();
        
        return movieInput;
    }

    public boolean authenticate(String usrName, String usrPwd) {

        String staffDetails = super.fileio.findMatchFromFile(EnumDataFiles.StaffUser.toString(), usrName);
        //System.out.println(staffDetails);

        if(staffDetails.length()==0){
            return false;
        } else {
            String[] staffArray = staffDetails.split(mainDelimiter);
            String csvUsername = staffArray[0];
            String csvPassword = staffArray[2];

            return (usrName.equals(csvUsername) && usrPwd.equals(csvPassword));
        }

        
    }

    public void createMovieListing() {
        String newMovieString = StaffCSVDriver.inputMovieDetails();

        MovieBuilder newMovieBuilder = new MovieBuilder(newMovieString);

        Movie newMovie = new Movie(newMovieBuilder);

        super.fileio.writeToFile(EnumDataFiles.Movie.toString(), newMovie.toCsvString());
        
        System.out.println("Movie created!");
    }

    public void updateMovieListing() {
        String updateMovieString = StaffCSVDriver.inputMovieDetails();

        MovieBuilder udpateMovieBuilder = new MovieBuilder(updateMovieString);

        Movie updateMovie = new Movie(udpateMovieBuilder);

        super.fileio.updateKeyInFile(EnumDataFiles.Movie.toString(), updateMovie.toCsvString());
        
        System.out.println("Movie updated!");

    }

    public void deleteMovieListing() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Movie ID: ");
        String deleteMovie = sc.nextLine();

        super.fileio.updateKeyInFile(EnumDataFiles.Movie.toString(), deleteMovie);
        sc.close();
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