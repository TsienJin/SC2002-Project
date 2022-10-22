package Movie;

import java.util.ArrayList;

public class Movie {
    private String imdbID;
    private String movieTitle;
    private EnumShowingStatus status;
    private EnumMovieType type;
    private String synopsis;
    private String director;
    private ArrayList<String> cast;
    private Double overallRating;
    private ArrayList<Review> pastReviews;
    private int totalTicketSales;

    public Movie(MovieBuilder builder)
    {
        // can also add checks for null beforehand
        this.imdbID = builder.imdbID;
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
    
    //// Can depreciate
    // public Movie(String lineFromCSV){
        
    // }

    public String toString() {
        return "string";
    }

    public String toCSVString() {
        return "string";
    }

    public String getImdbID(){
        return this.imdbID;
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
}