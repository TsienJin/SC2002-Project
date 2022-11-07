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

    /** 
     * Takes in ReviewBuilder object
     * Constructs the Review object from ReviewBuilder object
     * @param builder ReviewBuilder Object
     */
    public Review(ReviewBuilder builder){
        this.ID = builder.ID;
        this.movieID = builder.movieID;
        this.username = builder.username;
        this.strReview = builder.strReview;
        this.usrRating = builder.usrRating;
    }

    
    /** 
     * Returns a formatted string of attributes for Review object
     * @return Formatted string of attributes
     */
    public String toString(){
        return(""+
            printer.SubheaderUnderline(this.username) + nLine +
            printer.Subheader("Rating: "+this.usrRating) + nLine +
            printer.Body(this.strReview) + nLine
        );
    }

    /** 
     * Returns a constructed string of attributes for Review object in the form of csv line
     * @return Constructed string of attributes
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
    
    /** 
     * Returns attribute ID of Review object
     * @return ID attribute
     */
    public String getID() {
        return this.ID;
    }

    
    /** 
     * Returns attribute MovieID of Review object
     * @return MovieID attribute
     */
    public String getMovieID(){
        return this.movieID;
    }

    
    /** 
     * Returns attribute strReview of Review object
     * @return strReview attribute
     */
    public String getstrReview() {
        return this.strReview;
    }

    
    /** 
     * Returns attribute Username of Review object
     * @return Username attribute
     */
    public String getUsername(){
        return this.username;
    }


    /** 
     * Returns attribute usrRating of Review object
     * @return usrRating attribute
     */
    public int getUsrRating() {
        return this.usrRating;
    }

}
