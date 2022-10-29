package ShowTime;

import java.util.Date;
import Movie.Movie;
import MovieTheatres.*;


public class showtime {

    //Attributes of showtime
    private Movie movie;
    private Cinema cinema;
    private String timeOfMovie;

    private String dateOfMovie;

    //Constructor
    public showtime(Movie movie,Cinema cinema, String timeOfMovie)
    {
        this.movie = movie;
        this.cinema = cinema;
        this.timeOfMovie = timeOfMovie;
    }

    public Movie getMovie(){
        return movie;
    }

    public Cinema getCinema(){
        return cinema;
    }

    public String getTimeOfMovie(){
        return timeOfMovie;
    }

    public String getDateOfMovie(){
        return dateOfMovie;
    }



}
