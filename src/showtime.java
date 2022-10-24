import Movie.Movie;
import MovieTheatres.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class showtime {

    public Movie movie;
    public Cinema cinema;
    public LocalDateTime myDatetime;

    //constructors
    public showtime(Movie movie,Cinema cinema){
        this.movie = movie;
        this.cinema = cinema;
        this.myDatetime = LocalDateTime.now();
    }

    public String convertTime(LocalDateTime myDatetime) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyyMMddhhmm");
        String formattedDate = myDatetime.format(myFormatObj);
        return formattedDate;
    }



}
