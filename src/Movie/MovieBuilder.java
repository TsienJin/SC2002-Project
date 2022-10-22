package Movie;
import java.util.ArrayList;
enum showingStatus{Coming_Soon,Preview,Now_Showing};
enum movieType{Blockbuster,ThreeD,Indie};

public class MovieBuilder {
    int imdbID;
    String movieTitle;
    showingStatus status;
    movieType type;
    String synopsis;
    String director;
    ArrayList<String> cast;
    Double overallRating;
    ArrayList<Review> pastReviews;
    int totalTicketSales;

    public static MovieBuilder movie() {
        return new MovieBuilder();
    }

    public MovieBuilder setImdbID(int imdbID){
        this.imdbID = imdbID;
        return this;
    }
    public MovieBuilder setMovieTitle(String movieTitle){
        this.movieTitle = movieTitle;
        return this;
    }
    public MovieBuilder setStatus(showingStatus status) {
        this.status = status;
        return this;
    }
    public MovieBuilder setMovieType(movieType type){
        this.type = type;
        return this;
    }
    public MovieBuilder setSynopsis(String synopsis){
        this.synopsis = synopsis;
        return this;
    }
    public MovieBuilder setDirector(String director){
        this.director = director;
        return this;
    }
    public MovieBuilder setOverallRating(Double overallRating){
        this.overallRating = overallRating;
        return this;
    }
    public MovieBuilder setTotalTicketSales(int totalTicketSales){
        this.totalTicketSales = totalTicketSales;
        return this;
    }
    public MovieBuilder setCast(ArrayList<String> cast){
        this.cast = cast;
        return this;
    }
    public MovieBuilder setPastReviews(ArrayList<Review> pastReviews){
        this.pastReviews = pastReviews;
        return this;
    }
    // public void addCast(String castMember){
    //     this.cast.add(castMember);
    // }
    // public void addReview(String newReview){
    //     this.pastReviews.add(newReview);
    // }

    public String constructfromCSVLine(String CSVLine){
        return "String";
    }

    public Movie build() {
        return new Movie(this);
    }
}
