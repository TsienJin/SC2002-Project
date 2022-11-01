package Movie;

import dataDriver.*;
import java.io.*;

public class ReviewContainer {
    String relativeFileDir = new File("").getAbsolutePath() + "/src/dataDriver/data/";

    public double getRating(String id) {
        BufferedReader br = null;
        String line = "";
        int sum = 0;
        int count = 0;

        try {
            br = new BufferedReader(new FileReader(this.relativeFileDir + "review.csv"));
            try {
                while ((line = br.readLine()) != null) {
                    // use comma as separator

                    String[] review = line.split(",");
                    if (review[0].equals(id)) {
                        int sal = Integer.parseInt(review[4]);
                        sum = sum + sal;
                        count++;
                    }
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("NA");
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        double average = sum / count;
        return average;
    }

    public void showReviews(String id) {
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(this.relativeFileDir + "review.csv"));
            try {
                while ((line = br.readLine()) != null) {
                    String[] review = line.split(",");
                    if (review[0].equals(id)) {
                        System.out.println(review[3]);
                    }
                }
            } catch (IOException e) {
                System.out.println("NA");
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
