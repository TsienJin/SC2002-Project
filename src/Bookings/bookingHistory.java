package Bookings;
import java.util.*;
import dataDriver.InterfaceCsvDelimiter;
import dataDriver.InterfaceToCsvStringHelper;
import OutputPrinter.InterfaceOutputPrinterFormatter;
import OutputPrinter.OutputPrinterFormatter;

public class bookingHistory implements InterfaceCsvDelimiter,InterfaceToCsvStringHelper,InterfaceOutputPrinterFormatter{
    private String TID;
    private String movieID;
    private String MobileNum;
    private String Email;
    private String movieName;
    private String totalPrice;

    private OutputPrinterFormatter formatter = new OutputPrinterFormatter();

    /**
     * Take in bookingHistoryBuilder object
     * Constructs the bookingHistory object from bookingHistoryBuilder object
     * @param builder bookingHistoryBuilder object
     */
    public bookingHistory(bookingHistoryBuilder builder){
        this.TID = builder.TID;
        this.movieID = builder.movieID;
        this.MobileNum = builder.MobileNum;
        this.Email = builder.Email;
        this.movieName = builder.movieName;
        this.totalPrice = builder.totalPrice;
    }

    /**
     * Returns a formatted string of attributes for Showtime object
     * @return Formatted string of attributes
     */
    public String toString(){
        return("" + formatter.Header(this.MobileNum + tab + this.Email) + nLine +
                    formatter.Subheader("Transaction ID: ") + this.TID + nLine +
                    formatter.Subheader("Movie ID: ") + this.movieID + nLine +
                    formatter.Subheader("Movie Name: ") + this.movieName + nLine +
                    formatter.Subheader("Total Price: ") + this.totalPrice + nLine +
                    formatter.Subheader("Transact Time: ") + this.getTransactTime() + nLine +
                    formatter.Subheader("Transact Date: ") + this.getTransactDate());
              
    }

    /**
     * Returns a constructed string of attributes for bookingHistory in the form of csv line
     * @return Constructed string of attributes
     */
    public String toCsvString(){
        ArrayList<String> arrCSV = new ArrayList<>();

        arrCSV.add(this.TID);
        arrCSV.add(this.movieID);
        arrCSV.add(this.MobileNum);
        arrCSV.add(this.Email);
        arrCSV.add(this.movieName);
        arrCSV.add(this.totalPrice);

        return String.join(mainDelimiter,arrCSV);
    }

    /**
     * Return the transaction ID
     * @return Transaction ID 
     */
    public String getTID(){
        return this.TID;
    }

    /**
     * Returns attribute Movie object of bookingHistory object
     * @return Movie object attribute
     */
    public String getmovieID(){
        return this.movieID;
    }

    /**
     * Returns attribute of mobile number of bookingHistory object
     * @return MobileNum attribute
     */
    public String getMobileNum(){
        return this.MobileNum;
    }

    /**
     * Returns attribute of email of bookingHistory object
     * @return Email attribute
     */
    public String getEmail(){
        return this.Email;
    }

    /**
     * Returns attribute of movieName of bookingHistory object
     * @return movieName attribute
     */
    public String getMoiveName(){
        return this.movieName;
    }

    /**
     * Returns the transaction time in the form of "mm : hh"
     * @return formatted transaction time
     */
    public String getTransactTime(){
        return this.TID.substring(11,13) + " : " + this.TID.substring(13);
    }

    /**
     * Returns the transaction date in the form of "dd - mm - yyyy"
     * @return formatted transaction date
     */
    public String getTransactDate(){
        return this.TID.substring(9,11) + " - " + this.TID.substring(7,9) + " - " + this.TID.substring(3,7);
    }

    /**
     * Return attribute of totalPrice of bookingHistory object
     * @return totalPrice attribute
     */
    public String gettotalPrice(){
        return this.totalPrice;
    }



    
}
