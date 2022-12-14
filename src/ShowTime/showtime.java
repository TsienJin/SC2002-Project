package ShowTime;

import java.util.Date;
import java.text.SimpleDateFormat;
// import java.io.DataOutput;
// import java.text.ParseException;
// import java.time.DayOfWeek;
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
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
    private String bookedSeat;

    private OutputPrinterFormatter printer = new OutputPrinterFormatter();

    /** 
     * Takes in ShowtimeBuilder object
     * Constructs the Showtime object from ShowtimeBuilder object
     * @param builder ShowtimeBuilder Object
     */
    public showtime(ShowtimeBuilder builder)
    {
        this.showtimeID = builder.showtimeID;
        this.movie = builder.movie;
        this.cinema = builder.cinema;
        this.time_date = builder.time_date;
        this.bookedSeat = builder.bookedSeat;
    }

    /** 
     * Returns a formatted string of attributes for Showtime object
     * @return Formatted string of attributes
     */
    public String toString(){
        return(""+
            printer.Header(this.showtimeID+tab+this.movie.getMovieTitle()) + nLine +
            printer.Subheader("Cinema Type: ") + this.cinema.getCinemaCode() + nLine +
            printer.Subheader("Date: ") + this.getmovieDate() + nLine +
            printer.Subheader("Day: ") + this.getmovieDay() + nLine +
            printer.Subheader("Time: ") + this.getmovieTime() + nLine
        );
    }

    /** 
     * Returns a constructed string of attributes for Showtime object in the form of csv line
     * @return Constructed string of attributes
     */
    public String toCsvString() {

        // Delimiters are from the toCsvStringHelper interface

        ArrayList<String> arrCSV = new ArrayList<>();
        
        arrCSV.add(this.showtimeID);
        arrCSV.add(this.movie.getID());
        arrCSV.add(this.cinema.getCinemaCode());
        arrCSV.add(this.bookedSeat);
        arrCSV.add(this.time_date);

        return String.join(mainDelimiter, arrCSV);
    }
    
    /** 
     * Returns attribute ID of Showtime object
     * @return ID attribute
     */
    public String getShowtimeID(){
        return this.showtimeID;
    }

    /** 
     * Returns attribute Movie object of Showtime object
     * @return Movie object attribute
     */
    public Movie getMovie(){
        return this.movie;
    }
    
    /** 
     * Returns attribute Cinema object of Showtime object
     * @return Cinema object attribute
     */
    public Cinema getCinema(){
        return this.cinema;
    }

    /** 
     * Returns attribute time_date of Showtime object
     * @return time_date attribute
     */
    public String getTime_date(){
        return this.time_date;
    }

    /** 
     * Returns attribute bookedSeat of Showtime object
     * @return bookedSeat attribute
     */
    public String getBookedSeat(){
        return this.bookedSeat;
    }

    /** 
     * Returns time_date attribute in the form of
     * "dd/MM/yyyy" of Showtime object
     * @return time_date attribute in formatted form (Date)
     */
    public String getmovieDate(){
        String stringToDate=this.time_date;
        try{
            Date date1=new SimpleDateFormat("yyyyMMddHHmm").parse(stringToDate);  
            SimpleDateFormat findDate = new SimpleDateFormat("dd/MM/yyyy");
            String date = findDate.format(date1);
            return date;
        }
        catch (java.text.ParseException e) {
            // e.printStackTrace();
        }
        return null;
    }

    /** 
     * Returns time_date attribue in the form of
     * "HH:mm" of Showtime object
     * @return time_date attribute in formatted form (Time)
     */
    public String getmovieTime(){
        String stringToDate=this.time_date;
        try{
            Date date1=new SimpleDateFormat("yyyyMMddHHmm").parse(stringToDate);  
            SimpleDateFormat findTime = new SimpleDateFormat("HH:mm");
            String time = findTime.format(date1);
            return time;
        }
        catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /** 
     * Returns time_date attribue in the form of
     * "EEEE" of Showtime object
     * @return time_date attribute in formatted form (Day)
     */
    public String getmovieDay(){
        String stringToDate=this.time_date;
        try{
            Date date1=new SimpleDateFormat("yyyyMMddHHmm").parse(stringToDate);  
            SimpleDateFormat findDayOfWeek = new SimpleDateFormat("EEEE");
            String dayOfWeek = findDayOfWeek.format(date1);
            return dayOfWeek;
        }
        catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /** 
     * Sets bookedSeat attribute of Showtime object
     * @param bookedSeat row and column of selected seat
     */
    public void setBookedSeat(String bookedSeat){
        this.bookedSeat = bookedSeat;
    }

/* 
    public String getFormattedDate(){
        // 0123456789
        // yyyyMMDDhhmm format
        // return dateTime;

        return(this.time_date.substring(6, 8)+" "+this.time_date.substring(4, 6)+" "+this.time_date.substring(0, 4) + " " +
            this.time_date.substring(8, 10)+":"+this.time_date.substring(10, 12)
        );
    }
*/
    /*public String format_date_time(){
        String year = time_date.substring(0,4);
        String month = time_date.substring(4,6);
        String day = time_date.substring(6,8);
        return day + "-" + month + "-" + year;
    }*/

    /** 
     * Checks time_date attribute of Showtime object
     * compare with today's date to see whether Showtime is in the future
     * Returns true if Showtime is in the future, false if showtime has passed
     * @return true or false
     */
    public boolean isUpcoming(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddkkmm");
        String curDate = formatter.format(date);

        return(curDate.compareTo(this.time_date) < 0);
    }

/* 
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

    }*/


}
