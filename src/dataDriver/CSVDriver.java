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

public abstract class CSVDriver{

    protected FileIO fileio = new FileIO();


    private ArrayList<Movie> getMovies(){
        ArrayList<Movie> allMovies = new ArrayList<>();
        try {
            this.fileio.readFromFile(EnumDataFiles.Movie.toString()).forEach(line->{
                allMovies.add(new MovieBuilder(line).build());
            });
        } catch (Exception e) {}

        return allMovies;
    }
    
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

    
    public void listTopMoviesBySales(){

        InsertSortMovies sorter = new InsertSortMovies(this.getMovies());
        ArrayList<Movie> movieArr = sorter.sortBySales();

        for(int i=0; i<Math.min(movieArr.size(), 5); i++){
            System.out.println(movieArr.get(i).toString());
        }

    }

    public void listTopMoviesByRating(){
        InsertSortMovies sorter = new InsertSortMovies(this.getMovies());
        ArrayList<Movie> movieArr = sorter.sortByRating();

        for(int i=0; i<Math.min(movieArr.size(), 5); i++){
            System.out.println(movieArr.get(i).toString());
        }
    }


    public void listTop5Movies(){
        ArrayList<Movie> movieArr = this.getSortedMovies();

        for(int i=0; i<Math.min(5, movieArr.size()); i++){
            System.out.println(movieArr.get(i).toString());
        }
    }



    public void listAllMovies(){

        ArrayList<Movie> moviesArr = this.getSortedMovies();

        for(Movie movie : moviesArr){
            System.out.println(movie.toString());
        }
        
    }

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


    public void listAllShowtimes(){
        this.fileio.readFromFile(EnumDataFiles.Showtime.toString()).forEach(line->{
            try {
                System.out.println(new ShowtimeBuilder(line).build().toString());
            } catch (Exception e) {
                // pass
            }
        });
    }

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

    public boolean listShowtimeFromRegex(String rgx){
        ArrayList<String> found = this.fileio.regexMatch(EnumDataFiles.Showtime.toString(), rgx);
        if(found.size()>0){
            found.forEach(line->{
                ShowtimeBuilder showtiming = new ShowtimeBuilder(line);
                showtime buildtime = new showtime(showtiming);
                buildtime.printShowTime();
            });
            return true;
        }
        else{
            System.out.println("No showtime found");
            return false;
        }
    }

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

    public String findCinema(String rgx){
        ArrayList<String> found = this.fileio.regexMatch(EnumDataFiles.Cinema.toString(),rgx);
        String line = found.get(0);
        return line;
    }

    public String findmovie(String rgx){
        ArrayList<String> found = this.fileio.regexMatch(EnumDataFiles.Movie.toString(),rgx);
        String line = found.get(0);
        MovieBuilder movieBuilding = new MovieBuilder(line);
        Movie buildmovie = new Movie(movieBuilding);

        return buildmovie.getMovieTitle();
    }

    public String findmovieType(String rgx){
        ArrayList<String> found = this.fileio.regexMatch(EnumDataFiles.Movie.toString(),rgx);
        String line = found.get(0);
        MovieBuilder movieBuilding = new MovieBuilder(line);
        Movie buildmovie = new Movie(movieBuilding);

        return buildmovie.getMovieType().toString();

    }

    public void updateBookedSeats(String ID,String rgx) {
        
        this.fileio.updateKeyInFile(ID, rgx);
    }


    public void createBookingHistory(bookingHistoryBuilder historyBuilder){
        //create a new bookingHistory object
        bookingHistory newbook = new bookingHistory(historyBuilder);

        //Write input to csv file
        this.fileio.writeToFile(EnumDataFiles.bookingHistory.toString(),newbook.toCsvString());

        System.out.println("Booking created!");

    }


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

    public boolean isMovieSortByRating(){
        Properties props = this.fileio.getProps();
        Boolean val = Boolean.parseBoolean(props.getProperty("RANK_BY_RATING"));
        return val.booleanValue();
    }

}
