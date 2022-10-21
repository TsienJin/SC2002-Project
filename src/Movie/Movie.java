package Movie;

import java.util.ArrayList;

public class Movie {
    private int imdbID;
    private String movieTitle;
    enum showingStatus{Coming_Soon,Preview,Now_Showing};
    private showingStatus status;
    enum movieType{Blockbuster,ThreeD,Indie};
    private movieType type;
    private String synopsis;
    private String director;
    private ArrayList<String> cast;
    private Double overallRating;
    private ArrayList<Review> pastReviews;
    private int totalTicketSales;

    public Movie(int imdbID,String movieTitle,showingStatus status,movieType type,String synopsis,
    String director,ArrayList<String> cast,Double overallRating,ArrayList<Review> pastReviews,int totalTicketSales)
    {
        this.imdbID = imdbID;
        this.movieTitle = movieTitle;
        this.status = status;
        this.type = type;
        this.synopsis = synopsis;
        this.director = director;
        this.cast = cast;
        this.overallRating = overallRating;
        this.pastReviews = pastReviews;
        this.totalTicketSales = totalTicketSales;
    }

    public Movie(String lineFromCSV){}

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

    public void setImdbID(int imdbID){
        this.imdbID = imdbID;
    }
    public void setMovieTitle(String movieTitle){
        this.movieTitle = movieTitle;
    }
    public void setStatus(showingStatus status) {
        this.status = status;
    }
    public void setMovieType(movieType type){
        this.type = type;
    }
    public void setSynopsis(String synopsis){
        this.synopsis = synopsis;
    }
    public void setDirector(String director){
        this.director = director;
    }
    public void setOverallRating(Double overallRating){
        this.overallRating = overallRating;
    }
    public void setTotalTicketSales(int totalTicketSales){
        this.totalTicketSales = totalTicketSales;
    }

    // Either use the set or add method
    public void setCast(ArrayList<String> cast){
        this.cast = cast;
    }
    public void setPastReviews(ArrayList<Review> pastReviews){
        this.pastReviews = pastReviews;
    }
    // public void addCast(String castMember){
    //     this.cast.add(castMember);
    // }
    // public void addReview(String newReview){
    //     this.pastReviews.add(newReview);
    // }

}
