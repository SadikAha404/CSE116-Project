package ratings;

import ratings.datastructures.LinkedListNode;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class Ratable {
    private String title;
    private LinkedListNode<Rating> allRatings;

    public void setTitle(String title){
        this.title=title;
    }

    public String getTitle(){
        return title;
    }

    public void addRating(Rating rate){
        if (allRatings==null){
            allRatings = new LinkedListNode<>(rate,null);
        }
        else{
            LinkedListNode<Rating> temp=allRatings;
            while(temp.getNext()!=null){
                temp = temp.getNext();
            }
            temp.setNext(new LinkedListNode<>(rate,null));
        }
    }

    public LinkedListNode<Rating> getRatings(){
        if(allRatings==null){
            return null;
        }
        return allRatings;
    }

    public void setRatings(LinkedListNode<Rating> newRatings){
        allRatings =newRatings;
    }

    public double averageRating(){
        int total = 0;
        double counter = 0;
        if (allRatings ==null){
            return (double)(total);
        }

        LinkedListNode<Rating> temp=allRatings;
        while(temp!=null){
            Rating rate = temp.getValue();
            if(rate.getRating() != -1){
                total+= rate.getRating();
                counter++;
            }
            temp = temp.getNext();
        }
        if(counter==0){
            return 0.0;
        }
        return (double)(total/counter);
    }


    public void removeRatingByReviewer(Reviewer review){
        if (allRatings ==null){
            return;
        }
        LinkedListNode<Rating> temp=allRatings;
        LinkedListNode<Rating> updatedList = null;
        while(temp!=null){
            if(temp.getValue().getReviewerID().equals(review.getReviewerID())){
                if(updatedList==null){
                    allRatings=allRatings.getNext();
                }
                else{
                    updatedList.setNext(temp.getNext());
                }
                break;
            }
            updatedList = temp;
            temp = temp.getNext();
        }

    } 

    public double bayesianAverageRating(int numOfExtraRating, int valueOfExtraRating){
        if(valueOfExtraRating<1||valueOfExtraRating>5||numOfExtraRating<0){
            return 0.0;
        }
        int total = 0;
        double counter = 0;

        LinkedListNode<Rating> temp=allRatings;
        while(temp!=null){
            Rating rate = temp.getValue();
            if(rate.getRating() != -1){
                total+= rate.getRating();
                counter++;
            }
            temp = temp.getNext();
        }
        int i=0;
        while(i != numOfExtraRating){
            total += valueOfExtraRating;
            counter++;
            i++;
        }
        if(counter==0){
            return 0.0;
        }
        return (double)(total/counter);
    }


}
