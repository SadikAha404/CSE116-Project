package ratings;

import ratings.datastructures.LinkedListNode;

import java.sql.SQLOutput;
import java.util.Objects;

public class Song extends Ratable{

    private String artist;
    private String SongID;

    public Song(String title, String artist, String SongID){
        this.setTitle(title);
        this.artist = artist;
        this.SongID = SongID;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setSongID(String songID) {
        SongID = songID;
    }

    public String getSongID() {
        return SongID;
    }


}
