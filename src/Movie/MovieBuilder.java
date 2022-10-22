package Movie;
import java.util.ArrayList;
import java.util.Arrays;

public class MovieBuilder {
    String imdbID = "emptyID";
    String movieTitle = "emptyTitle";
    EnumShowingStatus status = EnumShowingStatus.Undefined;
    EnumMovieType type = EnumMovieType.Undefined;
    String synopsis = "emptySynopsis";
    String director = "emptyDirectory";
    ArrayList<String> cast = new ArrayList<>(Arrays.asList("emptyCast"));
    Double overallRating = 0.0;
    ArrayList<Review> pastReviews = new ArrayList<>(Arrays.asList());
    int totalTicketSales = 0;

    public static MovieBuilder movie() {
        return new MovieBuilder();
    }

    public MovieBuilder setImdbID(String imdbID){
        this.imdbID = imdbID;
        return this;
    }
    public MovieBuilder setMovieTitle(String movieTitle){
        this.movieTitle = movieTitle;
        return this;
    }
    public MovieBuilder setStatus(EnumShowingStatus status) {
        this.status = status;
        return this;
    }
    public MovieBuilder setMovieType(EnumMovieType type){
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

    public void constructfromCSVLine(String CSVLine){ // should return CSV string 

    }

    public Movie build() {
        return new Movie(this);
    }
}
