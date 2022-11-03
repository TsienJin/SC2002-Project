package Movie;

import dataDriver.*;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ReviewContainer implements InterfaceCsvDelimiter {
    FileIO fileio = new FileIO();

    private String movieID;
    private ArrayList<Review> reviewArr = new ArrayList<>();

    public ReviewContainer(String movieID){
        this.movieID = movieID;
        try {
            fileio.findAllMatchesFromFile(EnumDataFiles.Review.toString(), movieID).forEach(line->{
                try {
                    this.reviewArr.add(new ReviewBuilder(line).build());
                } catch (Exception e) {
                    // LMAO pass 
                }
            });
        } catch (Exception e) {}
    }

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

    public void showReviews() {
        try {
            reviewArr.forEach(review->{
                System.out.println(review.toString());
            });
        } catch (Exception e) {
            // pass LMAO 
        }
    }

    public ArrayList<Review> getReviews(){
        return this.reviewArr;
    }
}
