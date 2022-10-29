package Movie;
import java.util.ArrayList;
import java.util.Arrays;

import dataDriver.EnumDataFiles;
import dataDriver.FileIO;
import dataDriver.InterfaceCsvDelimiter;

public class MovieBuilder implements InterfaceBuilder<Movie>, InterfaceCsvDelimiter {
    String ID;
    String movieTitle;
    EnumShowingStatus status = EnumShowingStatus.Undefined;
    EnumMovieType type = EnumMovieType.Undefined;
    String synopsis;
    String director;
    ArrayList<String> cast;
    Double overallRating = 0.0;
    ArrayList<Review> pastReviews;
    int totalTicketSales = 0;

    private FileIO fileio = new FileIO();


    /////// What is the purpose of movie()? -- TJ
    public static MovieBuilder movie() {
        return new MovieBuilder();
    }

    public MovieBuilder(){}

    public MovieBuilder(String csvString){
        this.updateFromCsvString(csvString);
    }

    private void updateFromCsvString(String csvString){
        ArrayList<String> csvArr = new ArrayList<>(Arrays.asList(csvString.split(mainDelimiter)));

        this.ID = csvArr.get(0);
        this.movieTitle = csvArr.get(1);
        this.status = EnumShowingStatus.valueOf(csvArr.get(2));
        this.type = EnumMovieType.valueOf(csvArr.get(3));
        this.synopsis = csvArr.get(4);
        this.director = csvArr.get(5);
        this.cast = new ArrayList<>(Arrays.asList(csvArr.get(6).split(subDelimiter)));
    }

    public MovieBuilder fromMovieID(String id){
        String csvString = fileio.findMatchFromFile(EnumDataFiles.Movie.toString(), id);
        this.updateFromCsvString(csvString);
        return this;
    }

    public MovieBuilder setID(String ID){
        this.ID = ID;
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

    @Override
    public Movie build() {
        return new Movie(this);
    }

    // @Override
    // public Movie fromCsvString(String csvString) {




    //     return null;
    // }
}
