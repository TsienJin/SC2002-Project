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
    private Double overallRating;
    private ArrayList<Review> pastReviews;
    private int totalTicketSales;

    private OutputPrinterFormatter formatter = new OutputPrinterFormatter();

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
        this.overallRating = builder.overallRating;
        this.pastReviews = builder.pastReviews;
        this.totalTicketSales = builder.totalTicketSales;
    }

    public String toString() {
        return(""+
            formatter.Header(this.ID+tab+this.movieTitle) + nLine +
            formatter.Subheader("Status: ") + this.status.niceString() + nLine +
            formatter.Subheader("Movie Type: ") + this.type.niceString() + nLine +
            formatter.Subheader("Director: ") + this.director + nLine +
            formatter.Subheader("Cast: ") + formatter.ArrayToCSV(this.cast) + nLine + nLine +
            formatter.SubheaderUnderline("Synopsis") + nLine +
            formatter.Body(this.synopsis) + nLine + nLine +
            formatter.SubheaderUnderline("Movie stats") + nLine +
            formatter.Subheader("Rating: ") + String.format("%.2f / 5", this.overallRating) + nLine +
            formatter.Subheader("Ticket Sales: ") + String.format("%d", this.totalTicketSales) + nLine
        );
    }

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

    public String getID(){
        return this.ID;
    }
    public String getMovieTitle(){
        return this.movieTitle;
    }
    public EnumShowingStatus getStatus(){
        return this.status;
    }
    public EnumMovieType getMovieType(){
        return this.type;
    }
    public String getSynopsis(){
        return this.synopsis;
    }
    public String getDirector(){
        return this.director;
    }
    public ArrayList<String> getCast(){
        return this.cast;
    }
    public Double getOverallRating(){
        return this.overallRating;
    }
    public ArrayList<Review> getPastReviews(){
        return this.pastReviews;
    }
    public int getTotalTicketSales(){
        return this.totalTicketSales;
    }

    public void addReview(Review reviewToAdd){
        this.pastReviews.add(reviewToAdd);
    }
}