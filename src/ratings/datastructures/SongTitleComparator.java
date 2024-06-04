package ratings.datastructures;

import ratings.Song;

public class SongTitleComparator extends Comparator<Song>{

    @Override
    public boolean compare(Song song1, Song song2) {
        int result = song1.getTitle().compareToIgnoreCase(song2.getTitle());

        if (result<0){
            return true;
        }
        else if(result>0){
            return false;
        }
        else{
            return false;
        }
    }
}
