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
     *
     * @param builder
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
     *
     * @return
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
     *
     * @return
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
     *
     * @return
     */
    public String getTID(){
        return this.TID;
    }

    /**
     *
     * @return
     */
    public String getmovieID(){
        return this.movieID;
    }

    /**
     *
     * @return
     */
    public String getMobileNum(){
        return this.MobileNum;
    }

    /**
     *
     * @return
     */
    public String getEmail(){
        return this.Email;
    }

    /**
     *
     * @return
     */
    public String getMoiveName(){
        return this.movieName;
    }

    /**
     *
     * @return
     */
    public String getTransactTime(){
        return this.TID.substring(11,13) + " : " + this.TID.substring(13);
    }

    /**
     *
     * @return
     */
    public String getTransactDate(){
        return this.TID.substring(9,11) + " - " + this.TID.substring(7,9) + " - " + this.TID.substring(3,8);
    }

    /**
     *
     * @return
     */
    public String gettotalPrice(){
        return this.totalPrice;
    }



    
}
