package ShowTime;

import java.text.SimpleDateFormat;
import java.util.*;
import Movie.Movie;
import MovieTheatres.*;
import OutputPrinter.InterfaceOutputPrinterFormatter;
import OutputPrinter.OutputPrinterFormatter;
import dataDriver.InterfaceCsvDelimiter;
import dataDriver.InterfaceToCsvStringHelper;

public class showtime implements InterfaceToCsvStringHelper, InterfaceCsvDelimiter, InterfaceOutputPrinterFormatter{

    //Attributes of showtime
<<<<<<< Updated upstream
    private Movie movie;
    private Cinema cinema;
=======
    private String showtimeID;
    //private Movie movie;
    //private Cinema cinema;
    private String movieId;
    private String cinemaId;
>>>>>>> Stashed changes
    private String time_date; //In yyyyMMDDhhmm format

    private OutputPrinterFormatter formatter = new OutputPrinterFormatter();

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
<<<<<<< Updated upstream
        this.movie = builder.movie;
        this.cinema = builder.cinema;
        this.time_date = builder.time_date;
    }

    public Movie getMovie(){
        return movie;
=======
        this.showtimeID = builder.showtimeID;
        this.movieId = builder.movieId;
        this.cinemaId = builder.cinemaId;
        this.time_date = builder.time_date;
    }

    public String getShowtimeID(){
        return showtimeID;
    }

    public String getMovie(){
        return movieId;
>>>>>>> Stashed changes
    }

    public String getCinema(){
        return cinemaId;
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

<<<<<<< Updated upstream
        arrCSV.add(this.movie);
        arrCSV.add(this.cinema);
=======
        arrCSV.add(this.showtimeID);
        //arrCSV.add(this.movie.getID());
        arrCSV.add(this.movieId);
        //arrCSV.add(this.cinema.getId());
        arrCSV.add(this.cinemaId);
>>>>>>> Stashed changes
        arrCSV.add(this.time_date);

        return String.join(mainDelimiter, arrCSV);
    }

    public void printShowTime(){
        //Get the current instance of time and date
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddkkmm");
        String curDate = formatter.format(date);

       if(curDate.compareTo(time_date) < 0){

            //Print ShowTime ID
            System.out.println("Show Time ID: " + this.showtimeID);
           
           //Print Movie ID
           System.out.println("Movie ID: " + this.movieId); //Current date is smaller

           //Print Cinema Type
           //Get the first character of the ID 
           char firstchar = this.cinemaId.charAt(0);
           if(Character.compare(firstchar,'R')==0){
                System.out.println("Cinema Class: Regular");
           }
           else if(Character.compare(firstchar,'F')==0){
                System.out.println("Cinema Class : First");
           }
           else if(Character.compare(firstchar,'G')==0){
                System.out.println("Cinema Class : Gold");
           }

           //Print date
           String year = time_date.substring(0,4);
           String month = time_date.substring(4,6);
           String day = time_date.substring(6,8);
           System.out.println("Date: " + day + "-" + month + "-" + year);

           //Print time
           String hour = time_date.substring(8,10);
           String mins = time_date.substring(10);
           System.out.println("Time: " + hour + " : " + mins);
           System.out.print("\n");


        }

    }


}
