package dataDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

import Movie.EnumMovieParser;
import Movie.EnumMovieType;
import Movie.EnumShowingStatus;
import Movie.Movie;
import Movie.MovieBuilder;
import Movie.updateMovieParser;
import ShowTime.ShowtimeBuilder;
import ShowTime.showtime;
import ShowTime.updateShowtimeParser;
import Users.Staff;
import UsrInput.UsrInput;

public class StaffCSVDriver extends CSVDriver implements InterfaceCsvDelimiter {
    private UsrInput usrInput = new UsrInput();
    private EnumMovieParser movieEnum = new EnumMovieParser();
    private updateShowtimeParser updateShowtimeMenu = new updateShowtimeParser();
    private updateMovieParser updateMovieMenu = new updateMovieParser();

    
    /** 
     * Takes in a newly created MovieBuilder object and returns the object with its attributes set.
     * User will be prompted to enter values.
     * 
     * @param inputMovie new MovieBuilder Object
     * @return MovieBuilder Object with attributes set.
     */
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

    
    /** 
     * Takes in a newly created ShowtimeBuilder object and returns the object with its attributes set.
     * User will be prompted to enter values.
     * 
     * @param inputShowtime new ShowtimeBuilder Object
     * @return ShowtimeBuilder Object with attributes set.
     */
    //For createCinemaShowtime() function
    public void inputShowtime(ShowtimeBuilder inputShowtime){
        UsrInput usrInput = new UsrInput();
        String showTime = usrInput.getUsrString("Enter Showtime ID: ");
        while(this.findShowtimefromregex(showTime) == true){
            System.out.println("Showtime ID is already taken");
            showTime = usrInput.getUsrString("Please enter Showtime ID again: ");
        }
        inputShowtime.setShowtimeID(showTime);
        inputShowtime.setMovie(usrInput.getUsrString("Enter Movie ID: "));
        String cinemaCode = usrInput.getUsrString("Enter Cinema Code: ");
        inputShowtime.setCinema(cinemaCode);
        inputShowtime.setTimeDate(usrInput.getUsrString("Enter Time Date: "));
    }

    
    
    /** 
     * Takes in a string, searches Showtime to check whether the string taken in exist in the showtime.
     * If string does not exist, it will return true, else it returns false
     * @param rgx string to check if it exist in Showtime
     * @return true or false
     */
    //Find if showtime is already avaiable
    public boolean findShowtimefromregex(String rgx){
        ArrayList<String> found = this.fileio.regexMatch(EnumDataFiles.Showtime.toString(), rgx);
        if(found.size()>0){
            return true;
        }
        else{
            return false;
        }
    } 



    
    /** 
     * Takes in Username and Password, uses Username to search for the specific staff, and compares the password taken in against StaffDetails.
     * If input matches StaffDetails, return true, else return false.
     * @param usrName Usermane entered by user
     * @param usrPwd Password entered by user
     * @return true or false
     */
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

    
    /** 
     * Takes in a username, searches StaffUser to check whether the username taken in exist in the StaffUser file.
     * If name exist, returns the StaffID, else reutrn empty string
     * @param usrName Username entered by user
     * @return Returns StaffID or empty string
     */
    public String getStaffIdFromUsrname(String usrName){
        try {
            String staffDetails = super.fileio.findMatchFromFile(EnumDataFiles.StaffUser.toString(), usrName);
            return staffDetails.split(mainDelimiter)[1];
        } catch (Exception e) {
            return new String("");
        }
    }

    
    /** 
     * Takes in a Staff object with updated attributes and updates the StaffDetails file with the attributes taken in.
     * If file is updated, return true. Else, return false.
     * @param usr Staff object with updated attributes
     * @return true or false
     */
    public boolean updateStaffAccount(Staff usr){
        try {
            this.fileio.updateKeyInFile(EnumDataFiles.StaffUser.toString(), usr.toCsvString());
            return true;
        } catch (Exception e) {
            System.out.println("Error updating!");
            return false;
        }
    }

    
    /** 
     * Takes in a new Staff object with attributes filled in by user, and inserts the new Staff into StaffDetails file.
     * If file is updated, return true. Else, return false.
     * @param usr new Staff object with attributes filled in by user
     * @return true or false
     */
    public boolean createStaffAccount(Staff usr){
        try {
            this.fileio.writeToFile(EnumDataFiles.StaffUser.toString(), usr.toCsvString());
            return true;
        } catch (Exception e) {
            System.out.println("Error adding user!");
            return false;
        }
    }

    /** 
     * Creates a new MovieBuilder object, pass it into `inputMovieDetails()` function, 
     * builds into a Movie object via `build()`, and inserts the new Movie into Movie file.
     */    
    public void createMovieListing() {
        //Create new movie object
        Movie newMovie = this.inputMovieDetails(new MovieBuilder()).build();

        //Write input to csv file
        super.fileio.writeToFile(EnumDataFiles.Movie.toString(), newMovie.toCsvString());
        
        System.out.println("Movie created!");
    }

