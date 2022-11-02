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

    private OutputPrinterFormatter formatter = new OutputPrinterFormatter();

    public bookingHistory(bookingHistoryBuilder builder){
        this.TID = builder.TID;
        this.movieID = builder.movieID;
        this.MobileNum = builder.MobileNum;
        this.Email = builder.Email;
    }

    public String toString(){
        return("" + formatter.Header(this.MobileNum + tab + this.Email) + nLine +
                    formatter.Subheader("        Transaction ID: ") + this.TID + nLine +
                    formatter.Subheader("        Movie ID: ") + this.movieID + nLine
              );
    }

    public String toCsvString(){
        ArrayList<String> arrCSV = new ArrayList<>();

        arrCSV.add(this.TID);
        arrCSV.add(this.movieID);
        arrCSV.add(this.MobileNum);
        arrCSV.add(this.Email);

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



    
}
