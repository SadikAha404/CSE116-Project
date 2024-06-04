package tests;

import org.junit.Test;
import ratings.Movie;
import ratings.Rating;
import ratings.Song;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TestClasses2 {
    public boolean compareArrayListsIgnoreCase(ArrayList<String> cast1, ArrayList<String> cast2){
        assertTrue(cast1.size()==cast2.size());
        for (int i = 0; i < cast1.size(); i++){
            assertTrue(cast1.get(i).compareToIgnoreCase(cast2.get(i))==0);
        }
        return true;
    }

    @Test
    public void testGetCast(){
        String title1 = "Star Trek";
        ArrayList<String> cast1 = new ArrayList<>(Arrays.asList("William Shatner", "Leonard Nimoy", "Nichelle Nichols", "Gene Roddenberry","DeForest Kelley","Majel Barrett"));
        Movie movie1 = new Movie(title1,cast1);

        ArrayList<String> cast2 = new ArrayList<>(Arrays.asList("william shatner", "leonard nimoy", "nichelle nichols", "gene roddenberry","deForest kelley","majel barrett"));
        Movie movie2 = new Movie(title1,cast2);

        assertTrue(compareArrayListsIgnoreCase(movie1.getCast(), cast1));
        assertTrue(compareArrayListsIgnoreCase(movie2.getCast(), cast2));
    }

    @Test
    public void testSongBayesianAverageRating(){
        Song song1 = new Song("Smart", "Chae", "1");
        song1.addRating(new Rating("A",4));
        song1.addRating(new Rating("A",5));
        assertEquals(3.75,song1.bayesianAverageRating(2,3),0.001);

        Song song2 = new Song("Smart", "Chae", "1");
        song2.addRating(new Rating("A",1));
        song2.addRating(new Rating("A",1));
        song2.addRating(new Rating("A",1));
        song2.addRating(new Rating("A",1));
        assertEquals(1.0,song2.bayesianAverageRating(0,5),0.001);

        Song song3 = new Song("Smart", "Chae", "1");
        assertEquals(0.0,song3.bayesianAverageRating(0,0),0.001);

        Song song4 = new Song("Smart", "Chae", "1");
        song4.addRating(new Rating("A",-1));
        song4.addRating(new Rating("A",-1));
        assertEquals(0.0,song4.bayesianAverageRating(-3,-3),0.001);

        Song song5 = new Song("Smart", "Chae", "1");
        song5.addRating(new Rating("A",-1));
        song5.addRating(new Rating("A",-1));
        assertEquals(0.0,song5.bayesianAverageRating(5,-3),0.001);

        Song song6 = new Song("Smart", "Chae", "1");
        song6.addRating(new Rating("A",-50));
        song6.addRating(new Rating("A",-24));
        assertEquals(0.0,song6.bayesianAverageRating(0,1),0.001);

        Song song7 = new Song("Smart", "Chae", "1");
        song7.addRating(new Rating("A",3));
        song7.addRating(new Rating("A",5));
        assertEquals(4,song7.bayesianAverageRating(0,1),0.001);

        Song song8 = new Song("hello","welcome","to");
        Rating d = new Rating("dude",187);
        song8.addRating(d);
        song8.addRating(d);
        song8.addRating(d);

        assertEquals(0.0,song8.bayesianAverageRating(3,-2),0.001);
        assertEquals(2.0,song8.bayesianAverageRating(3,2),0.001);
        assertEquals(0.0,song6.bayesianAverageRating(3,-2),0.001);

    }
    @Test
    public void invalid(){
        Song song8 = new Song("hello","welcome","to");
        Rating d = new Rating("dude",187);
        Rating v = new Rating("dude",17);
        song8.addRating(d);
        song8.addRating(d);
        song8.addRating(d);
        song8.addRating(v);
        song8.addRating(v);

        assertEquals(0.0,song8.bayesianAverageRating(3,-2),0.001);
        assertEquals(0.0,song8.bayesianAverageRating(3,0),0.001);
        assertEquals(2.0,song8.bayesianAverageRating(3,2),0.001);
        assertEquals(0.0,song8.bayesianAverageRating(0,3),0.001);


    }

    @Test
    public void testAgain(){
        Song song1 = new Song("Smart", "Chae", "1");
        Song song2 = new Song("Smart", "Chae", "1");
        Song song3 = new Song("Smart", "Chae", "1");
        Rating rate1 = new Rating("A",2);
        Rating rate2 = new Rating("A",4);
        Rating rate3 = new Rating("A",5);
        Rating rate4 = new Rating("A",2);
        Rating rate5 = new Rating("A",2);
        Rating rate6 = new Rating("A",232);
        song1.addRating(rate1);
        song1.addRating(rate2);
        song1.addRating(rate3);
        song2.addRating(rate2);
        song2.addRating(rate3);

        assertEquals(2.83,song1.bayesianAverageRating(3,2),0.01);
        assertEquals(0.0,song1.bayesianAverageRating(-1,2),0.01);
        assertEquals(0.0,song1.bayesianAverageRating(3,0),0.01);
        assertEquals(4.5,song2.bayesianAverageRating(0,3),0.01);
        assertEquals(2.83,song1.bayesianAverageRating(3,2),0.01);
        assertEquals(0.0,song3.bayesianAverageRating(0,2),0.01);




    }
}
