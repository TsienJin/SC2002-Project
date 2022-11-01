package Movie;

import dataDriver.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ReviewContainer {
    FileIO fileio = new FileIO();

    public double getRating(String id) {
        AtomicInteger sum = new AtomicInteger(0);
        AtomicInteger count = new AtomicInteger(0);
        this.fileio.readFromFile(EnumDataFiles.Review.toString()).forEach(review -> {
            String[] rev = review.split(",");
            if (this.fileio.isSameID(review, id, 0)) {
                int sal = Integer.parseInt(rev[4]);
                sum.set(sum.get() + sal);
                count.getAndIncrement();
            }
        });
        double average = sum.get() / count.get();
        return average;
    }

    public void showReviews(String id) {
        this.fileio.readFromFile(EnumDataFiles.Review.toString()).forEach(review -> {
            String[] rev = review.split(",");
            if (this.fileio.isSameID(review, id, 0)) {
                System.out.println(rev[3]);
            }
        });
    }
}
