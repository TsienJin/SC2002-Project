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
import ShowTime.updateShowtimeParser;
import Users.Staff;
import Users.User;
import UsrInput.UsrInput;

public class StaffCSVDriver extends CSVDriver implements InterfaceCsvDelimiter {
    private UsrInput usrInput = new UsrInput();
    private EnumMovieParser movieEnum = new EnumMovieParser();
    private updateShowtimeParser updateShowtimeMenu = new updateShowtimeParser();

    //For createMovieListing() function
    public MovieBuilder inputMovieDetails(MovieBuilder inputMovie){

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

        return inputMovie;
    }

    //For createCinemaShowtime() function
    public void inputShowtime(ShowtimeBuilder inputShowtime){
        UsrInput usrInput = new UsrInput();
        inputShowtime.setShowtimeID(usrInput.getUsrString("Enter Showtime ID: "));
        inputShowtime.setMovie(usrInput.getUsrString("Enter Movie ID: "));
        inputShowtime.setCinema(usrInput.getUsrString("Enter Cinema Code: "));
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

    public String getStaffIdFromUsrname(String usrName){
        try {
            String staffDetails = super.fileio.findMatchFromFile(EnumDataFiles.StaffUser.toString(), usrName);
            return staffDetails.split(mainDelimiter)[1];
        } catch (Exception e) {
            return new String("");
        }
    }

    public boolean updateStaffAccount(Staff usr){
        try {
            this.fileio.updateKeyInFile(EnumDataFiles.StaffUser.toString(), usr.toCsvString());
            return true;
        } catch (Exception e) {
            System.out.println("Error updating!");
            return false;
        }
    }

    public boolean createStaffAccount(Staff usr){
        try {
            this.fileio.writeToFile(EnumDataFiles.StaffUser.toString(), usr.toCsvString());
            return true;
        } catch (Exception e) {
            System.out.println("Error adding user!");
            return false;
        }
    }

    public void createMovieListing() {
        //Create new movie object
        Movie newMovie = this.inputMovieDetails(new MovieBuilder()).build();

        //Write input to csv file
        super.fileio.writeToFile(EnumDataFiles.Movie.toString(), newMovie.toCsvString());
        
        System.out.println("Movie created!");
    }

    public void updateMovieListing() {
        String movieID = this.usrInput.getUsrString("Enter ID of Movie to update: ");
        // fetch showtime object
        ShowtimeBuilder updateMovie = new ShowtimeBuilder().fromShowtimeID(movieID);
        // print menu
        System.out.println(updateMovie.build().toString());
        // usr input to update which portion of 
        updateMovieMenu.inputUpdateType(updateMovie);
        // update in csv file
        super.fileio.updateKeyInFile(EnumDataFiles.Showtime.toString(), updateMovie.build().toCsvString());
        System.out.println("Showtime updated!");
    }

    public void deleteMovieListing() {

        String movieID = usrInput.getUsrString("Enter Movie ID to delete: ");
        if(super.fileio.deleteKeyInFile(EnumDataFiles.Movie.toString(), movieID)){
            System.out.println(String.format("Movie with ID %S has been deleted!", movieID));
        } else {
            System.out.println(String.format("Movie with ID %s cannot be found!", movieID));
        }
    }

    public void createCinemaShowtime() {
        ShowtimeBuilder showtimeBuilder = new ShowtimeBuilder();

        this.inputShowtime(showtimeBuilder);

        showtime newShowtime = showtimeBuilder.build();

        super.fileio.writeToFile(EnumDataFiles.Showtime.toString(), newShowtime.toCsvString());
        
        System.out.println("Showtime created!");
    }

    public void updateCinemaShowtime() {
        String showtimeID = this.usrInput.getUsrString("Enter ID of Showtime to update: ");
        // fetch showtime object
        ShowtimeBuilder updateShowtime = new ShowtimeBuilder().fromShowtimeID(showtimeID);
        // print menu
        System.out.println(updateShowtime.build().toString());
        // usr input to update which portion of 
        updateShowtimeMenu.inputUpdateType(updateShowtime);
        // update in csv file
        super.fileio.updateKeyInFile(EnumDataFiles.Showtime.toString(), updateShowtime.build().toCsvString());
        System.out.println("Movie updated!");
    }

    public void deleteCinemaShowtime() {

        String showtimeID = usrInput.getUsrString("Enter Showtime ID to delete: ");
        
        if(super.fileio.deleteKeyInFile(EnumDataFiles.Showtime.toString(), showtimeID)){
            System.out.println(String.format("Showtime with ID %S has been deleted!", showtimeID));
        } else {
            System.out.println(String.format("Showtime with ID %s cannot be found!", showtimeID));
        }
    }
}