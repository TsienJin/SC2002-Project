package ShowTime;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import Movie.Movie;
import MovieTheatres.*;
import OutputPrinter.InterfaceOutputPrinterFormatter;
import OutputPrinter.OutputPrinterFormatter;
import dataDriver.InterfaceCsvDelimiter;
import dataDriver.InterfaceToCsvStringHelper;

public class showtime implements InterfaceToCsvStringHelper, InterfaceCsvDelimiter, InterfaceOutputPrinterFormatter{

    //Attributes of showtime
    private String showtimeID;
    private Movie movie;
    private Cinema cinema;
    private String time_date; //In yyyyMMDDhhmm format

    private OutputPrinterFormatter printer = new OutputPrinterFormatter();


    public showtime(ShowtimeBuilder builder)
    {
        this.showtimeID = builder.showtimeID;
        this.movie = builder.movie;
        this.cinema = builder.cinema;
        this.time_date = builder.time_date;
    }


    public String toString(){
        return(""+
            printer.Header(this.showtimeID+tab+this.movie.getMovieTitle()) + nLine +
            printer.Subheader("Cinema Type: ") + this.cinema.getCinemaCode() + nLine +
            printer.Subheader("Showtime: ") + this.getFormattedDate() + nLine
        );
    }


    public String getShowtimeID(){
        return this.showtimeID;
    }

    public Movie getMovie(){
        return this.movie;
    }

    public Cinema getCinema(){
        return this.cinema;
    }

    public String getTime_date(){
        return time_date;
    }

    public String getFormattedDate(){
        // 0123456789
        // yyyyMMDDhhmm format
        // return dateTime;

        return(this.time_date.substring(6, 8)+" "+this.time_date.substring(4, 6)+" "+this.time_date.substring(0, 4) + " " +
            this.time_date.substring(8, 10)+":"+this.time_date.substring(10, 12)
        );
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
        
        arrCSV.add(this.showtimeID);
        arrCSV.add(this.movie.getID());
        arrCSV.add(this.cinema.getCinemaCode());
        arrCSV.add(this.time_date);

        return String.join(mainDelimiter, arrCSV);
    }

    public boolean isUpcoming(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddkkmm");
        String curDate = formatter.format(date);

        return(curDate.compareTo(this.time_date) < 0);
    }

    public void printShowTime(){
       if(this.isUpcoming()){

            //Print ShowTime ID
            System.out.println("Show Time ID: " + this.showtimeID);
           
           //Print Movie ID
           System.out.println("Movie ID: " + this.movie.getID()); //Current date is smaller

           //Print Cinema Type
           //Get the first character of the ID 
           char firstchar = this.movie.getID().charAt(0);
           //System.out.println("Mov: " + this.cinema.getCinemaclass());
           //System.out.println("Class of cinema: " + firstchar);
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
