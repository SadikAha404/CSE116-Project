package ratings;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MediaLibrary {
    private ArrayList<Ratable> allMediaLibrary;

    public MediaLibrary(){
        this.allMediaLibrary = new ArrayList<>();
    }
    public void populateLibrary(String songWRating, String movies, String movieRatings){
        ArrayList<Song> allSongs = FileReader.readSongs(songWRating);
        ArrayList<Movie> allMovies = FileReader.readMovies(movies);
        ArrayList<Movie> allRatings = FileReader.readMovieRatings(allMovies,movieRatings);
        allMediaLibrary.addAll(allSongs);
        allMediaLibrary.addAll(allRatings);
    }

    public ArrayList<Ratable> topKRatables(int k){
        ArrayList<Ratable> ratables = new ArrayList<>(allMediaLibrary);
        for (int i =0;i<ratables.size()-1;i++){
            for (int j = 0; j < ratables.size() - i - 1; j++){
                Ratable ratableOne = ratables.get(j);
                Ratable ratableTwo = ratables.get(j+1);
                double ratingAvgOne = ratableOne.bayesianAverageRating(2,3);
                double ratingAvgTwo = ratableTwo.bayesianAverageRating(2,3);
                if (ratingAvgOne<ratingAvgTwo){
                    Ratable temp = ratableOne;
                    ratables.set(j,ratableTwo);
                    ratables.set(j+1,temp);
                }
            }
        }
        if(k> ratables.size()){
            return ratables;
        }
        ArrayList<Ratable> topRatables = new ArrayList<>();
        for (int i = 0; i < k; i++){
            topRatables.add(ratables.get(i));
        }
        return topRatables;
    }


}
