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
    int totalTicketSales = 0;
    double totalAmountSold = 0;
    ReviewContainer reviews;

    private FileIO fileio = new FileIO();

    /** Private method to update ticket sales attribute
     * 
     */
    private void countTicketSales(){
        this.totalTicketSales = this.fileio.countMatches(EnumDataFiles.Review.toString(), this.ID);
    }

    /** Private method to update total value sales attibute
     * 
     */
    private void countTotalAmount(){
        this.totalAmountSold = this.fileio.countSales(EnumDataFiles.bookingHistory.toString(), this.ID);
    }

    /** Default constructor
     * 
     */
    public MovieBuilder(){}

    /** Constructor that builds from CSV line
     * 
     * @param csvString
     */
    public MovieBuilder(String csvString){
        this.updateFromCsvString(csvString);
    }

    
    /** Private method to update attributes from CSV line
     * @param csvString
     */
    private void updateFromCsvString(String csvString){
        ArrayList<String> csvArr = new ArrayList<>(Arrays.asList(csvString.split(mainDelimiter)));

        this.ID = csvArr.get(0);
        this.movieTitle = csvArr.get(1);
        this.status = EnumShowingStatus.valueOf(csvArr.get(2));
        this.type = EnumMovieType.valueOf(csvArr.get(3));
        this.synopsis = csvArr.get(4);
        this.director = csvArr.get(5);
        this.cast = new ArrayList<>(Arrays.asList(csvArr.get(6).split(subDelimiter)));

        this.reviews = new ReviewContainer(this.ID);
        this.countTicketSales();
        this.countTotalAmount();
    }

    
    /** Method to hydrate attributes from movie ID
     * @param id
     * @return MovieBuilder
     */
    public MovieBuilder fromMovieID(String id){
        try{
            String csvString = fileio.findMatchFromFile(EnumDataFiles.Movie.toString(), id);
            this.updateFromCsvString(csvString);
        } catch (Exception e) {
            // pass
        }
        return this;
    }

    
    /** Setter for Movie ID 
     * @param ID
     * @return MovieBuilder
     */
    public MovieBuilder setID(String ID){
        this.ID = ID;
        this.countTicketSales();
        this.reviews = new ReviewContainer(ID);
        return this;
    }
    
    /** Setter for Movie Title
     * @param movieTitle
     * @return MovieBuilder
     */
    public MovieBuilder setMovieTitle(String movieTitle){
        this.movieTitle = movieTitle;
        return this;
    }
    
    /** Setter for Movie Status
     * @param status
     * @return MovieBuilder
     */
    public MovieBuilder setStatus(EnumShowingStatus status) {
        this.status = status;
        return this;
    }
    
    /** Setter for Movie Type
     * @param type
     * @return MovieBuilder
     */
    public MovieBuilder setMovieType(EnumMovieType type){
        this.type = type;
        return this;
    }
    
    /** Setter for Movie Synopsis
     * @param synopsis
     * @return MovieBuilder
     */
    public MovieBuilder setSynopsis(String synopsis){
        this.synopsis = synopsis;
        return this;
    }
    
    /** Setter for Movie Director
     * @param director
     * @return MovieBuilder
     */
    public MovieBuilder setDirector(String director){
        this.director = director;
        return this;
    }

    
    /** Setter for TotalTicketSales
     * @param totalTicketSales
     * @return MovieBuilder
     */
    public MovieBuilder setTotalTicketSales(int totalTicketSales){
        this.totalTicketSales = totalTicketSales;
        return this;
    }
    
    /** Setter for total amount sold
     * @param totalAmountSold
     * @return MovieBuilder
     */
    public MovieBuilder setTotalAmountSold(int totalAmountSold){
        this.totalAmountSold = totalAmountSold;
        return this;
    }
    
    /** Setter for casts
     * @param cast
     * @return MovieBuilder
     */
    public MovieBuilder setCast(ArrayList<String> cast){
        this.cast = cast;
        return this;
    }

    
    /** Setter for Movie Container object
     * @param reviewContainer
     * @return MovieBuilder
     */
    public MovieBuilder setReviewContainer(ReviewContainer reviewContainer){
        this.reviews = reviewContainer;
        return this;
    }

    
    /** Build method to construct Movie object
     * @return Movie
     */
    @Override
    public Movie build() {
        return new Movie(this);
    }
}
