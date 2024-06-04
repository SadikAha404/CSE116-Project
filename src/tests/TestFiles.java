package tests;

import org.junit.Test;
import ratings.FileReader;
import ratings.Movie;
import ratings.Rating;
import ratings.Song;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import static org.junit.Assert.*;

public class TestFiles {

    TestDataStructures1 temp = new TestDataStructures1();
    public boolean compareMovieArrayLists(ArrayList<Movie> moviesList1, ArrayList<Movie> moviesList2) {
        if (moviesList1 == null || moviesList2 == null || moviesList1.size() != moviesList2.size()) {
            return false;
        }

        for (Movie movie1 : moviesList1) {
            boolean out = false;
            for (Movie movie2 : moviesList2) {
                if (Objects.equals(movie1.getTitle(), movie2.getTitle())
                        && Objects.equals(movie1.getCast(), movie2.getCast())
                        && temp.compareListsOfRatings(movie1.getRatings(),movie2.getRatings())) {
                    out = true;
                    break;
                }
            }
            if (!out) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void testSongProperties() {
        ArrayList<Song> songs = FileReader.readSongs("data/My_songs.csv");
        assertEquals(1, songs.size());
        Song song = songs.get(0);
        Song song2 = new Song("Title1","Artist1","1");
        song2.addRating(new Rating("Reviewer1",5));
        assertEquals("Artist1", song.getArtist());
        assertEquals("Title1", song.getTitle());
        assertEquals("444", song.getSongID());
        assertTrue(temp.compareListsOfRatings(song.getRatings(),song2.getRatings()));

        ArrayList<Song> songs2 = FileReader.readSongs("data/song2.csv");
        assertEquals(1, songs2.size());
        Song songs3 = songs2.get(0);
        assertFalse(temp.compareListsOfRatings(song.getRatings(),songs3.getRatings()));
        Song newSong = new Song("Title1","Artist1","444");
        newSong.addRating(new Rating("Reviewer1",5));
        newSong.addRating(new Rating("Reviewer2",5));
        newSong.addRating(new Rating("Reviewer3",5));
        newSong.addRating(new Rating("Reviewer4",5));
        newSong.addRating(new Rating("Reviewer5",5));
        assertTrue(temp.compareListsOfRatings(songs3.getRatings(),newSong.getRatings()));

    }

    public boolean moviesEqual(Movie movie1, Movie movie2) {
        assertTrue(Objects.equals(movie1.getTitle(), movie2.getTitle()));
        assertTrue(Objects.equals(movie1.getCast(), movie2.getCast()));
        TestDataStructures1 temp = new TestDataStructures1();
        assertTrue(temp.compareListsOfRatings(movie1.getRatings(),movie2.getRatings()));
        return true;
    }



    @Test
    public void testReadSongs() {
        ArrayList<Song> songs = ratings.FileReader.readSongs("data/My_songs.csv");
        assertTrue(songs != null && !songs.isEmpty());
    }

    @Test
    public void testMovieRatings(){
        TestClasses2 tester = new TestClasses2();
        ArrayList<Movie> ratings = FileReader.readMovieRatings(FileReader.readMovies("data/movies.csv"),"data/movie_ratings.csv");
        ArrayList<Movie> movies = FileReader.readMovies("data/movies.csv");

        ArrayList<Movie> ratings1 = FileReader.readMovieRatings(FileReader.readMovies("data/movides.csv"),"data/movie_ratdsings.csv");
        assertTrue(ratings1.isEmpty());

        assertFalse(compareMovieArrayLists(ratings,movies));


        Movie movie3 = new Movie("Anatomy of a Murder",new ArrayList<String>(Arrays.asList("James Stewart","Ben Gazzara","Arthur O'Connell","George C. Scott","Murray Hamilton","John Qualen")));
        movie3.addRating(new Rating("80",1));
        movie3.addRating(new Rating("128",1));
        movie3.addRating(new Rating("168",2));
        movie3.addRating(new Rating("188",3));
        movie3.addRating(new Rating("243",2));
        movie3.addRating(new Rating("285",2));
        movie3.addRating(new Rating("308",3));
        movie3.addRating(new Rating("353",1));
        movie3.addRating(new Rating("396",4));
        movie3.addRating(new Rating("564",2));
        movie3.addRating(new Rating("607",3));

        boolean d = false;
        for (Movie mr : ratings){
            if (mr.getTitle().equals(movie3.getTitle()) && compareArrayLists(mr.getCast(),movie3.getCast())){
                assertTrue(temp.compareListsOfRatings(mr.getRatings(),movie3.getRatings()));
            }
            if (mr.getTitle().equals("What About Bob?")){
                assertTrue(d);
            }
            if (mr.getTitle().equals("Everything You Always Wanted to Know About Sex *But Were Afraid to Ask")){
                assertTrue(d);
            }
            if (mr.getTitle().equals("Hollow Man")){
                assertTrue(d);
            }
            if (mr.getTitle().equals("Space Cowboys")){
                assertTrue(d);
            }
            assertNotEquals(mr.getTitle(),"What About Bob?");
            assertNotEquals(mr.getTitle(),"Everything You Always Wanted to Know About Sex *But Were Afraid to Ask");
            assertNotEquals(mr.getTitle(),"Hollow Man");
            assertNotEquals(mr.getTitle(),"Space Cowboys");
            assertNotEquals(mr.getTitle(),"Toy Story");
            assertNotEquals(mr.getTitle(),"Jumanji");
        }


        Movie temp4 = new Movie("Leaving Las Vegas",new ArrayList<>(Arrays.asList("Nicolas Cage","Elisabeth Shue","Julian Sands","Richard Lewis","Steven Weber","Valeria Golino","Graham Beckel","Laurie Metcalf","Shawnee Smith")));
        temp4.addRating(new Rating("19",3));
        temp4.addRating(new Rating("30",4));
        temp4.addRating(new Rating("322",4));
        temp4.addRating(new Rating("518",1));
        temp4.addRating(new Rating("547",3));
        temp4.addRating(new Rating("564",4));
        temp4.addRating(new Rating("597",5));
        for (Movie m : ratings) {
            if (m.getTitle().equals(temp4.getTitle()) && compareArrayLists(m.getCast(), temp4.getCast())){
                assertTrue(temp.compareListsOfRatings(m.getRatings(), temp4.getRatings()));
            }
        }

    }


    @Test
    public void testMultipleSongs() {
        ArrayList<Song> songs = FileReader.readSongs("data/multipleSongs.csv");

        assertEquals(5, songs.size());
    }


    @Test
    public void testMultipleMovies() {

        ArrayList<Movie> movies = FileReader.readMovies("data/multipleMovies.csv");
        ArrayList<Movie> movies1 = FileReader.readMovieRatings(movies, "data/multipleMovieRatings.csv");

        assertEquals(3, movies1.size());

    }

    @Test
    public void testInvalidFilename() {
        ArrayList<Song> songs = FileReader.readSongs("doesNotExist.csv");

        assertEquals(0, songs.size());

        ArrayList<Movie> movies = FileReader.readMovies("data/multipleMovies.csv");

        ArrayList<Movie> movie = FileReader.readMovieRatings(movies,"doesNotEsist.csv");

        assertEquals(0,movie.size());
        ArrayList<Movie> movie2 = FileReader.readMovies("doesNotEsist.csv");
        assertEquals(0,movie2.size());

    }

    @Test
    public void testReadMovies() {
        String filename = "data/movies_test.csv";
        ArrayList<Movie> movies = ratings.FileReader.readMovies("data/movies.csv");
        assertTrue(movies != null && !movies.isEmpty());
    }

    @Test public void testCompareMovieArrayLists(){
        ArrayList<Movie> movies = FileReader.readMovies("data/TestingMovie.csv");
        ArrayList<Movie> movies1 = new ArrayList<>();
        movies1.add(new Movie("Toy Story",new ArrayList<String>(Arrays.asList("Tom Hanks","Tim Allen","Don Rickles","Wallace Shawn","John Ratzenberger","Annie Potts","John Morris","Laurie Metcalf","R. Lee Ermey","Penn Jillette"))));
        movies1.add(new Movie("Jumanji",new ArrayList<String>(Arrays.asList("Robin Williams","Jonathan Hyde","Kirsten Dunst","Bonnie Hunt","Bebe Neuwirth","David Alan Grier","Patricia Clarkson","James Handy","Malcolm Stewart","Darryl Henriques"))));
        movies1.add(new Movie("Father of the Bride Part II",new ArrayList<String>(Arrays.asList("Steve Martin","Diane Keaton","Martin Short","Kimberly Williams-Paisley","George Newbern","Kieran Culkin","BD Wong","Peter Michael Goetz","Kate McGregor-Stewart","Jane Adams","Eugene Levy","Lori Alan"))));
        movies1.add(new Movie("Heat",new ArrayList<String>(Arrays.asList("Al Pacino","Robert De Niro","Val Kilmer","Jon Voight","Tom Sizemore","Diane Venora","Amy Brenneman","Ashley Judd","Mykelti Williamson","Natalie Portman","Ted Levine","Tom Noonan","Hank Azaria","Wes Studi","Dennis Haysbert","Danny Trejo","Henry Rollins","William Fichtner","Kevin Gage","Susan Traylor","Jeremy Piven","Xander Berkeley","Begonya Plaza","Rick Avery","Steven Ford","Paul Herman","Brian Libby","Thomas Rosales Jr.","Yvonne Zima","Bud Cort","Martin Ferrero","Robert Miranda","Philip Ettington"))));

        assertTrue(compareMovieArrayLists(movies,movies1));

        ArrayList<Movie> difMovie1 = FileReader.readMovies("data/multipleMovies.csv");
        ArrayList<Movie> difMovie2 = FileReader.readMovies("data/TestingMovie.csv");
        assertFalse(compareMovieArrayLists(difMovie1,difMovie2));
    }

    public static ArrayList<String> readFile1(String filename){
        try {
            return new ArrayList<>(Files.readAllLines(Paths.get(filename)));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
    private  <T> boolean compareArrayLists(ArrayList<T> list1, ArrayList<T> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }

        for (T item : list1) {
            if (!list2.contains(item)) {
                return false;
            }
        }

        return true;
    }


}