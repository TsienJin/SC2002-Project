package Bookings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class that compute the transaction ID for booking
 * @author keenlim
 */
public class TransactionID {
    private String cinemaCode;
    private LocalDateTime myDatetime;

    /**
     * Constructor for TransactionID that takes in cinemaCode as String
     * And uses the LocalDateTime class to compute the current time of booking
     * @param cinemaCode
     */
    public TransactionID(String cinemaCode){
        this.cinemaCode = cinemaCode;
        this.myDatetime = LocalDateTime.now();
    }

    /**
     * Function TID to format the Transaction ID in xxxyyyyMMddmmhh format
     * In which, xxx is the cinema code
     * yyyy is year
     * MMdd, month and date
     * mmhh, minutes and hours
     * @return String of transaction ID
     */
    public String TID(){
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyyMMddkkmm");
        String formattedDate = myDatetime.format(myFormatObj);
        //System.out.println(formattedDate);

        return cinemaCode + formattedDate;
    }


}
