package dataDriver;

import java.util.ArrayList;
import java.util.Properties;

import Bookings.bookingHistory;
import Bookings.bookingHistoryBuilder;
import Movie.Movie;
import Movie.MovieBuilder;
import ShowTime.ShowtimeBuilder;
import ShowTime.showtime;

public abstract class CSVDriver{

    protected FileIO fileio = new FileIO();

    
    public void listTopMoviesBySales(){
    }

    public void listTopMoviesByRating(){

    }

    public void listAllMovies(){

        this.fileio.readFromFile(EnumDataFiles.Movie.toString()).forEach(movie -> {
            System.out.println(new MovieBuilder(movie).build().toString());
        });
        
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
