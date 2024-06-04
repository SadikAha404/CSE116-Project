package tests;

import org.junit.Test;
import ratings.MediaLibrary;
import ratings.Ratable;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestClasses3 {

    MediaLibrary mediaLibrary = new MediaLibrary();
    public boolean compareRatableArrayLists(ArrayList<Ratable> one, ArrayList<Ratable> two){
        if (one.size() != two.size()) {
            return false;
        }

        for (int i = 0; i < one.size(); i++) {
            if (!one.get(i).getTitle().equals(two.get(i).getTitle())) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void testPopulateLibrary(){
        mediaLibrary.populateLibrary("data/songs.csv","data/movies.csv", "data/movie_ratings.csv");
        ArrayList<Ratable> topFiveRatables = mediaLibrary.topKRatables(5);

        assertEquals(5, topFiveRatables.size());


        //System.out.println(topFiveRatables.get(0).getTitle());
        //System.out.println(topFiveRatables.get(1).getTitle());
        //System.out.println(topFiveRatables.get(2).getTitle());
        //System.out.println(topFiveRatables.get(3).getTitle());
        //System.out.println(topFiveRatables.get(4).getTitle());


        assertEquals("SpongeBob SquarePants Theme Song",topFiveRatables.get(0).getTitle());
        assertEquals("Telekinesis",topFiveRatables.get(1).getTitle());
        assertEquals("MELTDOWN",topFiveRatables.get(2).getTitle());
        assertEquals("Laura",topFiveRatables.get(3).getTitle());
        assertEquals("Sleepless in Seattle",topFiveRatables.get(4).getTitle());

    }




}
