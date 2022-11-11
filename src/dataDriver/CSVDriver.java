package dataDriver;

import java.util.ArrayList;
import java.util.Properties;

import Bookings.bookingHistory;
import Bookings.bookingHistoryBuilder;
import Movie.Movie;
import Movie.MovieBuilder;
import ShowTime.ShowtimeBuilder;
import ShowTime.showtime;
import Sorting.InsertSortMovies;


/** Abstract class that eases interaction between user objects and CRUD operations
 * 
 */
public abstract class CSVDriver{

    protected FileIO fileio = new FileIO();


    
    /** Get an array of all movies in the system
     * @return ArrayList<Movie>
     */
    private ArrayList<Movie> getMovies(){
        ArrayList<Movie> allMovies = new ArrayList<>();
        try {
            this.fileio.readFromFile(EnumDataFiles.Movie.toString()).forEach(line->{
                allMovies.add(new MovieBuilder(line).build());
            });
        } catch (Exception e) {}

        return allMovies;
    }
    
    
    /** Get all movies in the system sorted according to the configuation
     * @return ArrayList<Movie>
     */
    private ArrayList<Movie> getSortedMovies(){
        InsertSortMovies sorter = new InsertSortMovies(this.getMovies());
        ArrayList<Movie> moviesArr = new ArrayList<>();


        if(this.isMovieSortByRating() && sorter.size()>0){
            moviesArr = sorter.sortByRating();
        } else if (!this.isMovieSortByRating() && sorter.size()>0){
            moviesArr = sorter.sortBySales();
        }

        return moviesArr;

    }

    /** Prints out movies according to number of ticket sales
     * 
     */
    public void listTopMoviesBySales(){

        InsertSortMovies sorter = new InsertSortMovies(this.getMovies());
        ArrayList<Movie> movieArr = sorter.sortBySales();

        for(int i=0; i<Math.min(movieArr.size(), 5); i++){
            System.out.println(movieArr.get(i).toString());
        }

    }


    /** Prints out movie according to rating
     * 
     */
    public void listTopMoviesByRating(){
        InsertSortMovies sorter = new InsertSortMovies(this.getMovies());
        ArrayList<Movie> movieArr = sorter.sortByRating();

        for(int i=0; i<Math.min(movieArr.size(), 5); i++){
            System.out.println(movieArr.get(i).toString());
        }
    }


    /** Prints top 5 movies according to system config
     * 
     */
    public void listTop5Movies(){
        ArrayList<Movie> movieArr = this.getSortedMovies();

        for(int i=0; i<Math.min(5, movieArr.size()); i++){
            System.out.println(movieArr.get(i).toString());
        }
    }

    /** Prints all movies
     * 
     */
    public void listAllMoviesforStaff(){
        ArrayList<Movie> moviesArr = this.getMovies();

        for(Movie movie : moviesArr){
            System.out.println(movie.toString());
        }
    }

    /** Prints all showing and upcoming movies
     * 
     */
    public void listAllMovies(){

        ArrayList<Movie> moviesArr = this.getMovies();

        for(Movie movie : moviesArr){
            if(!movie.getStatus().toString().equals("Not_Showing")){
                System.out.println(movie.toString());
            }
        }
        
    }

    public void listAllMovieforBooking(){
        ArrayList<Movie> moviesArr = this.getMovies();

        for(Movie movie : moviesArr){
            if(movie.getStatus().toString().equals("Preview") || movie.getStatus().toString().equals("Now_Showing")){
                System.out.println(movie.toString());
            }
        }
    }

    
    /** Searches for movies using Regex and prints all patches
     * @param rgx
     */
    public void listMovieFromRegex(String rgx){
        ArrayList<String> found = this.fileio.regexMatch(EnumDataFiles.Movie.toString(), rgx);
        if(found.size()>0){
            found.forEach(movie->{
                System.out.println(new MovieBuilder(movie).build().toString());
            });
        } else {
            System.out.println("No movies found!");
        }
    }

    public boolean checkMovieStatus(String rgx){
        ArrayList<String> found = this.fileio.regexMatch(EnumDataFiles.Movie.toString(),rgx);
        String line = found.get(0);
        MovieBuilder buildmovie = new MovieBuilder(line);
        Movie newMovie = new Movie(buildmovie);
        if(newMovie.getStatus().toString().equals("Preview") || newMovie.getStatus().toString().equals("Now_Showing")){
            return true;
        }
        return false;
    }


    /** Prints all showtimes
     * 
     */
    public void listAllShowtimes(){
        this.fileio.readFromFile(EnumDataFiles.Showtime.toString()).forEach(line->{
            try {
                System.out.println(new ShowtimeBuilder(line).build().toString());
            } catch (Exception e) {
                // pass
            }
        });
    }

