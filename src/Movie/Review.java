package Movie;

import java.util.ArrayList;

import OutputPrinter.InterfaceOutputPrinterFormatter;
import OutputPrinter.OutputPrinterFormatter;
import dataDriver.InterfaceCsvDelimiter;
import dataDriver.InterfaceToCsvStringHelper;

public class Review implements InterfaceToCsvStringHelper, InterfaceCsvDelimiter, InterfaceOutputPrinterFormatter{
    private String ID;
    private String movieID;
    private String username;
    private String strReview;
    private int usrRating;

    private OutputPrinterFormatter printer = new OutputPrinterFormatter();

    public Review(ReviewBuilder builder){
        this.ID = builder.ID;
        this.movieID = builder.movieID;
        this.username = builder.username;
        this.strReview = builder.strReview;
        this.usrRating = builder.usrRating;
    }

    
    /** 
     * @return String
     */
    public String toString(){
        return(""+
            printer.SubheaderUnderline(this.username) + nLine +
            printer.Subheader("Rating: "+this.usrRating) + nLine +
            printer.Body(this.strReview) + nLine
        );
    }

    
    /** 
     * @return String
     */
    public String getID() {
        return this.ID;
    }

    
    /** 
     * @return String
     */
    public String getMovieID(){
        return this.movieID;
    }

    
    /** 
     * @return String
     */
    public String getstrReview() {
        return this.strReview;
    }

    
    /** 
     * @return String
     */
    public String getUsername(){
        return this.username;
    }

    
    /** 
     * @return int
     */
    public int getUsrRating() {
        return this.usrRating;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toCsvString() {
        ArrayList<String> arrCSV = new ArrayList<>();
        arrCSV.add(this.movieID);
        arrCSV.add(this.ID);
        arrCSV.add(this.username);
        arrCSV.add(this.strReview);
        arrCSV.add(String.valueOf(this.usrRating));

        return String.join(mainDelimiter, arrCSV);
    }
}
