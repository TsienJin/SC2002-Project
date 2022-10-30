package ShowTime;

import java.text.SimpleDateFormat;
import java.util.*;
import Movie.Movie;
import MovieTheatres.*;

import dataDriver.InterfaceCsvDelimiter;
import dataDriver.InterfaceToCsvStringHelper;

public class showtime implements InterfaceToCsvStringHelper, InterfaceCsvDelimiter{

    //Attributes of showtime
    private Movie movie;
    private Cinema cinema;
    private String time_date; //In yyyyMMDDhhmm format

    //Constructor
    //Preceeded
    // public showtime(Movie movie,Cinema cinema, String time_date)
    // {
    //     this.movie = movie;
    //     this.cinema = cinema;
    //     this.time_date = time_date;
    // }

    public showtime(ShowtimeBuilder builder)
    {
        this.movie = builder.movie;
        this.cinema = builder.cinema;
        this.time_date = builder.time_date;
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

    public String toCsvString() {

        // Delimiters are from the toCsvStringHelper interface

        ArrayList<String> arrCSV = new ArrayList<>();

        arrCSV.add(this.movie);
        arrCSV.add(this.cinema);
        arrCSV.add(this.time_date);

        return String.join(mainDelimiter, arrCSV);
    }

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
