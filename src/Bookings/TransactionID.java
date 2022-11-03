package Bookings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class TransactionID {
    private String cinemaCode;
    private LocalDateTime myDatetime;

    public TransactionID(String cinemaCode){
        this.cinemaCode = cinemaCode;
        this.myDatetime = LocalDateTime.now();
    }

    public String TID(){
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyyMMddkkmm");
        String formattedDate = myDatetime.format(myFormatObj);
        //System.out.println(formattedDate);

        return cinemaCode + formattedDate;
    }


}