    /** Prints all upcoming showtimes
     * 
     */
    public void listAllUpcomingShowtimes(){
        this.fileio.readFromFile(EnumDataFiles.Showtime.toString()).forEach(line->{
            try {
                showtime showtime = new ShowtimeBuilder(line).build();
                if(showtime.isUpcoming()){
                    System.out.println(showtime.toString());
                }
            } catch (Exception e) {
                // pass
            }
        });
    }

    
    /** Searches for Showtimes using regex and prints all matches
     * @param rgx
     * @return boolean
     */
    public boolean listShowtimeFromRegex(String rgx){
        ArrayList<String> found = this.fileio.regexMatch(EnumDataFiles.Showtime.toString(), rgx);
        if(found.size()>0){
            found.forEach(line->{
                System.out.println(new ShowtimeBuilder(line).build().toString());
            });
            return true;
        }
        else{
            System.out.println("No showtime found");
            return false;
        }
    }

    
    /** Prints all showtimes with a specified Movie ID
     * @param ID
     * @return boolean, if matches are found
     */
    public boolean listShowtimeFromMovieId(String ID){
        try{
            ArrayList<String> found = this.fileio.findAllMatchesFromFile(EnumDataFiles.Showtime.toString(), ID, 1);
            for(String str : found){
                System.out.println(new ShowtimeBuilder(str).build().toString());
            }
            return true;
        } catch (Exception e){
            return false; 
        }
    }

    
    /** Find Cinema ID by regex
     * @param rgx
     * @return String
     */
    public String findCinema(String rgx){
        ArrayList<String> found = this.fileio.regexMatch(EnumDataFiles.Cinema.toString(),rgx);
        String line = found.get(0);
        return line;
    }

    
    /** Find Showtime ID by regex
     * @param rgx
     * @return String
     */
    public String findShowtime(String rgx){
        ArrayList<String> found = this.fileio.regexMatch(EnumDataFiles.Showtime.toString(),rgx);
        String line = found.get(0);
        return line;
    }

    
    /** Find movie title from regex
     * @param rgx
     * @return String
     */
    public String findmovie(String rgx){
        ArrayList<String> found = this.fileio.regexMatch(EnumDataFiles.Movie.toString(),rgx);
        String line = found.get(0);
        MovieBuilder movieBuilding = new MovieBuilder(line);
        Movie buildmovie = new Movie(movieBuilding);

        return buildmovie.getMovieTitle();
    }

    
    /** Find movie type from regex
     * @param rgx
     * @return String
     */
    public String findmovieType(String rgx){
        ArrayList<String> found = this.fileio.regexMatch(EnumDataFiles.Movie.toString(),rgx);
        String line = found.get(0);
        MovieBuilder movieBuilding = new MovieBuilder(line);
        Movie buildmovie = new Movie(movieBuilding);

        return buildmovie.getMovieType().toString();

    }

    
    /** Update booked seat
     * @param ID
     * @param rgx
     */
    public void updateBookedSeats(String ID,String rgx) {
        
        this.fileio.updateKeyInFile(ID, rgx);
    }


    
    /** Creates booking history in CSV file
     * @param historyBuilder
     */
    public void createBookingHistory(bookingHistoryBuilder historyBuilder){
        //create a new bookingHistory object
        bookingHistory newbook = new bookingHistory(historyBuilder);

        //Write input to csv file
        this.fileio.writeToFile(EnumDataFiles.bookingHistory.toString(),newbook.toCsvString());

        System.out.println("Booking created!");

    }


    
    /** Prints all booking history according to regex
     * @param rgx
     */
    public void listHistory(String rgx){
        ArrayList<String> found = this.fileio.regexMatch(EnumDataFiles.bookingHistory.toString(), rgx);
        if(found.size()>0){
            found.forEach(history->{
                System.out.println(new bookingHistoryBuilder(history).build().toString());
            });
        } else {
            System.out.println("No booking history found!");
        }
    }

    
    /** Get system config on sorting order
     * @return boolean
     */
    public boolean isMovieSortByRating(){
        Properties props = this.fileio.getProps();
        Boolean val = Boolean.parseBoolean(props.getProperty("RANK_BY_RATING"));
        return val.booleanValue();
    }

    
    /** Get system config on customer sorting order
     * @return boolean
     */
    public boolean isCustomerRestricted(){
        Properties props = this.fileio.getProps();
        Boolean val = Boolean.parseBoolean(props.getProperty("CUSTOMER_RESTRICTED_MV_SORT"));
        return val.booleanValue();
    }

}
