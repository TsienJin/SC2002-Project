package dataDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Movie.EnumMovieParser;
import Movie.EnumMovieType;
import Movie.EnumShowingStatus;
import Movie.Movie;
import Movie.MovieBuilder;
import ShowTime.ShowtimeBuilder;
import ShowTime.showtime;
import UsrInput.UsrInput;

public class StaffCSVDriver extends CSVDriver implements InterfaceCsvDelimiter {
    private UsrInput usrInput = new UsrInput();
    private EnumMovieParser movieEnum = new EnumMovieParser();

    public void inputMovieDetails(MovieBuilder inputMovie){

        inputMovie.setID(usrInput.getUsrString("Enter Movie ID: "));
        inputMovie.setMovieTitle(usrInput.getUsrString("Enter Movie Title: "));
        inputMovie.setStatus(movieEnum.inputShowingStatus());
        inputMovie.setMovieType(movieEnum.inputMovieType());
        inputMovie.setSynopsis(usrInput.getUsrString("Enter Movie Synopsis: "));
        inputMovie.setDirector(usrInput.getUsrString("Enter Movie Director: "));
        // inputMovie.setCast(new ArrayList<>(Arrays.asList(this.usrInput.getUsrString("Enter Movie Casts (seperate with comma): ").split(","))));

        String castCsvString = usrInput.getUsrString("Enter Movie Casts (seperate with comma): ");
        ArrayList<String> cast = new ArrayList<>();
        for (String person : castCsvString.split(",")) {
            cast.add(person.strip());
        }
        

        inputMovie.setCast(cast);
    }

    public void inputShowtime(ShowtimeBuilder inputShowtime){
        UsrInput usrInput = new UsrInput();

        inputShowtime.setMovie(usrInput.getUsrString("Enter Movie ID: "));
        inputShowtime.setCinema(usrInput.getUsrString("Enter Cinema ID: "));
        inputShowtime.setTimeDate(usrInput.getUsrString("Enter Time Date: "));
        
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
        MovieBuilder newMovieBuilder = new MovieBuilder();

        this.inputMovieDetails(newMovieBuilder);

        Movie newMovie = newMovieBuilder.build();

        super.fileio.writeToFile(EnumDataFiles.Movie.toString(), newMovie.toCsvString());
        
        System.out.println("Movie created!");
    }

    public void updateMovieListing() {
        MovieBuilder updateMovieBuilder = new MovieBuilder();

        this.inputMovieDetails(updateMovieBuilder);

        Movie updateMovie = new Movie(updateMovieBuilder);

        super.fileio.updateKeyInFile(EnumDataFiles.Movie.toString(), updateMovie.toCsvString());
        
        System.out.println("Movie updated!");

    }

    public void deleteMovieListing() {

        // REMOVE scanner
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Movie ID: ");
        String deleteMovie = sc.nextLine();

        super.fileio.deleteKeyInFile(EnumDataFiles.Movie.toString(), deleteMovie);
        System.out.println("Movie deleted!");
    }

    public void createCinemaShowtime() {
        ShowtimeBuilder newCinemaShowtime = new ShowtimeBuilder();

        this.inputShowtime(newCinemaShowtime);

        showtime newShowtime = new showtime(newCinemaShowtime);

        super.fileio.writeToFile(EnumDataFiles.Showtime.toString(), newShowtime.toCsvString());
        
        System.out.println("Movie created!");
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