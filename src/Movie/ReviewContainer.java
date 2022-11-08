package Movie;

import dataDriver.*;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ReviewContainer implements InterfaceCsvDelimiter {
    FileIO fileio = new FileIO();

    private String movieID;
    private ArrayList<Review> reviewArr = new ArrayList<>();

    /**
     * Gets all reviews of the specified MovieID
     * Adds into the Array reviewArr 
     * @param movieID
     */
    public ReviewContainer(String movieID){
        this.movieID = movieID;
        try {
            fileio.findAllMatchesFromFile(EnumDataFiles.Review.toString(), movieID).forEach(line->{
                try {
                    this.reviewArr.add(new ReviewBuilder(line).build());
                } catch (Exception e) {
                    // pass 
                }
            });
        } catch (Exception e) {}
    }

    
    /** 
     * Retrieves User Rating for each review in Array reviewArr
     * @return double
     */
    public double getRating() {
        AtomicInteger sum = new AtomicInteger(0);
        AtomicInteger count = new AtomicInteger(0);
        try {
            reviewArr.forEach(review->{
                sum.set(sum.get()+review.getUsrRating());
                count.incrementAndGet();
            });
        } catch (Exception e) {}

        return (count.get()>0) ? (sum.doubleValue() / count.doubleValue()) : count.doubleValue();

        // int sum = 0;
        // int count = 0;
        
        

    }
    
    /** 
     * Returns the Array reviewArr 
     * @return ArrayList<Review>
     */
    public ArrayList<Review> getReviews(){
        return this.reviewArr;
    }

    /**
     * Displays all reviews in the Array reviewArr 
     */
    public void printReviews() {
        for(Review review : this.reviewArr){
            System.out.println(review.toString());
        }
    }
}
