package tests;

import org.junit.Test;
import ratings.DegreesOfSeparation;
import ratings.Movie;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TestDataStructures3 {

    @Test
    public void testDegreeOgSeparation(){
        Movie movie1 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("Ben Gazzara","Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));
        Movie movie2 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("Ben Gazzara","Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));
        Movie movie3 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("Ben Gazzara","Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));
        Movie movie4 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("James Stewart","Ben Gazzara","Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));

        ArrayList<Movie> movies = new ArrayList<>();

        DegreesOfSeparation temp = new DegreesOfSeparation(movies);

        //System.out.println(temp.degreesOfSeparation("James Stewart", "Ben Gazzara"));
        assertEquals(-1,temp.degreesOfSeparation("James Stewart", "Ben Gazzara"));

    }

    @Test
    public void testTwo(){
        Movie movie1 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("Ben Gazzara","Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));
        Movie movie2 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("Ben Gazzara","Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));
        Movie movie3 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("Ben Gazzara","Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));
        Movie movie4 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("James Stewart","Ben Gazzara","Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));

        ArrayList<Movie> movies = new ArrayList<>();

        DegreesOfSeparation temp = new DegreesOfSeparation(movies);

        //System.out.println(temp.degreesOfSeparation("James Stewart", "James Stewart"));
        assertEquals(0,temp.degreesOfSeparation("James Stewart", "James Stewart"));
    }
    @Test
    public void testThree(){
        Movie movie1 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("Ben Gazzara","Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));
        Movie movie2 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));
        Movie movie3 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));
        Movie movie4 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("Ben Gazzara","Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));
        Movie movie5 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("Ben Gazzara","Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));
        Movie movie6 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("Ben Gazzara","Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));
        Movie movie7 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("James Stewart","Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);
        movies.add(movie6);
        movies.add(movie7);

        DegreesOfSeparation temp = new DegreesOfSeparation(movies);

        //System.out.println(temp.degreesOfSeparation("James Stewart", "Ben Gazzara"));
        assertEquals(2,temp.degreesOfSeparation("James Stewart", "Ben Gazzara"));
    }

    @Test
    public void testFour(){
        Movie movie1 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("Ben Gazzara","Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));
        Movie movie2 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("James Stewart","Ben Gazzara","Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));
        Movie movie3 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));
        Movie movie4 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("Ben Gazzara","Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));
        Movie movie5 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("Ben Gazzara","Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));
        Movie movie6 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("Ben Gazzara","Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));
        Movie movie7 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("James Stewart","Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);
        movies.add(movie6);
        movies.add(movie7);

        DegreesOfSeparation temp = new DegreesOfSeparation(movies);

        //System.out.println(temp.degreesOfSeparation("James Stewart", "Ben Gazzara"));
        assertEquals(1,temp.degreesOfSeparation("James Stewart", "Ben Gazzara"));
    }

    @Test
    public void testFive(){
        Movie movie1 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("Ben Gazzara","James Stewart")));
        Movie movie2 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("James Stewart","Arthur O'Connell")));

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);

        DegreesOfSeparation temp = new DegreesOfSeparation(movies);

        //System.out.println(temp.degreesOfSeparation("Ben Gazzara", "Ben Gazzara"));
        //System.out.println(temp.degreesOfSeparation("Ben Gazzara", "James Stewart"));
        //System.out.println(temp.degreesOfSeparation("Ben Gazzara", "Arthur O'Connell");
        //System.out.println(temp.degreesOfSeparation("George C. Scott", "James Stewart"));
        assertEquals(0,temp.degreesOfSeparation("Ben Gazzara", "Ben Gazzara"));
        assertEquals(1,temp.degreesOfSeparation("Ben Gazzara", "James Stewart"));
        assertEquals(2,temp.degreesOfSeparation("Ben Gazzara", "Arthur O'Connell"));
        assertEquals(-1,temp.degreesOfSeparation("George C. Scott", "James Stewart"));
    }



}
