package tests;

import org.junit.Assert;
import org.junit.Test;
import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;

import java.util.Objects;

import static org.junit.Assert.*;

public class TestClasses1 {
    public boolean compareSongs(Song songObj1, Song songObj2){
        assertTrue(Objects.equals(songObj1.getTitle(), songObj2.getTitle()));
        assertTrue(Objects.equals(songObj1.getArtist(), songObj2.getArtist()));
        assertTrue(Objects.equals(songObj1.getSongID(), songObj2.getSongID()));
        return true;
    }

    public boolean compareRatings(Rating ratingObj1, Rating ratingObj2){
        assertTrue(ratingObj1.getRating()==ratingObj2.getRating());
        assertTrue(Objects.equals(ratingObj1.getReviewerID(), ratingObj2.getReviewerID()));
        return true;
    }

    public boolean compareReviewers(Reviewer reviewer1, Reviewer reviewer2){
        assertTrue(Objects.equals(reviewer1.getReviewerID(), reviewer2.getReviewerID()));
        return true;
    }

    @Test
    public void testCompareSongs(){
        Song song1 = new Song("Smart","LE SSERAFIM", "1");
        assertTrue(song1.getTitle().equals("Smart"));
        assertTrue(song1.getArtist().equals("LE SSERAFIM"));
        assertTrue(song1.getSongID().equals("1"));

        song1.setTitle("YOU");
        song1.setArtist("Travis Scott");
        song1.setSongID("3");

        assertTrue(song1.getTitle().equals("YOU"));
        assertTrue(song1.getArtist().equals("Travis Scott"));
        assertTrue(song1.getSongID().equals("3"));

        Song song2 = new Song("YOU","Travis Scott", "3");
        assertTrue(compareSongs(song1, song2));

    }

    @Test
    public void testCompareRatings(){
        Rating rate1 = new Rating("David",5);
        assertTrue(rate1.getReviewerID().equals("David"));
        assertTrue(rate1.getRating()==5);

        rate1.setReviewerID("Connor");
        rate1.setRating(3);
        assertTrue(rate1.getReviewerID().equals("Connor"));
        assertTrue(rate1.getRating()==3);

        Rating rate2 = new Rating("Connor",3);
        assertTrue(compareRatings(rate1,rate2));

        Rating rate3 = new Rating("David",5);
        Rating rate4 = new Rating("Connor", 5);
        compareRatings(rate3,rate4);

        Rating rate5 = new Rating("Amy", 10);
        assertTrue(rate5.getRating()==-1);

        rate5.setRating(-20);
        assertTrue(rate5.getRating()==-1);

        Rating rate6 = new Rating("Amy", -30);
        assertTrue(rate6.getRating()==-1);
        rate6.setRating(40);
        assertTrue(rate6.getRating()==-1);

    }

    @Test
    public void testCompareReviewers(){
        Reviewer review1 = new Reviewer("David");
        assertTrue(review1.getReviewerID().equals("David"));

        review1.setReviewerID("Connor");
        assertTrue(review1.getReviewerID().equals("Connor"));

        Reviewer review2 = new Reviewer("Connor");
        assertTrue(compareReviewers(review1,review1));

        Rating rate1 = review1.rateSong(5);
        assertTrue(rate1.getReviewerID().equals("Connor"));
        assertTrue(rate1.getRating()==5);

        Rating rate2 = review1.rateSong(10);
        assertTrue(rate2.getReviewerID().equals("Connor"));
        assertTrue(rate2.getRating()==-1);

        rate2.setRating(20);
        assertTrue(rate2.getRating()==-1);

    }
}
