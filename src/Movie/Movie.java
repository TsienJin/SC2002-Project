package Movie;

import java.util.ArrayList;

import OutputPrinter.InterfaceOutputPrinterFormatter;
import OutputPrinter.OutputPrinterFormatter;
import dataDriver.InterfaceCsvDelimiter;
import dataDriver.InterfaceToCsvStringHelper;

public class Movie implements InterfaceToCsvStringHelper, InterfaceCsvDelimiter, InterfaceOutputPrinterFormatter{
    private String ID;
    private String movieTitle;
    private EnumShowingStatus status;
    private EnumMovieType type;
    private String synopsis;
    private String director;
    private ArrayList<String> cast;
    // private Double overallRating;
    // private ArrayList<Review> pastReviews;
    private int totalTicketSales;
    private double totalAmountSold;
    private ReviewContainer reviews;

    private OutputPrinterFormatter formatter = new OutputPrinterFormatter();

    /** 
     * Takes in MovieBuilder object
     * Constructs the Movie object from MovieBuilder object
     * @param builder MovieBuilder Object
     */
    public Movie(MovieBuilder builder)
    {
        // can also add checks for null beforehand
        this.ID = builder.ID;
        this.movieTitle = builder.movieTitle;
        this.status = builder.status;
        this.type = builder.type;
        this.synopsis = builder.synopsis;
        this.director = builder.director;
        this.cast = builder.cast;
        // this.overallRating = builder.overallRating;
        // this.pastReviews = builder.pastReviews;
        this.totalTicketSales = builder.totalTicketSales;
        this.totalAmountSold = builder.totalAmountSold;
        this.reviews = builder.reviews;
    }

    /** 
     * Returns a formatted string of attributes for Movie object
     * @return Formatted string of attributes
     */
    public String toString() {
        return(""+
            formatter.Header(this.ID+tab+this.movieTitle) + nLine +
            formatter.Subheader("Status: ") + this.status.niceString() + nLine +
            formatter.Subheader("Movie Type: ") + this.type.niceString() + nLine +
            formatter.Subheader("Director: ") + this.director + nLine +
            formatter.Subheader("Cast: ") + formatter.ArrayToCSV(this.cast) + nLine + nLine +
            formatter.SubheaderUnderline("Synopsis") + nLine +
            formatter.Body(this.synopsis.replace("&", ",")) + nLine + nLine +
            formatter.SubheaderUnderline("Movie stats") + nLine +
            formatter.Subheader("Rating: ") + String.format("%.2f / 5", this.reviews.getRating()) + nLine +
            formatter.Subheader("Ticket Sales: ") + String.format("%d", this.totalTicketSales) + nLine +
            formatter.Subheader("Total Amount Sold: $") + String.format("%.2f", this.totalAmountSold) + nLine
        );
    }

    /** 
     * Returns a constructed string of attributes for Movie object in the form of csv line
     * @return Constructed string of attributes
     */
    public String toCsvString() {

        // Delimiters are from the toCsvStringHelper interface

        ArrayList<String> arrCSV = new ArrayList<>();

        arrCSV.add(this.ID);
        arrCSV.add(this.movieTitle);
        arrCSV.add(this.status.name());
        arrCSV.add(this.type.name());
        arrCSV.add(this.synopsis);
        arrCSV.add(this.director);
        arrCSV.add(String.join(subDelimiter, this.cast));

        return String.join(mainDelimiter, arrCSV);
    }

    /** 
     * Returns the difference of Rating attribute for 2 Movie objects
     * To use for sorting purposes
     * @param movie Movie object
     * @return difference of rating between 2 Movie object
     */
    public double compareRatingTo(Movie movie){
        return this.reviews.getRating() - movie.getOverallRating();
    }

    /** 
     * Returns the difference of totalTicketSales attribute for 2 Movie objects
     * To use for sorting purposes
     * @param movie Movie object
     * @return difference of totalTicketSales between 2 Movie object
     */
    public int compareSalesTo(Movie movie){
        return this.totalTicketSales - movie.getTotalTicketSales();
    }

    /** 
     * Returns attribute ID of Movie object
     * @return ID attribute
     */
    public String getID(){
        return this.ID;
    }

    /** 
     * Returns attribute movieTitle of Movie object
     * @return movieTitle attribute
     */
    public String getMovieTitle(){
        return this.movieTitle;
    }

    /** 
     * Returns attribute status of Movie object
     * @return status attribute
     */
    public EnumShowingStatus getStatus(){
        return this.status;
    }

    /** 
     * Returns attribute MovieType of Movie object
     * @return MovieType attribute
     */
    public EnumMovieType getMovieType(){
        return this.type;
    }
    
    /** 
     * Returns attribute synopsis of Movie object
     * @return synopsis attribute
     */
    public String getSynopsis(){
        return this.synopsis;
    }

    /** 
     * Returns attribute director of Movie object
     * @return director attribute
     */
    public String getDirector(){
        return this.director;
    }

    /** 
     * Returns attribute cast of Movie object
     * @return cast attribute
     */
    public ArrayList<String> getCast(){
        return this.cast;
    }

    /** 
     * Returns attribute OverallRating of Movie object via `getRating()` function
     * @return Rating of Movie
     */
    public Double getOverallRating(){
        return this.reviews.getRating();
    }
    
    /** 
     * Returns attribute PastReviews of Movie object via `getReviews()` function
     * @return Past Reviews of Movie
     */
    public ArrayList<Review> getPastReviews(){
        return this.reviews.getReviews();
    }

    /** 
     * Returns attribute totalTicketSales of Movie object
     * @return totalTicketSales attribute
     */
    public int getTotalTicketSales(){
        return this.totalTicketSales;
    }

    /** 
     * Display Movie Reviews via `printReviews` function
     */
    public void printReviews() {
        this.reviews.printReviews();
    }

    // public void addReview(Review reviewToAdd){
    //     this.pastReviews.add(reviewToAdd);
    // }
}