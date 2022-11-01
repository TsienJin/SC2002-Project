package dataDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Movie.EnumMovieParser;
import Movie.EnumMovieType;
import Movie.EnumShowingStatus;
import Movie.Movie;
import Movie.MovieBuilder;
import MovieTheatres.CinemaBuilder;
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



        inputShowtime.setShowtimeID(usrInput.getUsrString("Enter Showtime ID: "));

        MovieBuilder showtimeMovie = new MovieBuilder();
        showtimeMovie.fromMovieID(usrInput.getUsrString("Enter Movie ID: "));
        inputShowtime.setMovie(showtimeMovie.build());

        CinemaBuilder showtimeCinema = new CinemaBuilder();
        showtimeCinema.fromCinemaID(usrInput.getUsrString("Enter Cinema ID: "));
        inputShowtime.setCinema(showtimeCinema.build());


        inputShowtime.setTimeDate(usrInput.getUsrString("Enter Time Date: "));
        
    }

    public boolean authenticate(String usrName, String usrPwd) {

        try {
            String staffDetails = super.fileio.findMatchFromFile(EnumDataFiles.StaffUser.toString(), usrName);
            if(staffDetails.length()==0){
                return false;
            } else {
                String[] staffArray = staffDetails.split(mainDelimiter);
                String csvUsername = staffArray[0];
                String csvPassword = staffArray[2];
    
                return (usrName.equals(csvUsername) && usrPwd.equals(csvPassword));
            }
        } catch (Exception e) {
            System.out.println("Username not found!");
            return false;
        }        
    }

    public void createMovieListing() {
        //Create new MovieBuilder object
        MovieBuilder newMovieBuilder = new MovieBuilder();

        this.inputMovieDetails(newMovieBuilder);

        Movie newMovie = newMovieBuilder.build();

        //Write input to csv file
        super.fileio.writeToFile(EnumDataFiles.Movie.toString(), newMovie.toCsvString());
        
        System.out.println("Movie created!");
    }

    public void updateMovieListing() {
        //Create new MovieBuilder object
        MovieBuilder updateMovieBuilder = new MovieBuilder();

        this.inputMovieDetails(updateMovieBuilder);

        //Create Movie object based on input given
        Movie updateMovie = new Movie(updateMovieBuilder);

        //Search csv for ID, then update information
        super.fileio.updateKeyInFile(EnumDataFiles.Movie.toString(), updateMovie.toCsvString());
        
        System.out.println("Movie updated!");

    }

    public void deleteMovieListing() {

        // REMOVE scanner
        String movieID = usrInput.getUsrString("Enter Movie ID to delete: ");
        
        if(super.fileio.deleteKeyInFile(EnumDataFiles.Movie.toString(), movieID)){
            System.out.println(String.format("Movie with ID %S has been deleted!", movieID));
        } else {
            System.out.println(String.format("Movie with ID %s cannot be found!", movieID));
        }
    }

    public void createCinemaShowtime() {
        ShowtimeBuilder newCinemaShowtime = new ShowtimeBuilder();

        this.inputShowtime(newCinemaShowtime);

        showtime newShowtime = new showtime(newCinemaShowtime);

        super.fileio.writeToFile(EnumDataFiles.Showtime.toString(), newShowtime.toCsvString());
        
        System.out.println("Showtime created!");
    }

    public void updateCinemaShowtime() {
        ShowtimeBuilder updateCinemaShowtime = new ShowtimeBuilder();

        this.inputShowtime(updateCinemaShowtime);

        showtime updateShowtime = new showtime(updateCinemaShowtime);

        super.fileio.updateKeyInFile(EnumDataFiles.Showtime.toString(), updateShowtime.toCsvString());
        
        System.out.println("Showtime updated!");
    }

    public void deleteCinemaShowtime() {
        // REMOVE scanner
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Showtime ID: ");
        String deleteShowtime = sc.nextLine();

        //Search csv for ID, then delete line
        super.fileio.deleteKeyInFile(EnumDataFiles.Showtime.toString(), deleteShowtime);
        System.out.println("Showtime deleted!");
    }
}