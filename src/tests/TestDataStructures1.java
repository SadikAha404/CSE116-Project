package tests;

import org.junit.Test;
import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;
import ratings.datastructures.LinkedListNode;

import static org.junit.Assert.*;

public class TestDataStructures1 {

    public boolean compareListsOfRatings(LinkedListNode<Rating> rate1, LinkedListNode<Rating> rate2){
        if(rate1==null&&rate2==null){
            return true;
        }

        if(size(rate1)!=size(rate2)){
            return false;
        }
        while(rate1!=null&&rate2!=null){
            if(rate1.getValue() ==null || rate2.getValue()==null){
                return false;
            }
            if(rate1.getValue().getRating() != rate2.getValue().getRating() || !(rate1.getValue().getReviewerID().equals(rate2.getValue().getReviewerID()))){
                return false;
            }
            rate1=rate1.getNext();
            rate2=rate2.getNext();
        }
        return true;
    }

    public int size(LinkedListNode<Rating> rate){
        int totalLength = 0;
        LinkedListNode<Rating> temp=rate;
        while(temp != null){
            totalLength++;
            temp=temp.getNext();
        }
        return totalLength;
    }


    @Test
    public void testAverageRating(){
        Song song1 = new Song("Smart", "Chae", "1");
        song1.addRating(new Rating("A",1));
        song1.addRating(new Rating("A",5));
        song1.addRating(new Rating("A",-1));
        song1.addRating(new Rating("A",-1));
        assertEquals(3.0,song1.averageRating(),0.001);

        Song song2 = new Song("Smart", "Chae", "1");
        song2.addRating(new Rating("A",1));
        song2.addRating(new Rating("A",2));
        song2.addRating(new Rating("A",3));
        song2.addRating(new Rating("A",4));
        assertEquals(2.5,song2.averageRating(),0.001);

        Song song3 = new Song("Smart", "Chae", "1");
        assertEquals(0.0,song3.averageRating(),0.001);

    }

    @Test
    public void testRemoveRatingByReviewer(){
        Song song1 = new Song("Smart", "Chae", "1");
        song1.addRating(new Rating("A",1));
        song1.addRating(new Rating("B",5));
        song1.addRating(new Rating("C",4));
        song1.addRating(new Rating("D",3));

        song1.removeRatingByReviewer(new Reviewer("D"));

        Song song2 = new Song("Smart", "Chae", "1");
        song2.addRating(new Rating("A",1));
        song2.addRating(new Rating("B",5));
        song2.addRating(new Rating("C",4));

        assertTrue(compareListsOfRatings(song1.getRatings(),song2.getRatings()));

        Song song3 = new Song("Smart", "Chae", "1");
        song3.addRating(new Rating("A",1));
        song3.addRating(new Rating("B",5));
        song3.addRating(new Rating("C",4));
        song3.addRating(new Rating("B",3));

        song3.removeRatingByReviewer(new Reviewer("B"));

        Song song4 = new Song("Smart", "Chae", "1");
        song4.addRating(new Rating("A",1));
        song4.addRating(new Rating("C",4));
        song4.addRating(new Rating("B",3));

        assertTrue(compareListsOfRatings(song3.getRatings(),song4.getRatings()));

        Song song5 = new Song("Smart", "Chae", "1");
        song5.addRating(new Rating("A",1));

        song5.removeRatingByReviewer(new Reviewer("A"));

        assertTrue(compareListsOfRatings(song5.getRatings(),null));



    }
}
