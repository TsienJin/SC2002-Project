package Booking;
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

    private OutputPrinterFormatter formatter = new OutputPrinterFormatter();

    public bookingHistory(bookingHistoryBuilder builder){
        this.TID = builder.TID;
        this.movieID = builder.movieID;
        this.MobileNum = builder.MobileNum;
        this.Email = builder.Email;
        this.movieName = builder.movieName;
    }

    public String toString(){
        return("" + formatter.Header(this.MobileNum + tab + this.Email) + nLine +
                    formatter.Subheader("        Transaction ID: ") + this.TID + nLine +
                    formatter.Subheader("        Movie ID: ") + this.movieID + nLine +
                    formatter.Subheader("        Movie Name: ") + this.movieName + nLine +
                    formatter.Subheader("        Transact Time: ") + this.getTransactTime() + nLine +
                    formatter.Subheader("        Transact Date: ") + this.getTransactDate());
              
    }

    public String toCsvString(){
        ArrayList<String> arrCSV = new ArrayList<>();

        arrCSV.add(this.TID);
        arrCSV.add(this.movieID);
        arrCSV.add(this.MobileNum);
        arrCSV.add(this.Email);
        arrCSV.add(this.movieName);

        return String.join(mainDelimiter,arrCSV);
    }

    public String getTID(){
        return this.TID;
    }
    public String getmovieID(){
        return this.movieID;
    }
    public String getMobileNum(){
        return this.MobileNum;
    }
    public String getEmail(){
        return this.Email;
    }
    public String getMoiveName(){
        return this.movieName;
    }
    public String getTransactTime(){
        return this.TID.substring(11,13) + " : " + this.TID.substring(13);
    }
    public String getTransactDate(){
        return this.TID.substring(9,11) + " - " + this.TID.substring(7,9) + " - " + this.TID.substring(3,8);
    }



    
}
