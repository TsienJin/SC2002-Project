package Movie;

public class Review {
    private int reviewID;
    private String strReview;
    private int userRating;

    public Review(int reviewID,String strReview,int userRating) {
        this.reviewID = reviewID;
        this.strReview = strReview;
        this.userRating = userRating;
    }

    public int getreviewID() {
        return this.reviewID;
    }
    public String getstrReview() {
        return this.strReview;
    }
    public int getuserRating() {
        return this.userRating;
    }

    public void setreviewID(int reviewID) {
        this.reviewID = reviewID;
    }
    public void setstrReview(String strReview) {
        this.strReview = strReview;
    }
    public void setuserRating(int userRating) {
        this.userRating = userRating;
    }
}
