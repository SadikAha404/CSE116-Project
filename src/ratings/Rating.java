package ratings;

public class Rating {
    private String reviewerID;
    private int rating;

    public Rating(String reviewerID, int rating){
        this.reviewerID=reviewerID;
        if (1<=rating&&rating<=5){
            this.rating=rating;
        }
        else{
            this.rating = -1;
        }
    }

    public void setReviewerID(String reviewerID) {
        this.reviewerID = reviewerID;
    }

    public String getReviewerID() {
        return reviewerID;
    }

    public void setRating(int rating) {
        if (1<=rating&&rating<=5){
            this.rating=rating;
        }
        else{
            this.rating = -1;
        }
    }

    public int getRating() {
        return rating;
    }
}
