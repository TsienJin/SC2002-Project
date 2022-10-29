package ShowTime;

import java.text.SimpleDateFormat;
import java.util.*;
import Movie.Movie;
import MovieTheatres.*;


public class showtime {

    //Attributes of showtime
    private Movie movie;
    private Cinema cinema;
    private String time_date; //In yyyyMMDDhhmm format

    //Constructor
    public showtime(Movie movie,Cinema cinema, String time_date)
    {
        this.movie = movie;
        this.cinema = cinema;
        this.time_date = time_date;
    }

    public Movie getMovie(){
        return movie;
    }

    public Cinema getCinema(){
        return cinema;
    }

    public String getTime_date(){
        return time_date;
    }

    /*public String format_date_time(){
        String year = time_date.substring(0,4);
        String month = time_date.substring(4,6);
        String day = time_date.substring(6,8);
        return day + "-" + month + "-" + year;
    }*/



    public void printShowTime(){
        //Get the current instance of time and date
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddkkmm");
        String curDate = formatter.format(date);

       if(curDate.compareTo(time_date) < 0){
           System.out.println("Print showtime"); //Current date is smaller

           //Print date
           String year = time_date.substring(0,4);
           String month = time_date.substring(4,6);
           String day = time_date.substring(6,8);
           System.out.println("Date: " + day + "-" + month + "-" + year);

           //Print time
           String hour = time_date.substring(8,10);
           String mins = time_date.substring(10);
           System.out.println("Time: " + hour + " : " + mins);

        }

    }


}
