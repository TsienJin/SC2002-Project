package Movie;

import java.util.ArrayList;

public class Movie {
    private final int imdbID;
    private final String movieTitle;
    private final showingStatus status;
    private final movieType type;
    private final String synopsis;
    private final String director;
    private final ArrayList<String> cast;
    private final Double overallRating;
    private final ArrayList<Review> pastReviews;
    private final int totalTicketSales;

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

    // public Movie(String lineFromCSV){}

    public int getImdbID(){
        return this.imdbID;
    }
    public String getMovieTitle(){
        return this.movieTitle;
    }
    public showingStatus getStatus(){
        return this.status;
    }
    public movieType getMovieType(){
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