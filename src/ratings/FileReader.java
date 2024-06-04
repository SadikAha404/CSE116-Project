package ratings;

import java.io.IOException;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;


public class FileReader {
    public static ArrayList<Song> readSongs(String fileName){
    ArrayList<Song> allSongs = new ArrayList<>();
        try {
        ArrayList<String> allLines = new ArrayList<>(Files.readAllLines(Paths.get(fileName)));
        for (String line : allLines) {
            String[] lineValues = line.split(",");
                String songIdentifier = lineValues[0];
                String musicArtist = lineValues[1];
                String songTitle = lineValues[2];
                String reviewerIdentifier = lineValues[3];
                int songRating = Integer.parseInt(lineValues[4]);
                boolean doesSongExist = false;
                for (Song song : allSongs) {
                    if (song.getSongID().equals(songIdentifier)) {
                        song.addRating(new Rating(reviewerIdentifier, songRating));
                        doesSongExist = true;
                        break;
                    }
                }
                if (!doesSongExist) {
                    Song newSong = new Song(songTitle, musicArtist, songIdentifier);
                    newSong.addRating(new Rating(reviewerIdentifier, songRating));
                    allSongs.add(newSong);
                }

        }
    } catch (IOException e) {
            return new ArrayList<Song>();
        }
        return allSongs;
}

    public static ArrayList<Movie> readMovies(String fileName){
        ArrayList<Movie> allMovies = new ArrayList<>();
        try {
            ArrayList<String> allLine = new ArrayList<>(Files.readAllLines(Paths.get(fileName)));
            for (String line : allLine) {
                String[] lineSections = line.split(",");
                String movieTitle = lineSections[0];
                ArrayList<String> allCast = new ArrayList<>(Arrays.asList(lineSections).subList(1, lineSections.length));
                allMovies.add(new Movie(movieTitle,allCast));
            }
        }
        catch (IOException e) {
            return new ArrayList<Movie>();

        }
        return allMovies;
    }


    public static ArrayList<Movie> readMovieRatings(ArrayList<Movie> movies, String fileName) {
        ArrayList<String> lines = readFile(fileName);
        ArrayList<Movie> movies1 = new ArrayList<>();
        for (String line : lines) {
            ArrayList<String> cut = new ArrayList<>(Arrays.asList(line.split(",")));
            String title=cut.get(0);
            String reviewerId=cut.get(1);
            int rate= Integer.parseInt(cut.get(2));
            Rating temp = new Rating(reviewerId,rate);
            for(Movie movie : movies){
                if (movie.getTitle().equals(title)){
                    movie.addRating(temp);
                }
            }
        }
        for (Movie movie : movies){
            if (movie.getRatings() != null){
                movies1.add(movie);
            }
        }
        return movies1;
    }
    public static ArrayList<String> readFile(String filename) {
        try {
            return new ArrayList<>(Files.readAllLines(Paths.get(filename)));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }


























}