    /** 
     * Ask for Movie ID from user, then creates a new MobieBuilder object.
     * Dipslays Movie object built from MovieBuilder object.
     * Calls `inputUpdateType() function which returns MovieBuilder object with updated attributes
     * Takes in the MovieBuilder object with updated attributes and updates the Movie file with the updated attributes
     */    
    public void updateMovieListing() {
        String movieID = this.usrInput.getUsrString("Enter ID of Movie to update: ");
        // fetch showtime object
        MovieBuilder updateMovie = new MovieBuilder().fromMovieID(movieID);
        // print menu
        System.out.println(updateMovie.build().toString());
        // usr input to update which portion of 
        updateMovieMenu.inputUpdateType(updateMovie);
        // update in csv file
        super.fileio.updateKeyInFile(EnumDataFiles.Movie.toString(), updateMovie.build().toCsvString());
        System.out.println("Movie updated!");
    }

    /** 
     * Ask for Movie ID from user, then checks whether Movie containing Movie ID is being deleted
     */    
    public void deleteMovieListing() {

        String movieID = usrInput.getUsrString("Enter Movie ID to delete: ");
        if(super.fileio.deleteKeyInFile(EnumDataFiles.Movie.toString(), movieID)){
            System.out.println(String.format("Movie with ID %S has been deleted!", movieID));
        } else {
            System.out.println(String.format("Movie with ID %s cannot be found!", movieID));
        }
    }

    /** 
     * Creates a new ShowtimeBuilder object, pass it into `inputShowtime()` function, 
     * builds into a Showtime object via `build()`, and inserts the new Showtime into Showtime file.
     */    
    public void createCinemaShowtime() {
        ShowtimeBuilder showtimeBuilder = new ShowtimeBuilder();

        this.inputShowtime(showtimeBuilder);

        showtime newShowtime = showtimeBuilder.build();
        // newShowtime.getCinema().setShowtimeID(newShowtime.getCinema().getShowtimeID() + " " + newShowtime.getShowtimeID());
        // super.fileio.updateKeyInFile(EnumDataFiles.Cinema.toString(), newShowtime.getCinema().toCsvString());
        super.fileio.writeToFile(EnumDataFiles.Showtime.toString(), newShowtime.toCsvString());
        
        System.out.println("Showtime created!");
    }

    /** 
     * Ask for Showtime ID from user, then creates a new ShowtimeBuilder object.
     * Dipslays Showtime object built from ShowtimeBuilder object.
     * Calls `inputUpdateType() function which returns ShowtimeBuilder object with updated attributes
     * Takes in the ShowtimeBuilder object with updated attributes and updates the Showtime file with the updated attributes
     */    
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
        System.out.println("Showtime updated!");
    }

    /** 
     * Ask for Showtime ID from user, then checks whether Showtime containing Showtime ID is being deleted
     */    
    public void deleteCinemaShowtime() {

        String showtimeID = usrInput.getUsrString("Enter Showtime ID to delete: ");
        
        if(super.fileio.deleteKeyInFile(EnumDataFiles.Showtime.toString(), showtimeID)){
            System.out.println(String.format("Showtime with ID %S has been deleted!", showtimeID));
        } else {
            System.out.println(String.format("Showtime with ID %s cannot be found!", showtimeID));
        }
    }

    /** 
     * Creates a new Properties object by fetching attributes from Configuration File
     * Sets attribute `RANK_BY_RATING` to true
     * Passes updated Properties object to `setProps()`
     */
    public void sortMoviesByRating(){
        Properties props = this.fileio.getProps();
        props.setProperty("RANK_BY_RATING", "true");
        this.fileio.setProps(props);
    }

    /** 
     * Creates a new Properties object by fetching attributes from Configuration File
     * Sets attribute `RANK_BY_RATING` to false
     * Passes updated Properties object to `setProps()`
     */
    public void sortMoviesBySales(){
        Properties props = this.fileio.getProps();
        props.setProperty("RANK_BY_RATING", "false");
        this.fileio.setProps(props);
    }

    /** 
     * Creates a new Properties object by fetching attributes from Configuration File
     * Sets attribute `CUSTOMER_RESTRICTED_MV_SORT` to true
     * Passes updated Properties object to `setProps()`
     */
    public void restrictCustomerMovieSort(){
        Properties props = this.fileio.getProps();
        props.setProperty("CUSTOMER_RESTRICTED_MV_SORT", "true");
        this.fileio.setProps(props);
    }

    /** 
     * Creates a new Properties object by fetching attributes from Configuration File
     * Sets attribute `CUSTOMER_RESTRICTED_MV_SORT` to false
     * Passes updated Properties object to `setProps()`
     */
    public void unrestrictCustomerMovieSort(){
        Properties props = this.fileio.getProps();
        props.setProperty("CUSTOMER_RESTRICTED_MV_SORT", "false");
        this.fileio.setProps(props);
    }
}