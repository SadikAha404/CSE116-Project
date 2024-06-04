package ratings.datastructures;

import ratings.Song;

public class SongBayesianRatingComparator extends Comparator<Song>{
    @Override
    public boolean compare(Song song1, Song song2){
        if(song1.bayesianAverageRating(2,3)>song2.bayesianAverageRating(2,3)){
            return true;
        }
        else {
            return false;
        }
    }
}
